// Generated from Musileng.g4 by ANTLR 4.4
package tleng.tp2;

	import java.util.HashMap;
	import java.util.Map;
	import java.util.List;
	import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MusilengParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		PUNTILLO=17, DURACION=18, ALTURA=19, NUM=20, NOMBRE=21, OCTAVA=22, WS=23, 
		COMENTARIOS=24;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'nota'", "'const'", "'#compas'", "'silencio'", "'repetir'", 
		"'#tempo'", "'{'", "';'", "'}'", "'voz'", "'='", "'compas'", "'('", "')'", 
		"','", "'.'", "DURACION", "ALTURA", "NUM", "NOMBRE", "OCTAVA", "WS", "COMENTARIOS"
	};
	public static final int
		RULE_s = 0, RULE_tempos = 1, RULE_elcompas = 2, RULE_constantes = 3, RULE_constante = 4, 
		RULE_melodia = 5, RULE_compases = 6, RULE_repeticion = 7, RULE_compas = 8, 
		RULE_silencio = 9, RULE_nota = 10, RULE_octava = 11;
	public static final String[] ruleNames = {
		"s", "tempos", "elcompas", "constantes", "constante", "melodia", "compases", 
		"repeticion", "compas", "silencio", "nota", "octava"
	};

	@Override
	public String getGrammarFileName() { return "Musileng.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public MusilengParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SContext extends ParserRuleContext {
		public Partitura partitura;
		public TemposContext tempos;
		public ElcompasContext elcompas;
		public MelodiaContext melodia;
		public TemposContext tempos() {
			return getRuleContext(TemposContext.class,0);
		}
		public ConstantesContext constantes() {
			return getRuleContext(ConstantesContext.class,0);
		}
		public ElcompasContext elcompas() {
			return getRuleContext(ElcompasContext.class,0);
		}
		public MelodiaContext melodia() {
			return getRuleContext(MelodiaContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitS(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); ((SContext)_localctx).tempos = tempos();
			setState(25); ((SContext)_localctx).elcompas = elcompas();
			setState(26); constantes();
			setState(27); ((SContext)_localctx).melodia = melodia(((SContext)_localctx).elcompas.indicacion);
			((SContext)_localctx).partitura =  new Partitura(((SContext)_localctx).tempos.tempo, ((SContext)_localctx).elcompas.indicacion, ((SContext)_localctx).melodia.voces);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemposContext extends ParserRuleContext {
		public Tempo tempo;
		public Token DURACION;
		public Token NUM;
		public TerminalNode NUM() { return getToken(MusilengParser.NUM, 0); }
		public TerminalNode DURACION() { return getToken(MusilengParser.DURACION, 0); }
		public TemposContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tempos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterTempos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitTempos(this);
		}
	}

	public final TemposContext tempos() throws RecognitionException {
		TemposContext _localctx = new TemposContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tempos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); match(T__9);
			setState(31); ((TemposContext)_localctx).DURACION = match(DURACION);
			setState(32); ((TemposContext)_localctx).NUM = match(NUM);
			((TemposContext)_localctx).tempo =  new Tempo((((TemposContext)_localctx).DURACION!=null?((TemposContext)_localctx).DURACION.getText():null), (((TemposContext)_localctx).NUM!=null?Integer.valueOf(((TemposContext)_localctx).NUM.getText()):0));
			setState(34);
			if (!(validarTempo(_localctx.tempo))) throw new FailedPredicateException(this, "validarTempo($tempo)");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElcompasContext extends ParserRuleContext {
		public IndicacionCompas indicacion;
		public Token n1;
		public Token n2;
		public List<TerminalNode> NUM() { return getTokens(MusilengParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(MusilengParser.NUM, i);
		}
		public ElcompasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elcompas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterElcompas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitElcompas(this);
		}
	}

	public final ElcompasContext elcompas() throws RecognitionException {
		ElcompasContext _localctx = new ElcompasContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_elcompas);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(T__12);
			setState(37); ((ElcompasContext)_localctx).n1 = match(NUM);
			setState(38); match(T__15);
			setState(39); ((ElcompasContext)_localctx).n2 = match(NUM);
			((ElcompasContext)_localctx).indicacion =  new IndicacionCompas((((ElcompasContext)_localctx).n1!=null?Integer.valueOf(((ElcompasContext)_localctx).n1.getText()):0),(((ElcompasContext)_localctx).n2!=null?Integer.valueOf(((ElcompasContext)_localctx).n2.getText()):0));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantesContext extends ParserRuleContext {
		public List<ConstanteContext> constante() {
			return getRuleContexts(ConstanteContext.class);
		}
		public ConstanteContext constante(int i) {
			return getRuleContext(ConstanteContext.class,i);
		}
		public ConstantesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterConstantes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitConstantes(this);
		}
	}

	public final ConstantesContext constantes() throws RecognitionException {
		ConstantesContext _localctx = new ConstantesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constantes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(42); constante();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstanteContext extends ParserRuleContext {
		public Token n1;
		public Token NUM;
		public Token n2;
		public TerminalNode NOMBRE(int i) {
			return getToken(MusilengParser.NOMBRE, i);
		}
		public List<TerminalNode> NOMBRE() { return getTokens(MusilengParser.NOMBRE); }
		public TerminalNode NUM() { return getToken(MusilengParser.NUM, 0); }
		public ConstanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constante; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterConstante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitConstante(this);
		}
	}

	public final ConstanteContext constante() throws RecognitionException {
		ConstanteContext _localctx = new ConstanteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constante);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(T__13);
			setState(49); ((ConstanteContext)_localctx).n1 = match(NOMBRE);
			setState(50); match(T__4);
			setState(55);
			switch (_input.LA(1)) {
			case NUM:
				{
				setState(51); ((ConstanteContext)_localctx).NUM = match(NUM);
				setState(52);
				if (!(agregarConstante((((ConstanteContext)_localctx).n1!=null?((ConstanteContext)_localctx).n1.getText():null), (((ConstanteContext)_localctx).NUM!=null?Integer.valueOf(((ConstanteContext)_localctx).NUM.getText()):0)))) throw new FailedPredicateException(this, String.format("La constante %s ya esta definida",((ConstanteContext)_localctx).n1.getText()));
				}
				break;
			case NOMBRE:
				{
				setState(53); ((ConstanteContext)_localctx).n2 = match(NOMBRE);
				setState(54);
				if (!(agregarConstante((((ConstanteContext)_localctx).n1!=null?((ConstanteContext)_localctx).n1.getText():null), (((ConstanteContext)_localctx).n2!=null?((ConstanteContext)_localctx).n2.getText():null)))) throw new FailedPredicateException(this, String.format("La constante %s no esta definida", ((ConstanteContext)_localctx).n2.getText()));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(57); match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MelodiaContext extends ParserRuleContext {
		public IndicacionCompas indicacion;
		public List<Voz> voces;
		public int instrumento;
		public Token NUM;
		public Token NOMBRE;
		public CompasesContext compases;
		public List<CompasesContext> compases() {
			return getRuleContexts(CompasesContext.class);
		}
		public TerminalNode NOMBRE(int i) {
			return getToken(MusilengParser.NOMBRE, i);
		}
		public List<TerminalNode> NUM() { return getTokens(MusilengParser.NUM); }
		public List<TerminalNode> NOMBRE() { return getTokens(MusilengParser.NOMBRE); }
		public TerminalNode NUM(int i) {
			return getToken(MusilengParser.NUM, i);
		}
		public CompasesContext compases(int i) {
			return getRuleContext(CompasesContext.class,i);
		}
		public MelodiaContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public MelodiaContext(ParserRuleContext parent, int invokingState, IndicacionCompas indicacion) {
			super(parent, invokingState);
			this.indicacion = indicacion;
		}
		@Override public int getRuleIndex() { return RULE_melodia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterMelodia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitMelodia(this);
		}
	}

	public final MelodiaContext melodia(IndicacionCompas indicacion) throws RecognitionException {
		MelodiaContext _localctx = new MelodiaContext(_ctx, getState(), indicacion);
		enterRule(_localctx, 10, RULE_melodia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((MelodiaContext)_localctx).voces =  new ArrayList<Voz>();
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60); match(T__5);
				setState(61); match(T__2);
				setState(67);
				switch (_input.LA(1)) {
				case NUM:
					{
					setState(62); ((MelodiaContext)_localctx).NUM = match(NUM);
					((MelodiaContext)_localctx).instrumento =  (((MelodiaContext)_localctx).NUM!=null?Integer.valueOf(((MelodiaContext)_localctx).NUM.getText()):0);
					}
					break;
				case NOMBRE:
					{
					setState(64); ((MelodiaContext)_localctx).NOMBRE = match(NOMBRE);
					setState(65);
					if (!(constantes.containsKey((((MelodiaContext)_localctx).NOMBRE!=null?((MelodiaContext)_localctx).NOMBRE.getText():null)))) throw new FailedPredicateException(this, String.format("No esta definida la constante %s", ((MelodiaContext)_localctx).NOMBRE.getText()));
					((MelodiaContext)_localctx).instrumento =  constantes.get((((MelodiaContext)_localctx).NOMBRE!=null?((MelodiaContext)_localctx).NOMBRE.getText():null));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(69); match(T__1);
				setState(70); match(T__8);
				setState(71); ((MelodiaContext)_localctx).compases = compases(_localctx.indicacion);
				setState(72); match(T__6);
				setState(73);
				if (!(validarAlMenosUnCompas(((MelodiaContext)_localctx).compases.listaCompases))) throw new FailedPredicateException(this, "Tiene que existir al menos un compas.");
				_localctx.voces.add(new Voz(_localctx.instrumento, ((MelodiaContext)_localctx).compases.listaCompases));
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompasesContext extends ParserRuleContext {
		public IndicacionCompas indicacion;
		public List<Compas> listaCompases;
		public CompasContext compas;
		public CompasesContext c1;
		public RepeticionContext repeticion;
		public CompasesContext compases() {
			return getRuleContext(CompasesContext.class,0);
		}
		public RepeticionContext repeticion() {
			return getRuleContext(RepeticionContext.class,0);
		}
		public CompasContext compas() {
			return getRuleContext(CompasContext.class,0);
		}
		public CompasesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CompasesContext(ParserRuleContext parent, int invokingState, IndicacionCompas indicacion) {
			super(parent, invokingState);
			this.indicacion = indicacion;
		}
		@Override public int getRuleIndex() { return RULE_compases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterCompases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitCompases(this);
		}
	}

	public final CompasesContext compases(IndicacionCompas indicacion) throws RecognitionException {
		CompasesContext _localctx = new CompasesContext(_ctx, getState(), indicacion);
		enterRule(_localctx, 12, RULE_compases);
		try {
			setState(92);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				((CompasesContext)_localctx).listaCompases =  new ArrayList<Compas>();
				setState(81); ((CompasesContext)_localctx).compas = compas(_localctx.indicacion);
				_localctx.listaCompases.add(((CompasesContext)_localctx).compas.compasObj);
				setState(83); ((CompasesContext)_localctx).c1 = compases(_localctx.indicacion);
				 _localctx.listaCompases.addAll(((CompasesContext)_localctx).c1.listaCompases);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				((CompasesContext)_localctx).listaCompases =  new ArrayList<Compas>();
				setState(87); ((CompasesContext)_localctx).repeticion = repeticion(_localctx.indicacion);
				agregarRepetidos(_localctx.listaCompases,((CompasesContext)_localctx).repeticion.listaCompases,((CompasesContext)_localctx).repeticion.repeticiones);
				setState(89); compases(_localctx.indicacion);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				((CompasesContext)_localctx).listaCompases =  new ArrayList<Compas>();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeticionContext extends ParserRuleContext {
		public IndicacionCompas indicacion;
		public List<Compas> listaCompases;
		public int repeticiones;
		public Token NUM;
		public CompasContext compas;
		public TerminalNode NUM() { return getToken(MusilengParser.NUM, 0); }
		public CompasContext compas(int i) {
			return getRuleContext(CompasContext.class,i);
		}
		public List<CompasContext> compas() {
			return getRuleContexts(CompasContext.class);
		}
		public RepeticionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RepeticionContext(ParserRuleContext parent, int invokingState, IndicacionCompas indicacion) {
			super(parent, invokingState);
			this.indicacion = indicacion;
		}
		@Override public int getRuleIndex() { return RULE_repeticion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterRepeticion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitRepeticion(this);
		}
	}

	public final RepeticionContext repeticion(IndicacionCompas indicacion) throws RecognitionException {
		RepeticionContext _localctx = new RepeticionContext(_ctx, getState(), indicacion);
		enterRule(_localctx, 14, RULE_repeticion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((RepeticionContext)_localctx).listaCompases =  new ArrayList<Compas>();
			setState(95); match(T__10);
			setState(96); match(T__2);
			setState(97); ((RepeticionContext)_localctx).NUM = match(NUM);
			setState(98);
			if (!((((RepeticionContext)_localctx).NUM!=null?Integer.valueOf(((RepeticionContext)_localctx).NUM.getText()):0) > 0)) throw new FailedPredicateException(this, String.format("La cantidad de repeticiones tiene que ser mayor que cero"));
			setState(99); match(T__1);
			setState(100); match(T__8);
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101); ((RepeticionContext)_localctx).compas = compas(_localctx.indicacion);
				_localctx.listaCompases.add(((RepeticionContext)_localctx).compas.compasObj);
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			((RepeticionContext)_localctx).repeticiones =  (((RepeticionContext)_localctx).NUM!=null?Integer.valueOf(((RepeticionContext)_localctx).NUM.getText()):0);
			setState(109); match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompasContext extends ParserRuleContext {
		public IndicacionCompas indicacion;
		public Compas compasObj;
		public NotaContext nota;
		public SilencioContext silencio;
		public SilencioContext silencio(int i) {
			return getRuleContext(SilencioContext.class,i);
		}
		public List<NotaContext> nota() {
			return getRuleContexts(NotaContext.class);
		}
		public List<SilencioContext> silencio() {
			return getRuleContexts(SilencioContext.class);
		}
		public NotaContext nota(int i) {
			return getRuleContext(NotaContext.class,i);
		}
		public CompasContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CompasContext(ParserRuleContext parent, int invokingState, IndicacionCompas indicacion) {
			super(parent, invokingState);
			this.indicacion = indicacion;
		}
		@Override public int getRuleIndex() { return RULE_compas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterCompas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitCompas(this);
		}
	}

	public final CompasContext compas(IndicacionCompas indicacion) throws RecognitionException {
		CompasContext _localctx = new CompasContext(_ctx, getState(), indicacion);
		enterRule(_localctx, 16, RULE_compas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((CompasContext)_localctx).compasObj =  new Compas();
			setState(112); match(T__3);
			setState(113); match(T__8);
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(120);
				switch (_input.LA(1)) {
				case T__14:
					{
					setState(114); ((CompasContext)_localctx).nota = nota();
					_localctx.compasObj.notas.add(((CompasContext)_localctx).nota.notaObj);
					}
					break;
				case T__11:
					{
					setState(117); ((CompasContext)_localctx).silencio = silencio();
					_localctx.compasObj.notas.add(((CompasContext)_localctx).silencio.silencioObj);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__14 || _la==T__11 );
			setState(124); match(T__6);
			setState(125);
			if (!(validarDuracion(_localctx.compasObj.notas, _localctx.indicacion))) throw new FailedPredicateException(this, String.format("Faltan notas para completar el compas"));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SilencioContext extends ParserRuleContext {
		public Nota silencioObj;
		public Token DURACION;
		public Token PUNTILLO;
		public TerminalNode PUNTILLO() { return getToken(MusilengParser.PUNTILLO, 0); }
		public TerminalNode DURACION() { return getToken(MusilengParser.DURACION, 0); }
		public SilencioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_silencio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterSilencio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitSilencio(this);
		}
	}

	public final SilencioContext silencio() throws RecognitionException {
		SilencioContext _localctx = new SilencioContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_silencio);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(T__11);
			setState(128); match(T__2);
			setState(129); ((SilencioContext)_localctx).DURACION = match(DURACION);
			setState(131);
			_la = _input.LA(1);
			if (_la==PUNTILLO) {
				{
				setState(130); ((SilencioContext)_localctx).PUNTILLO = match(PUNTILLO);
				}
			}

			setState(133); match(T__1);
			setState(134); match(T__7);
			((SilencioContext)_localctx).silencioObj =  new Nota(null,null,(((SilencioContext)_localctx).DURACION!=null?((SilencioContext)_localctx).DURACION.getText():null),((SilencioContext)_localctx).PUNTILLO != null ? true : false);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotaContext extends ParserRuleContext {
		public Nota notaObj;
		public Token ALTURA;
		public OctavaContext octava;
		public Token DURACION;
		public Token PUNTILLO;
		public TerminalNode PUNTILLO() { return getToken(MusilengParser.PUNTILLO, 0); }
		public OctavaContext octava() {
			return getRuleContext(OctavaContext.class,0);
		}
		public TerminalNode ALTURA() { return getToken(MusilengParser.ALTURA, 0); }
		public TerminalNode DURACION() { return getToken(MusilengParser.DURACION, 0); }
		public NotaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nota; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterNota(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitNota(this);
		}
	}

	public final NotaContext nota() throws RecognitionException {
		NotaContext _localctx = new NotaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_nota);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); match(T__14);
			setState(138); match(T__2);
			setState(139); ((NotaContext)_localctx).ALTURA = match(ALTURA);
			setState(140); match(T__0);
			setState(141); ((NotaContext)_localctx).octava = octava();
			setState(142); match(T__0);
			setState(143); ((NotaContext)_localctx).DURACION = match(DURACION);
			setState(145);
			_la = _input.LA(1);
			if (_la==PUNTILLO) {
				{
				setState(144); ((NotaContext)_localctx).PUNTILLO = match(PUNTILLO);
				}
			}

			setState(147); match(T__1);
			setState(148); match(T__7);
			((NotaContext)_localctx).notaObj =  new Nota((((NotaContext)_localctx).ALTURA!=null?((NotaContext)_localctx).ALTURA.getText():null),((NotaContext)_localctx).octava.valor,(((NotaContext)_localctx).DURACION!=null?((NotaContext)_localctx).DURACION.getText():null), ((NotaContext)_localctx).PUNTILLO != null);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OctavaContext extends ParserRuleContext {
		public int valor;
		public Token OCTAVA;
		public Token NOMBRE;
		public TerminalNode NOMBRE() { return getToken(MusilengParser.NOMBRE, 0); }
		public TerminalNode OCTAVA() { return getToken(MusilengParser.OCTAVA, 0); }
		public OctavaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_octava; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).enterOctava(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusilengListener ) ((MusilengListener)listener).exitOctava(this);
		}
	}

	public final OctavaContext octava() throws RecognitionException {
		OctavaContext _localctx = new OctavaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_octava);
		try {
			setState(155);
			switch (_input.LA(1)) {
			case OCTAVA:
				enterOuterAlt(_localctx, 1);
				{
				setState(151); ((OctavaContext)_localctx).OCTAVA = match(OCTAVA);
				((OctavaContext)_localctx).valor =  (((OctavaContext)_localctx).OCTAVA!=null?Integer.valueOf(((OctavaContext)_localctx).OCTAVA.getText()):0);
				}
				break;
			case NOMBRE:
				enterOuterAlt(_localctx, 2);
				{
				setState(153); ((OctavaContext)_localctx).NOMBRE = match(NOMBRE);
				((OctavaContext)_localctx).valor =  constantes.get((((OctavaContext)_localctx).NOMBRE!=null?((OctavaContext)_localctx).NOMBRE.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return tempos_sempred((TemposContext)_localctx, predIndex);
		case 4: return constante_sempred((ConstanteContext)_localctx, predIndex);
		case 5: return melodia_sempred((MelodiaContext)_localctx, predIndex);
		case 7: return repeticion_sempred((RepeticionContext)_localctx, predIndex);
		case 8: return compas_sempred((CompasContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean constante_sempred(ConstanteContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return agregarConstante((((ConstanteContext)_localctx).n1!=null?((ConstanteContext)_localctx).n1.getText():null), (((ConstanteContext)_localctx).NUM!=null?Integer.valueOf(((ConstanteContext)_localctx).NUM.getText()):0));
		case 2: return agregarConstante((((ConstanteContext)_localctx).n1!=null?((ConstanteContext)_localctx).n1.getText():null), (((ConstanteContext)_localctx).n2!=null?((ConstanteContext)_localctx).n2.getText():null));
		}
		return true;
	}
	private boolean melodia_sempred(MelodiaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return constantes.containsKey((((MelodiaContext)_localctx).NOMBRE!=null?((MelodiaContext)_localctx).NOMBRE.getText():null));
		case 4: return validarAlMenosUnCompas(((MelodiaContext)_localctx).compases.listaCompases);
		}
		return true;
	}
	private boolean repeticion_sempred(RepeticionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return (((RepeticionContext)_localctx).NUM!=null?Integer.valueOf(((RepeticionContext)_localctx).NUM.getText()):0) > 0;
		}
		return true;
	}
	private boolean tempos_sempred(TemposContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return validarTempo(_localctx.tempo);
		}
		return true;
	}
	private boolean compas_sempred(CompasContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6: return validarDuracion(_localctx.compasObj.notas, _localctx.indicacion);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32\u00a0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\7\5.\n\5\f\5\16\5\61\13\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6:\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7F\n\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7O\n\7\r\7\16\7P\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b_\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\6\tk\n\t\r\t\16\tl\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\6\n{\n\n\r\n\16\n|\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u0086\n\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0094\n\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u009e\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\2\2\u009f\2\32\3\2\2\2\4 \3\2\2\2\6&\3\2\2\2\b/\3\2\2\2\n"+
		"\62\3\2\2\2\f=\3\2\2\2\16^\3\2\2\2\20`\3\2\2\2\22q\3\2\2\2\24\u0081\3"+
		"\2\2\2\26\u008b\3\2\2\2\30\u009d\3\2\2\2\32\33\5\4\3\2\33\34\5\6\4\2\34"+
		"\35\5\b\5\2\35\36\5\f\7\2\36\37\b\2\1\2\37\3\3\2\2\2 !\7\t\2\2!\"\7\24"+
		"\2\2\"#\7\26\2\2#$\b\3\1\2$%\6\3\2\3%\5\3\2\2\2&\'\7\6\2\2\'(\7\26\2\2"+
		"()\7\3\2\2)*\7\26\2\2*+\b\4\1\2+\7\3\2\2\2,.\5\n\6\2-,\3\2\2\2.\61\3\2"+
		"\2\2/-\3\2\2\2/\60\3\2\2\2\60\t\3\2\2\2\61/\3\2\2\2\62\63\7\5\2\2\63\64"+
		"\7\27\2\2\649\7\16\2\2\65\66\7\26\2\2\66:\6\6\3\3\678\7\27\2\28:\6\6\4"+
		"\39\65\3\2\2\29\67\3\2\2\2:;\3\2\2\2;<\7\13\2\2<\13\3\2\2\2=N\b\7\1\2"+
		">?\7\r\2\2?E\7\20\2\2@A\7\26\2\2AF\b\7\1\2BC\7\27\2\2CD\6\7\5\3DF\b\7"+
		"\1\2E@\3\2\2\2EB\3\2\2\2FG\3\2\2\2GH\7\21\2\2HI\7\n\2\2IJ\5\16\b\2JK\7"+
		"\f\2\2KL\6\7\6\3LM\b\7\1\2MO\3\2\2\2N>\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3"+
		"\2\2\2Q\r\3\2\2\2RS\b\b\1\2ST\5\22\n\2TU\b\b\1\2UV\5\16\b\2VW\b\b\1\2"+
		"W_\3\2\2\2XY\b\b\1\2YZ\5\20\t\2Z[\b\b\1\2[\\\5\16\b\2\\_\3\2\2\2]_\b\b"+
		"\1\2^R\3\2\2\2^X\3\2\2\2^]\3\2\2\2_\17\3\2\2\2`a\b\t\1\2ab\7\b\2\2bc\7"+
		"\20\2\2cd\7\26\2\2de\6\t\7\3ef\7\21\2\2fj\7\n\2\2gh\5\22\n\2hi\b\t\1\2"+
		"ik\3\2\2\2jg\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\b\t\1\2"+
		"op\7\f\2\2p\21\3\2\2\2qr\b\n\1\2rs\7\17\2\2sz\7\n\2\2tu\5\26\f\2uv\b\n"+
		"\1\2v{\3\2\2\2wx\5\24\13\2xy\b\n\1\2y{\3\2\2\2zt\3\2\2\2zw\3\2\2\2{|\3"+
		"\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\7\f\2\2\177\u0080\6\n\b\3\u0080"+
		"\23\3\2\2\2\u0081\u0082\7\7\2\2\u0082\u0083\7\20\2\2\u0083\u0085\7\24"+
		"\2\2\u0084\u0086\7\23\2\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\7\21\2\2\u0088\u0089\7\13\2\2\u0089\u008a\b"+
		"\13\1\2\u008a\25\3\2\2\2\u008b\u008c\7\4\2\2\u008c\u008d\7\20\2\2\u008d"+
		"\u008e\7\25\2\2\u008e\u008f\7\22\2\2\u008f\u0090\5\30\r\2\u0090\u0091"+
		"\7\22\2\2\u0091\u0093\7\24\2\2\u0092\u0094\7\23\2\2\u0093\u0092\3\2\2"+
		"\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\7\21\2\2\u0096"+
		"\u0097\7\13\2\2\u0097\u0098\b\f\1\2\u0098\27\3\2\2\2\u0099\u009a\7\30"+
		"\2\2\u009a\u009e\b\r\1\2\u009b\u009c\7\27\2\2\u009c\u009e\b\r\1\2\u009d"+
		"\u0099\3\2\2\2\u009d\u009b\3\2\2\2\u009e\31\3\2\2\2\r/9EP^lz|\u0085\u0093"+
		"\u009d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}