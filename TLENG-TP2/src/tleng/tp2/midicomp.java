package tleng.tp2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import tleng.tp2.MusilengParser.Compas;
import tleng.tp2.MusilengParser.IndicacionCompas;
import tleng.tp2.MusilengParser.Nota;
import tleng.tp2.MusilengParser.NotaEnum;
import tleng.tp2.MusilengParser.Partitura;
import tleng.tp2.MusilengParser.Voz;
import static tleng.tp2.MusilengParser.clicksPorFigura;


public class midicomp {

	private static final String USAGE = "Usage : ./midicomp -c entrada.txt salida.midi";

	public static void main(String[] args) throws IOException {

		if (args.length != 3) {
			System.out.println(USAGE);
		} else {
			if (!args[0].equals("-c")) {
				System.out.println(USAGE);
			} else {
				String inFile = args[1];
				String midiFile = args[2];
				CharStream charStream = new ANTLRFileStream(inFile);
				MusilengLexer lexer = new MusilengLexer(charStream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				MusilengParser parser = new MusilengParser(tokenStream);
				parser.setErrorHandler(new ErrorStrategy());
				try {
					Partitura partitura = parser.s().partitura;					
					PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(midiFile)));
					
					//Encabezado
					int NTRACKS = partitura.voces.size()+1;
					double midi_tempo = 1000000 * 60 * (4/ NotaEnum.valueOf(partitura.tempo.duracion).getDuracion()) / (4 * partitura.tempo.cantidad);
					String midi_bar = String.format("%s/%s", partitura.indicacion.tiempos, partitura.indicacion.tipoNota);
					writer.println(String.format("MFile 1 %d 384", NTRACKS));
					writer.println(String.format("MTrk"));
					writer.println(String.format("000:00:000 Tempo %.0f",midi_tempo));
					writer.println(String.format("000:00:000 TimeSig %s 24 8",midi_bar));
					writer.println("000:00:000 Meta TrkEnd");
					writer.println("TrkEnd");
					
					int i = 1;
					for (Voz voz : partitura.voces) {
						generarTrack(voz, i, partitura.indicacion, 384, writer);
						i = i + 1;
					}
					
					writer.flush();
					writer.close();
				} catch (RuntimeException e) {
					System.err.println(e.getMessage());
					return;
				}
				
			}
		}
			
	}

	private static void generarTrack(Voz voz, int voice_number,
			IndicacionCompas indicacion, int clicks_per_beat, PrintWriter writer) {
		writer.println("MTrk");
		writer.println(String.format("000:00:000 Meta TrkName \"Voz %s\"",voice_number));
		writer.println(String.format("000:00:000 ProgCh ch=%d prog=%d",voice_number,voz.instrumento));
		int bar_num = 0;
		int beat_num = 0;
		int click_num = 0;
		
		for(Compas compas : voz.compases) {
			for(Nota nota : compas.notas) {
				if(!nota.isSilencio()) {
					writer.println(String.format("%03d:%02d:%03d On ch=%s note=%s vol=70",bar_num,beat_num, click_num, voice_number, nota.notacionAmericana()));
					int click_figure = clicksPorFigura(nota.duracion, indicacion);
					int temp_click = click_num + click_figure;
					click_num = temp_click % clicks_per_beat;
					int temp_beat = beat_num + (temp_click / clicks_per_beat);
					beat_num = temp_beat % indicacion.tiempos;
					bar_num = bar_num + (temp_beat / indicacion.tiempos);
					writer.println(String.format("%03d:%02d:%03d Off ch=%d note=%s vol=0",bar_num, beat_num,click_num, voice_number, nota.notacionAmericana()));
				} else {
					int click_figure = clicksPorFigura(nota.duracion, indicacion);
					int temp_click = click_num + click_figure;
					click_num = temp_click % clicks_per_beat;
					int temp_beat = beat_num + (temp_click / clicks_per_beat);
					beat_num = temp_beat % indicacion.tiempos;
					bar_num = bar_num + (temp_beat / indicacion.tiempos);
				}				
			}
		}
		writer.println(String.format("%03d:%02d:%03d Meta TrkEnd",bar_num, beat_num, click_num));
		writer.println("TrkEnd");
	}

}
