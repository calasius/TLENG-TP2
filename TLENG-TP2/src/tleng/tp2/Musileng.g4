grammar Musileng;

import lexerGrammar;

@parser::header {
	import java.util.HashMap;
	import java.util.Map;
	import java.util.List;
	import java.util.ArrayList;
}

@parser::members {
	private Map<String,Integer> constantes = new HashMap<String,Integer>();
	
	public static final int CLICKS_POR_PULSO = 384;
	
	private boolean agregarConstante(String nombre, String valor) {
		if (constantes.containsKey(valor)) {
			constantes.put(nombre,constantes.get(valor));
			return true;
		} else {
			return false;
		}
	}
	
	public static int clicksPorFigura(String altura, IndicacionCompas indicacion) {
		NotaEnum figura = NotaEnum.valueOf(altura);
		int clicksPorRedonda = CLICKS_POR_PULSO * indicacion.tipoNota;
		return clicksPorRedonda / Double.valueOf(4 / figura.getDuracion()).intValue();
	}
	
	private boolean agregarConstante(String nombre, Integer valor) {
		if (constantes.containsKey(nombre)) {
			return false;
		}
		constantes.put(nombre, valor);
		return true;
	}
	
	private boolean validarRepeticiones(int valor) {
		return valor > 0;
	}
	
	private boolean validarDuracion(List<Nota> notas, IndicacionCompas indicacion) {
		Double duracion = 0.0;
		for(Nota nota : notas) {
			duracion += nota.calcularDuracion();
		}
		return duracion.compareTo(indicacion.duracion()) == 0;
	}
	
	private boolean validarAlMenosUnCompas(List<Compas> listaCompases) {
		return !listaCompases.isEmpty();
	}
	
	private boolean validarInstrumento(int instrumento) {
		return instrumento >= 0 && instrumento <= 127;
	}
		
	private boolean validarTempo(Tempo tempo) {
		return true;
	}
	
	private void agregarRepetidos(List<Compas> listaCompases, List<Compas> nuevos, int repeticiones) {
		for (int i = 0; i < repeticiones; i++) {
			listaCompases.addAll(nuevos);
		}
	}
	
	public static class IndicacionCompas {
		public int tiempos;
		public int tipoNota;
		public IndicacionCompas(int tiempos, int tipoNota) {
			this.tiempos = tiempos;
			this.tipoNota = tipoNota;
		}
		
		public Double duracion() {
			return tiempos * Double.valueOf(4 / Double.valueOf(tipoNota));
		}
	}
	
	public static class Nota {
		public String duracion;
		public String altura;
		public String alteracion;
		public Integer octava;
		boolean tienePuntillo;
		public Nota(String altura, Integer octava, String duracion, boolean tienePuntillo) {
			this.altura = altura;
			this.octava = octava;
			this.duracion = duracion;
			this.alteracion = alteracion;
			this.tienePuntillo = tienePuntillo;
		}
		
		public Double calcularDuracion() {
			Double duracionNota = NotaEnum.valueOf(this.duracion).getDuracion();
			return duracionNota + (this.tienePuntillo? duracionNota /2 : 0.0);
		}
		
		public boolean isSilencio() {
			return altura == null;
		}
		
		public String notacionAmericana() {
			return NotacionAmericana.notacionAmericana(this.altura)+octava;
		}
		
		public String toString() {
			if (altura != null) {
				return String.format("Nota(%s,%s,%s,%s,%s)", altura, octava, duracion, alteracion, tienePuntillo);			
			} else {
				return String.format("Silencio(%s, %s)", this.duracion, this.tienePuntillo);
			}
		}
		
	}
	
	public enum NotaEnum {
		redonda(1.0),blanca(2.0), negra(1.0),corchea(1/2.0),semicorchea(1/4.0),fusa(1/8.0),semifusa(1/16.0);
		
		private Double duracion;
		
		private NotaEnum(Double duracion) {
			this.duracion = duracion;
		}
		
		public Double getDuracion() {
			return this.duracion;
		}
	}
	
	public static class NotacionAmericana {
		private static Map<String,String> notacionAmericana = new HashMap<String,String>();
		static {
			notacionAmericana.put("do" , "c");
			notacionAmericana.put("re" , "d");
			notacionAmericana.put("mi" , "e");
			notacionAmericana.put("fa" , "f");
			notacionAmericana.put("sol" , "g");
			notacionAmericana.put("la" , "a");
			notacionAmericana.put("si" , "b");
			notacionAmericana.put("do+" , "c+");
			notacionAmericana.put("do" , "c");
			notacionAmericana.put("re+" , "d+");
			notacionAmericana.put("fa+" , "f+");
			notacionAmericana.put("sol+" , "g+");
			notacionAmericana.put("la+" , "a+");
			notacionAmericana.put("re-" , "d-");
			notacionAmericana.put("mi-" , "e-");
			notacionAmericana.put("sol-" , "g-");
			notacionAmericana.put("la-" , "a-");
			notacionAmericana.put("si-" , "b-");				
		}
		
		public static String notacionAmericana(String altura) {
			return notacionAmericana.get(altura);
		}
	}
	
	public static class Compas {
		public List<Nota> notas;
		public Compas() {
			this.notas = new ArrayList<Nota>();
		}
		public String toString() {
			return notas.toString();
		}
	}
	
	public static class Voz {
		public int instrumento;
		public List<Compas> compases;
		public Voz(int instrumento, List<Compas> compases) {
			this.instrumento = instrumento;
			this.compases = compases;
		}
		public String toString() {
			return String.format("Voz(instrumento = %s, compaces = {%s})", this.instrumento, this.compases);
		}
	}
	
	public static class Melodia {
		public List<Voz> voces;
		public Melodia(List<Voz> voces) {
			this.voces = voces;
		}
	}
	
	public static class Tempo {
		public String duracion;
		public int cantidad;
		public Tempo(String duracion, int cantidad) {
			this.duracion = duracion;
			this.cantidad = cantidad;
		}
		
		public String toString() {
			return String.format("Tempo = (%s, %s)", cantidad, duracion);
		}
	}
	
	public static class Partitura {
		public Tempo tempo;
		public IndicacionCompas indicacion;
		public List<Voz> voces;
		public Partitura(Tempo tempo, IndicacionCompas indicacion, List<Voz> voces) {
			this.tempo = tempo;
			this.voces = voces;
			this.indicacion = indicacion;
		}
		
		public String toString() {
			return String.format("%s; voces = %s", this.tempo, voces);
		}
	}
}

//Gramatica 
s returns[Partitura partitura]: tempos elcompas constantes melodia[$elcompas.indicacion] {$partitura = new Partitura($tempos.tempo, $elcompas.indicacion, $melodia.voces);};

tempos returns[Tempo tempo]: '#tempo' DURACION NUM {$tempo = new Tempo($DURACION.text, $NUM.int);}{validarTempo($tempo)}? ;

elcompas returns [IndicacionCompas indicacion] : '#compas' n1 = NUM'/' n2 = NUM {$indicacion = new IndicacionCompas($n1.int,$n2.int);};

constantes: constante*;

constante: 'const' n1 = NOMBRE'='(NUM {agregarConstante($n1.text, $NUM.int)}?|n2 = NOMBRE{agregarConstante($n1.text, $n2.text)}?)';';

melodia[IndicacionCompas indicacion] returns[List<Voz> voces] locals[int instrumento]: {$voces = new ArrayList<Voz>();} 
		('voz''('(NUM {$instrumento = $NUM.int;}|NOMBRE {constantes.containsKey($NOMBRE.text)}? {$instrumento = constantes.get($NOMBRE.text);})')'
		'{'compases[$indicacion]'}' {validarAlMenosUnCompas($compases.listaCompases)}? {$voces.add(new Voz($instrumento, $compases.listaCompases));} )+ ;

compases[IndicacionCompas indicacion] returns[List<Compas> listaCompases] : 
		{$listaCompases = new ArrayList<Compas>();} compas[$indicacion] {$listaCompases.add($compas.compasObj);} compases[$indicacion] | 
		{$listaCompases = new ArrayList<Compas>();} repeticion[$indicacion] {agregarRepetidos($listaCompases,$repeticion.listaCompases,$repeticion.repeticiones);} compases[$indicacion] | ;

repeticion[IndicacionCompas indicacion] returns [List<Compas> listaCompases, int repeticiones]:
		{$listaCompases = new ArrayList<Compas>();} 'repetir''('NUM {$NUM.int > 0}?')''{'compas[$indicacion]+ {$listaCompases.add($compas.compasObj);$repeticiones = $NUM.int;}'}';

compas[IndicacionCompas indicacion] returns[Compas compasObj]: 
		{$compasObj = new Compas();}'compas''{'(
			nota {$compasObj.notas.add($nota.notaObj);} |
			silencio {$compasObj.notas.add($silencio.silencioObj);}
		)+'}'{validarDuracion($compasObj.notas, $indicacion)}?;

silencio returns[Nota silencioObj]: 'silencio''('DURACION PUNTILLO?')'';' {$silencioObj = new Nota(null,null,$DURACION.text,$PUNTILLO != null ? true : false);};

nota returns[Nota notaObj] : 'nota''('ALTURA ',' octava ','DURACION PUNTILLO?')'';' {$notaObj = new Nota($ALTURA.text,$octava.valor,$DURACION.text, $PUNTILLO != null);};

octava returns[int valor]: OCTAVA {$valor = $OCTAVA.int;}| NOMBRE {$valor = constantes.get($NOMBRE.text);};
