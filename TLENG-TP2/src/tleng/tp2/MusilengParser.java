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
		TEMPO=1, COMPAS=2, CONST=3, IGUAL=4, VOZ=5, LPAREN=6, RPAREN=7, LBRACE=8, 
		RBRACE=9, NUMERAL=10, COMA=11, PUNTOYCOMA=12, SLASH=13, COMENTARIOS=14, 
		REPETIR=15, SILENCIO=16, NOTA=17, PUNTILLO=18, DURACION=19, ALTURA=20, 
		NUM=21, NOMBRE=22, WS=23;
	public static final String[] tokenNames = {
		"<INVALID>", "'tempo'", "'compas'", "'const'", "'='", "'voz'", "'('", 
		"')'", "'{'", "'}'", "'#'", "','", "';'", "'/'", "COMENTARIOS", "'repetir'", 
		"'silencio'", "'nota'", "'.'", "DURACION", "ALTURA", "NUM", "NOMBRE", 
		"WS"
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
			
		private boolean validarVoces(List<Voz> voces) {
			return voces.size() >= 0 && voces.size() <= 16;
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
			redonda(4.0),blanca(2.0), negra(1.0),corchea(1/2.0),semicorchea(1/4.0),fusa(1/8.0),semifusa(1/16.0);
			
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
				notacionAmericana.put("re+" , "d+");
				notacionAmericana.put("fa+" , "f+");
				notacionAmericana.put("sol+" , "g+");
				notacionAmericana.put("la+" , "a+");
				notacionAmericana.put("si+" , "b+");	
				notacionAmericana.put("do-" , "c-");
				notacionAmericana.put("re-" , "d-");
				notacionAmericana.put("mi-" , "e-");
				notacionAmericana.put("fa-" , "f-");
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
		public ElcompasContext elcompas() {
			return getRuleContext(ElcompasContext.class,0);
		}
		public MelodiaContext melodia() {
			return getRuleContext(MelodiaContext.class,0);
		}
		public TemposContext tempos() {
			return getRuleContext(TemposContext.class,0);
		}
		public ConstantesContext constantes() {
			return getRuleContext(ConstantesContext.class,0);
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
		public TerminalNode NUMERAL() { return getToken(MusilengParser.NUMERAL, 0); }
		public TerminalNode DURACION() { return getToken(MusilengParser.DURACION, 0); }
		public TerminalNode TEMPO() { return getToken(MusilengParser.TEMPO, 0); }
		public TerminalNode NUM() { return getToken(MusilengParser.NUM, 0); }
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
			setState(30); match(NUMERAL);
			setState(31); match(TEMPO);
			setState(32); ((TemposContext)_localctx).DURACION = match(DURACION);
			setState(33); ((TemposContext)_localctx).NUM = match(NUM);
			((TemposContext)_localctx).tempo =  new Tempo((((TemposContext)_localctx).DURACION!=null?((TemposContext)_localctx).DURACION.getText():null), (((TemposContext)_localctx).NUM!=null?Integer.valueOf(((TemposContext)_localctx).NUM.getText()):0));
			setState(35);
			if (!((((TemposContext)_localctx).NUM!=null?Integer.valueOf(((TemposContext)_localctx).NUM.getText()):0) > 0)) throw new FailedPredicateException(this, "En la defición del tempo la cantidad de notas por minuto tiene que ser mayor que cero.");
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
		public TerminalNode NUMERAL() { return getToken(MusilengParser.NUMERAL, 0); }
		public TerminalNode COMPAS() { return getToken(MusilengParser.COMPAS, 0); }
		public TerminalNode NUM(int i) {
			return getToken(MusilengParser.NUM, i);
		}
		public TerminalNode SLASH() { return getToken(MusilengParser.SLASH, 0); }
		public List<TerminalNode> NUM() { return getTokens(MusilengParser.NUM); }
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
			setState(37); match(NUMERAL);
			setState(38); match(COMPAS);
			setState(39); ((ElcompasContext)_localctx).n1 = match(NUM);
			setState(40); match(SLASH);
			setState(41); ((ElcompasContext)_localctx).n2 = match(NUM);
			setState(42);
			if (!((((ElcompasContext)_localctx).n1!=null?Integer.valueOf(((ElcompasContext)_localctx).n1.getText()):0) > 0)) throw new FailedPredicateException(this, "La cantidad de notas por compas tiene que ser mayor a 0.");
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
		public ConstanteContext constante(int i) {
			return getRuleContext(ConstanteContext.class,i);
		}
		public List<ConstanteContext> constante() {
			return getRuleContexts(ConstanteContext.class);
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
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST) {
				{
				{
				setState(45); constante();
				}
				}
				setState(50);
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
		public List<TerminalNode> NOMBRE() { return getTokens(MusilengParser.NOMBRE); }
		public TerminalNode NOMBRE(int i) {
			return getToken(MusilengParser.NOMBRE, i);
		}
		public TerminalNode PUNTOYCOMA() { return getToken(MusilengParser.PUNTOYCOMA, 0); }
		public TerminalNode IGUAL() { return getToken(MusilengParser.IGUAL, 0); }
		public TerminalNode CONST() { return getToken(MusilengParser.CONST, 0); }
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
			setState(51); match(CONST);
			setState(52); ((ConstanteContext)_localctx).n1 = match(NOMBRE);
			setState(53); match(IGUAL);
			setState(58);
			switch (_input.LA(1)) {
			case NUM:
				{
				setState(54); ((ConstanteContext)_localctx).NUM = match(NUM);
				setState(55);
				if (!(agregarConstante((((ConstanteContext)_localctx).n1!=null?((ConstanteContext)_localctx).n1.getText():null), (((ConstanteContext)_localctx).NUM!=null?Integer.valueOf(((ConstanteContext)_localctx).NUM.getText()):0)))) throw new FailedPredicateException(this,  String.format("La constante %s ya esta definida", ((ConstanteContext)_localctx).n1.getText()));
				}
				break;
			case NOMBRE:
				{
				setState(56); ((ConstanteContext)_localctx).n2 = match(NOMBRE);
				setState(57);
				if (!(agregarConstante((((ConstanteContext)_localctx).n1!=null?((ConstanteContext)_localctx).n1.getText():null), (((ConstanteContext)_localctx).n2!=null?((ConstanteContext)_localctx).n2.getText():null)))) throw new FailedPredicateException(this, String.format("La constante %s no esta definida", ((ConstanteContext)_localctx).n1.getText()));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(60); match(PUNTOYCOMA);
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
		public List<TerminalNode> LBRACE() { return getTokens(MusilengParser.LBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(MusilengParser.RBRACE, i);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(MusilengParser.RPAREN, i);
		}
		public List<TerminalNode> NOMBRE() { return getTokens(MusilengParser.NOMBRE); }
		public List<TerminalNode> VOZ() { return getTokens(MusilengParser.VOZ); }
		public TerminalNode NOMBRE(int i) {
			return getToken(MusilengParser.NOMBRE, i);
		}
		public TerminalNode NUM(int i) {
			return getToken(MusilengParser.NUM, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(MusilengParser.LPAREN); }
		public List<TerminalNode> RBRACE() { return getTokens(MusilengParser.RBRACE); }
		public List<CompasesContext> compases() {
			return getRuleContexts(CompasesContext.class);
		}
		public TerminalNode LPAREN(int i) {
			return getToken(MusilengParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(MusilengParser.RPAREN); }
		public CompasesContext compases(int i) {
			return getRuleContext(CompasesContext.class,i);
		}
		public TerminalNode VOZ(int i) {
			return getToken(MusilengParser.VOZ, i);
		}
		public TerminalNode LBRACE(int i) {
			return getToken(MusilengParser.LBRACE, i);
		}
		public List<TerminalNode> NUM() { return getTokens(MusilengParser.NUM); }
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
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63); match(VOZ);
				setState(64); match(LPAREN);
				setState(72);
				switch (_input.LA(1)) {
				case NUM:
					{
					setState(65); ((MelodiaContext)_localctx).NUM = match(NUM);
					((MelodiaContext)_localctx).instrumento =  (((MelodiaContext)_localctx).NUM!=null?Integer.valueOf(((MelodiaContext)_localctx).NUM.getText()):0);
					setState(67);
					if (!((((MelodiaContext)_localctx).NUM!=null?Integer.valueOf(((MelodiaContext)_localctx).NUM.getText()):0) < 127 && (((MelodiaContext)_localctx).NUM!=null?Integer.valueOf(((MelodiaContext)_localctx).NUM.getText()):0) >= 0)) throw new FailedPredicateException(this, "El instrumento no esta en el rango de 0 a 127");
					}
					break;
				case NOMBRE:
					{
					setState(68); ((MelodiaContext)_localctx).NOMBRE = match(NOMBRE);
					setState(69);
					if (!(constantes.containsKey((((MelodiaContext)_localctx).NOMBRE!=null?((MelodiaContext)_localctx).NOMBRE.getText():null)))) throw new FailedPredicateException(this, String.format("La constante del instrumento %s no esta definida", ((MelodiaContext)_localctx).NOMBRE.getText()));
					setState(70);
					if (!(constantes.get((((MelodiaContext)_localctx).NOMBRE!=null?((MelodiaContext)_localctx).NOMBRE.getText():null)) <= 127 && constantes.get((((MelodiaContext)_localctx).NOMBRE!=null?((MelodiaContext)_localctx).NOMBRE.getText():null)) >= 0)) throw new FailedPredicateException(this, "El instrumento no esta en el rango de 0 a 127");
					((MelodiaContext)_localctx).instrumento =  constantes.get((((MelodiaContext)_localctx).NOMBRE!=null?((MelodiaContext)_localctx).NOMBRE.getText():null));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(74); match(RPAREN);
				setState(75); match(LBRACE);
				setState(76); ((MelodiaContext)_localctx).compases = compases(_localctx.indicacion);
				setState(77); match(RBRACE);
				setState(78);
				if (!(validarAlMenosUnCompas(((MelodiaContext)_localctx).compases.listaCompases))) throw new FailedPredicateException(this, "Tiene que tener al menos un compas");
				 _localctx.voces.add(new Voz(_localctx.instrumento, ((MelodiaContext)_localctx).compases.listaCompases));
				setState(80);
				if (!(_localctx.voces.size() <= 16)) throw new FailedPredicateException(this, "La cantidad de voces maxima es 16.");
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VOZ );
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
		public RepeticionContext repeticion() {
			return getRuleContext(RepeticionContext.class,0);
		}
		public CompasContext compas() {
			return getRuleContext(CompasContext.class,0);
		}
		public CompasesContext compases() {
			return getRuleContext(CompasesContext.class,0);
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
			setState(98);
			switch (_input.LA(1)) {
			case COMPAS:
				enterOuterAlt(_localctx, 1);
				{
				((CompasesContext)_localctx).listaCompases =  new ArrayList<Compas>();
				setState(87); ((CompasesContext)_localctx).compas = compas(_localctx.indicacion);
				_localctx.listaCompases.add(((CompasesContext)_localctx).compas.compasObj);
				setState(89); ((CompasesContext)_localctx).c1 = compases(_localctx.indicacion);
				 _localctx.listaCompases.addAll(((CompasesContext)_localctx).c1.listaCompases);
				}
				break;
			case REPETIR:
				enterOuterAlt(_localctx, 2);
				{
				((CompasesContext)_localctx).listaCompases =  new ArrayList<Compas>();
				setState(93); ((CompasesContext)_localctx).repeticion = repeticion(_localctx.indicacion);
				agregarRepetidos(_localctx.listaCompases,((CompasesContext)_localctx).repeticion.listaCompases,((CompasesContext)_localctx).repeticion.repeticiones);
				setState(95); compases(_localctx.indicacion);
				}
				break;
			case RBRACE:
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
		public Token NOMBRE;
		public TerminalNode LBRACE() { return getToken(MusilengParser.LBRACE, 0); }
		public TerminalNode NOMBRE() { return getToken(MusilengParser.NOMBRE, 0); }
		public CompasContext compas(int i) {
			return getRuleContext(CompasContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MusilengParser.RPAREN, 0); }
		public List<CompasContext> compas() {
			return getRuleContexts(CompasContext.class);
		}
		public TerminalNode RBRACE() { return getToken(MusilengParser.RBRACE, 0); }
		public TerminalNode LPAREN() { return getToken(MusilengParser.LPAREN, 0); }
		public TerminalNode NUM() { return getToken(MusilengParser.NUM, 0); }
		public TerminalNode REPETIR() { return getToken(MusilengParser.REPETIR, 0); }
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
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				((RepeticionContext)_localctx).listaCompases =  new ArrayList<Compas>();
				setState(101); match(REPETIR);
				setState(102); match(LPAREN);
				setState(103); ((RepeticionContext)_localctx).NUM = match(NUM);
				setState(104);
				if (!((((RepeticionContext)_localctx).NUM!=null?Integer.valueOf(((RepeticionContext)_localctx).NUM.getText()):0) > 0)) throw new FailedPredicateException(this, "La cantidad de repeticiones debe ser mayor a 0.");
				setState(105); match(RPAREN);
				setState(106); match(LBRACE);
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(107); ((RepeticionContext)_localctx).compas = compas(_localctx.indicacion);
					_localctx.listaCompases.add(((RepeticionContext)_localctx).compas.compasObj);
					}
					}
					setState(112); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMPAS );
				((RepeticionContext)_localctx).repeticiones =  (((RepeticionContext)_localctx).NUM!=null?Integer.valueOf(((RepeticionContext)_localctx).NUM.getText()):0);
				setState(115); match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				((RepeticionContext)_localctx).listaCompases =  new ArrayList<Compas>();
				setState(118); match(REPETIR);
				setState(119); match(LPAREN);
				setState(120); ((RepeticionContext)_localctx).NOMBRE = match(NOMBRE);
				setState(121);
				if (!(constantes.containsKey((((RepeticionContext)_localctx).NOMBRE!=null?((RepeticionContext)_localctx).NOMBRE.getText():null))  && constantes.get((((RepeticionContext)_localctx).NOMBRE!=null?((RepeticionContext)_localctx).NOMBRE.getText():null)) > 0)) throw new FailedPredicateException(this, String.format("La constante %s debe estar definida y ser mayor a 0"),((RepeticionContext)_localctx).NOMBRE.getText());
				setState(122); match(RPAREN);
				setState(123); match(LBRACE);
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(124); ((RepeticionContext)_localctx).compas = compas(_localctx.indicacion);
					_localctx.listaCompases.add(((RepeticionContext)_localctx).compas.compasObj);
					}
					}
					setState(129); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMPAS );
				((RepeticionContext)_localctx).repeticiones =  constantes.get((((RepeticionContext)_localctx).NOMBRE!=null?((RepeticionContext)_localctx).NOMBRE.getText():null));
				setState(132); match(RBRACE);
				}
				break;
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
		public NotaContext nota(int i) {
			return getRuleContext(NotaContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(MusilengParser.LBRACE, 0); }
		public SilencioContext silencio(int i) {
			return getRuleContext(SilencioContext.class,i);
		}
		public TerminalNode COMPAS() { return getToken(MusilengParser.COMPAS, 0); }
		public TerminalNode RBRACE() { return getToken(MusilengParser.RBRACE, 0); }
		public List<SilencioContext> silencio() {
			return getRuleContexts(SilencioContext.class);
		}
		public List<NotaContext> nota() {
			return getRuleContexts(NotaContext.class);
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
			setState(137); match(COMPAS);
			setState(138); match(LBRACE);
			setState(145); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(145);
				switch (_input.LA(1)) {
				case NOTA:
					{
					setState(139); ((CompasContext)_localctx).nota = nota();
					_localctx.compasObj.notas.add(((CompasContext)_localctx).nota.notaObj);
					}
					break;
				case SILENCIO:
					{
					setState(142); ((CompasContext)_localctx).silencio = silencio();
					_localctx.compasObj.notas.add(((CompasContext)_localctx).silencio.silencioObj);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SILENCIO || _la==NOTA );
			setState(149); match(RBRACE);
			setState(150);
			if (!(validarDuracion(_localctx.compasObj.notas, _localctx.indicacion))) throw new FailedPredicateException(this, "La duracion del compas no es la correcta.");
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
		public TerminalNode DURACION() { return getToken(MusilengParser.DURACION, 0); }
		public TerminalNode PUNTILLO() { return getToken(MusilengParser.PUNTILLO, 0); }
		public TerminalNode RPAREN() { return getToken(MusilengParser.RPAREN, 0); }
		public TerminalNode SILENCIO() { return getToken(MusilengParser.SILENCIO, 0); }
		public TerminalNode PUNTOYCOMA() { return getToken(MusilengParser.PUNTOYCOMA, 0); }
		public TerminalNode LPAREN() { return getToken(MusilengParser.LPAREN, 0); }
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
			setState(152); match(SILENCIO);
			setState(153); match(LPAREN);
			setState(154); ((SilencioContext)_localctx).DURACION = match(DURACION);
			setState(156);
			_la = _input.LA(1);
			if (_la==PUNTILLO) {
				{
				setState(155); ((SilencioContext)_localctx).PUNTILLO = match(PUNTILLO);
				}
			}

			setState(158); match(RPAREN);
			setState(159); match(PUNTOYCOMA);
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
		public TerminalNode ALTURA() { return getToken(MusilengParser.ALTURA, 0); }
		public TerminalNode DURACION() { return getToken(MusilengParser.DURACION, 0); }
		public OctavaContext octava() {
			return getRuleContext(OctavaContext.class,0);
		}
		public TerminalNode NOTA() { return getToken(MusilengParser.NOTA, 0); }
		public TerminalNode PUNTILLO() { return getToken(MusilengParser.PUNTILLO, 0); }
		public TerminalNode RPAREN() { return getToken(MusilengParser.RPAREN, 0); }
		public List<TerminalNode> COMA() { return getTokens(MusilengParser.COMA); }
		public TerminalNode PUNTOYCOMA() { return getToken(MusilengParser.PUNTOYCOMA, 0); }
		public TerminalNode LPAREN() { return getToken(MusilengParser.LPAREN, 0); }
		public TerminalNode COMA(int i) {
			return getToken(MusilengParser.COMA, i);
		}
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
			setState(162); match(NOTA);
			setState(163); match(LPAREN);
			setState(164); ((NotaContext)_localctx).ALTURA = match(ALTURA);
			setState(165); match(COMA);
			setState(166); ((NotaContext)_localctx).octava = octava();
			setState(167); match(COMA);
			setState(168); ((NotaContext)_localctx).DURACION = match(DURACION);
			setState(170);
			_la = _input.LA(1);
			if (_la==PUNTILLO) {
				{
				setState(169); ((NotaContext)_localctx).PUNTILLO = match(PUNTILLO);
				}
			}

			setState(172); match(RPAREN);
			setState(173); match(PUNTOYCOMA);
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
		public Token NUM;
		public Token NOMBRE;
		public TerminalNode NOMBRE() { return getToken(MusilengParser.NOMBRE, 0); }
		public TerminalNode NUM() { return getToken(MusilengParser.NUM, 0); }
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
			setState(182);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(176); ((OctavaContext)_localctx).NUM = match(NUM);
				setState(177);
				if (!((((OctavaContext)_localctx).NUM!=null?Integer.valueOf(((OctavaContext)_localctx).NUM.getText()):0) <=9 && (((OctavaContext)_localctx).NUM!=null?Integer.valueOf(((OctavaContext)_localctx).NUM.getText()):0) >0)) throw new FailedPredicateException(this, "La octava no esta en rango, tiene que ser entre 1 y 9.");
				((OctavaContext)_localctx).valor =  (((OctavaContext)_localctx).NUM!=null?Integer.valueOf(((OctavaContext)_localctx).NUM.getText()):0);
				}
				break;
			case NOMBRE:
				enterOuterAlt(_localctx, 2);
				{
				setState(179); ((OctavaContext)_localctx).NOMBRE = match(NOMBRE);
				setState(180);
				if (!(constantes.containsKey((((OctavaContext)_localctx).NOMBRE!=null?((OctavaContext)_localctx).NOMBRE.getText():null)) && constantes.get((((OctavaContext)_localctx).NOMBRE!=null?((OctavaContext)_localctx).NOMBRE.getText():null)) <= 9  && constantes.get((((OctavaContext)_localctx).NOMBRE!=null?((OctavaContext)_localctx).NOMBRE.getText():null)) > 0)) throw new FailedPredicateException(this, "La octava debe estar definida y estar en el rango del 1 al 9.");
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
		case 2: return elcompas_sempred((ElcompasContext)_localctx, predIndex);
		case 4: return constante_sempred((ConstanteContext)_localctx, predIndex);
		case 5: return melodia_sempred((MelodiaContext)_localctx, predIndex);
		case 7: return repeticion_sempred((RepeticionContext)_localctx, predIndex);
		case 8: return compas_sempred((CompasContext)_localctx, predIndex);
		case 11: return octava_sempred((OctavaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean repeticion_sempred(RepeticionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9: return (((RepeticionContext)_localctx).NUM!=null?Integer.valueOf(((RepeticionContext)_localctx).NUM.getText()):0) > 0;
		case 10: return constantes.containsKey((((RepeticionContext)_localctx).NOMBRE!=null?((RepeticionContext)_localctx).NOMBRE.getText():null))  && constantes.get((((RepeticionContext)_localctx).NOMBRE!=null?((RepeticionContext)_localctx).NOMBRE.getText():null)) > 0;
		}
		return true;
	}
	private boolean elcompas_sempred(ElcompasContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return (((ElcompasContext)_localctx).n1!=null?Integer.valueOf(((ElcompasContext)_localctx).n1.getText()):0) > 0;
		}
		return true;
	}
	private boolean constante_sempred(ConstanteContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return agregarConstante((((ConstanteContext)_localctx).n1!=null?((ConstanteContext)_localctx).n1.getText():null), (((ConstanteContext)_localctx).NUM!=null?Integer.valueOf(((ConstanteContext)_localctx).NUM.getText()):0));
		case 3: return agregarConstante((((ConstanteContext)_localctx).n1!=null?((ConstanteContext)_localctx).n1.getText():null), (((ConstanteContext)_localctx).n2!=null?((ConstanteContext)_localctx).n2.getText():null));
		}
		return true;
	}
	private boolean melodia_sempred(MelodiaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return (((MelodiaContext)_localctx).NUM!=null?Integer.valueOf(((MelodiaContext)_localctx).NUM.getText()):0) < 127 && (((MelodiaContext)_localctx).NUM!=null?Integer.valueOf(((MelodiaContext)_localctx).NUM.getText()):0) >= 0;
		case 5: return constantes.containsKey((((MelodiaContext)_localctx).NOMBRE!=null?((MelodiaContext)_localctx).NOMBRE.getText():null));
		case 6: return constantes.get((((MelodiaContext)_localctx).NOMBRE!=null?((MelodiaContext)_localctx).NOMBRE.getText():null)) <= 127 && constantes.get((((MelodiaContext)_localctx).NOMBRE!=null?((MelodiaContext)_localctx).NOMBRE.getText():null)) >= 0;
		case 7: return validarAlMenosUnCompas(((MelodiaContext)_localctx).compases.listaCompases);
		case 8: return _localctx.voces.size() <= 16;
		}
		return true;
	}
	private boolean tempos_sempred(TemposContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return (((TemposContext)_localctx).NUM!=null?Integer.valueOf(((TemposContext)_localctx).NUM.getText()):0) > 0;
		}
		return true;
	}
	private boolean compas_sempred(CompasContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11: return validarDuracion(_localctx.compasObj.notas, _localctx.indicacion);
		}
		return true;
	}
	private boolean octava_sempred(OctavaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12: return (((OctavaContext)_localctx).NUM!=null?Integer.valueOf(((OctavaContext)_localctx).NUM.getText()):0) <=9 && (((OctavaContext)_localctx).NUM!=null?Integer.valueOf(((OctavaContext)_localctx).NUM.getText()):0) >0;
		case 13: return constantes.containsKey((((OctavaContext)_localctx).NOMBRE!=null?((OctavaContext)_localctx).NOMBRE.getText():null)) && constantes.get((((OctavaContext)_localctx).NOMBRE!=null?((OctavaContext)_localctx).NOMBRE.getText():null)) <= 9  && constantes.get((((OctavaContext)_localctx).NOMBRE!=null?((OctavaContext)_localctx).NOMBRE.getText():null)) > 0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u00bb\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\7\5\61\n\5\f\5\16\5\64\13\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6=\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7K\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7U\n\7\r\7\16"+
		"\7V\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\be\n\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\tq\n\t\r\t\16\tr\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\t\u0082\n\t\r\t\16\t\u0083\3\t\3\t"+
		"\3\t\5\t\u0089\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u0094\n\n\r"+
		"\n\16\n\u0095\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u009f\n\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ad\n\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b9\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\2\2\u00bc\2\32\3\2\2\2\4 \3\2\2\2\6\'\3\2\2\2\b\62\3\2\2"+
		"\2\n\65\3\2\2\2\f@\3\2\2\2\16d\3\2\2\2\20\u0088\3\2\2\2\22\u008a\3\2\2"+
		"\2\24\u009a\3\2\2\2\26\u00a4\3\2\2\2\30\u00b8\3\2\2\2\32\33\5\4\3\2\33"+
		"\34\5\6\4\2\34\35\5\b\5\2\35\36\5\f\7\2\36\37\b\2\1\2\37\3\3\2\2\2 !\7"+
		"\f\2\2!\"\7\3\2\2\"#\7\25\2\2#$\7\27\2\2$%\b\3\1\2%&\6\3\2\3&\5\3\2\2"+
		"\2\'(\7\f\2\2()\7\4\2\2)*\7\27\2\2*+\7\17\2\2+,\7\27\2\2,-\6\4\3\3-.\b"+
		"\4\1\2.\7\3\2\2\2/\61\5\n\6\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2"+
		"\62\63\3\2\2\2\63\t\3\2\2\2\64\62\3\2\2\2\65\66\7\5\2\2\66\67\7\30\2\2"+
		"\67<\7\6\2\289\7\27\2\29=\6\6\4\3:;\7\30\2\2;=\6\6\5\3<8\3\2\2\2<:\3\2"+
		"\2\2=>\3\2\2\2>?\7\16\2\2?\13\3\2\2\2@T\b\7\1\2AB\7\7\2\2BJ\7\b\2\2CD"+
		"\7\27\2\2DE\b\7\1\2EK\6\7\6\3FG\7\30\2\2GH\6\7\7\3HI\6\7\b\3IK\b\7\1\2"+
		"JC\3\2\2\2JF\3\2\2\2KL\3\2\2\2LM\7\t\2\2MN\7\n\2\2NO\5\16\b\2OP\7\13\2"+
		"\2PQ\6\7\t\3QR\b\7\1\2RS\6\7\n\3SU\3\2\2\2TA\3\2\2\2UV\3\2\2\2VT\3\2\2"+
		"\2VW\3\2\2\2W\r\3\2\2\2XY\b\b\1\2YZ\5\22\n\2Z[\b\b\1\2[\\\5\16\b\2\\]"+
		"\b\b\1\2]e\3\2\2\2^_\b\b\1\2_`\5\20\t\2`a\b\b\1\2ab\5\16\b\2be\3\2\2\2"+
		"ce\b\b\1\2dX\3\2\2\2d^\3\2\2\2dc\3\2\2\2e\17\3\2\2\2fg\b\t\1\2gh\7\21"+
		"\2\2hi\7\b\2\2ij\7\27\2\2jk\6\t\13\3kl\7\t\2\2lp\7\n\2\2mn\5\22\n\2no"+
		"\b\t\1\2oq\3\2\2\2pm\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2t"+
		"u\b\t\1\2uv\7\13\2\2v\u0089\3\2\2\2wx\b\t\1\2xy\7\21\2\2yz\7\b\2\2z{\7"+
		"\30\2\2{|\6\t\f\3|}\7\t\2\2}\u0081\7\n\2\2~\177\5\22\n\2\177\u0080\b\t"+
		"\1\2\u0080\u0082\3\2\2\2\u0081~\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\b\t\1\2\u0086"+
		"\u0087\7\13\2\2\u0087\u0089\3\2\2\2\u0088f\3\2\2\2\u0088w\3\2\2\2\u0089"+
		"\21\3\2\2\2\u008a\u008b\b\n\1\2\u008b\u008c\7\4\2\2\u008c\u0093\7\n\2"+
		"\2\u008d\u008e\5\26\f\2\u008e\u008f\b\n\1\2\u008f\u0094\3\2\2\2\u0090"+
		"\u0091\5\24\13\2\u0091\u0092\b\n\1\2\u0092\u0094\3\2\2\2\u0093\u008d\3"+
		"\2\2\2\u0093\u0090\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7\13\2\2\u0098\u0099\6"+
		"\n\r\3\u0099\23\3\2\2\2\u009a\u009b\7\22\2\2\u009b\u009c\7\b\2\2\u009c"+
		"\u009e\7\25\2\2\u009d\u009f\7\24\2\2\u009e\u009d\3\2\2\2\u009e\u009f\3"+
		"\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\t\2\2\u00a1\u00a2\7\16\2\2\u00a2"+
		"\u00a3\b\13\1\2\u00a3\25\3\2\2\2\u00a4\u00a5\7\23\2\2\u00a5\u00a6\7\b"+
		"\2\2\u00a6\u00a7\7\26\2\2\u00a7\u00a8\7\r\2\2\u00a8\u00a9\5\30\r\2\u00a9"+
		"\u00aa\7\r\2\2\u00aa\u00ac\7\25\2\2\u00ab\u00ad\7\24\2\2\u00ac\u00ab\3"+
		"\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\t\2\2\u00af"+
		"\u00b0\7\16\2\2\u00b0\u00b1\b\f\1\2\u00b1\27\3\2\2\2\u00b2\u00b3\7\27"+
		"\2\2\u00b3\u00b4\6\r\16\3\u00b4\u00b9\b\r\1\2\u00b5\u00b6\7\30\2\2\u00b6"+
		"\u00b7\6\r\17\3\u00b7\u00b9\b\r\1\2\u00b8\u00b2\3\2\2\2\u00b8\u00b5\3"+
		"\2\2\2\u00b9\31\3\2\2\2\17\62<JVdr\u0083\u0088\u0093\u0095\u009e\u00ac"+
		"\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}