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
	
	private boolean agregarConstante(String nombre, String valor) {		//se utiliza cuando se agrega una constante string
		if (constantes.containsKey(valor)) {
			constantes.put(nombre,constantes.get(valor));
			return true;
		} else {
			throw new FailedPredicateException(this, String.format("La constante %s no esta definida", nombre));
			
		}
	}
	
	public static int clicksPorFigura(String altura, IndicacionCompas indicacion) {
		NotaEnum figura = NotaEnum.valueOf(altura);
		int clicksPorRedonda = CLICKS_POR_PULSO * indicacion.tipoNota;
		return clicksPorRedonda / Double.valueOf(4 / figura.getDuracion()).intValue();
	}
	
	private boolean agregarConstante(String nombre, Integer valor) {	//se utiliza cuando se agrega una constante numerica
		if (constantes.containsKey(nombre)) {
			throw new FailedPredicateException(this, String.format("La constante %s ya esta definida", nombre));
			
		}
		constantes.put(nombre, valor);
		return true;
	}
	
	private boolean validarDuracion(List<Nota> notas, IndicacionCompas indicacion) {
		Double duracion = 0.0;
		for(Nota nota : notas) {
			duracion += nota.calcularDuracion();
		}
		if (duracion.compareTo(indicacion.duracion()) != 0){
			throw new FailedPredicateException(this, "La duracion del compas no es la correcta.");
			
		}
		return duracion.compareTo(indicacion.duracion()) == 0;
	}
	
	private boolean validarAlMenosUnCompas(List<Compas> listaCompases) {
		return !listaCompases.isEmpty();
	}
	
	private boolean validarInstrumento(int instrumento) {
		return instrumento >= 0 && instrumento <= 127;
	}
		
	private boolean validarVoces(int cantVoces) {
		if (cantVoces < 0 && cantVoces > 16){
			throw new FailedPredicateException(this,"La cantidad de voces maxima es 16.");
		}
		return cantVoces >= 0 && cantVoces <= 16;
	}
	
	private boolean validarConstante(String nombre) {
		if (constantes.containsKey(nombre) == false){
			throw new FailedPredicateException(this,"La constante %s no esta definida.", nombre);
		}
		return constantes.containsKey(nombre);
	}
	
	private boolean validarOctava(int octava) {
		if (octava > 9 || octava < 1){
			throw new FailedPredicateException(this,"La constante de la octava tiene que estar entre 1 y 9.");
		}
		return (octava < 10 && octava > 0);
	}
				
	private boolean validarTempo(int tempo) {
		if (tempo==0){
			throw new FailedPredicateException(this,"En la deficion del tempo la cantidad de notas por minuto tiene que ser mayor que cero.");
		} 
		return (tempo > 0);
	}
	
	private boolean validarCompas(int cantNotas){
		if (cantNotas == 0)
		{
			throw new FailedPredicateException(this,"La cantidad de notas por compas tine que ser mayor que cero.");
		}
		return (cantNotas > 0);
	}
	
	private boolean validarRepeticiones(int repeticiones){
		if (repeticiones == 0)
		{
			throw new FailedPredicateException(this,"La cantidad de repeticiones tiene que ser mayor que cero.");
		}
		return (repeticiones > 0);
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
}

//Gramatica 
s returns[Partitura partitura]: tempos elcompas constantes melodia[$elcompas.indicacion] {$partitura = new Partitura($tempos.tempo, $elcompas.indicacion, $melodia.voces);};

tempos returns[Tempo tempo]: NUMERAL TEMPO DURACION NUM {$tempo = new Tempo($DURACION.text, $NUM.int);validarTempo($NUM.int);};

elcompas returns [IndicacionCompas indicacion] : NUMERAL COMPAS n1 = NUM SLASH n2 = NUM 
 {$indicacion = new IndicacionCompas($n1.int,$n2.int);validarCompas($n1.int);};

constantes: constante*;

constante: CONST n1 = NOMBRE IGUAL (NUM {agregarConstante($n1.text, $NUM.int)}?|
			n2 = NOMBRE{agregarConstante($n1.text, $n2.text)}? ) PUNTOYCOMA;

melodia[IndicacionCompas indicacion] returns[List<Voz> voces] locals[int instrumento]: {$voces = new ArrayList<Voz>();} 
		(VOZ LPAREN (NUM {$instrumento = $NUM.int;}|NOMBRE {constantes.containsKey($NOMBRE.text)}? {$instrumento = constantes.get($NOMBRE.text);}) RPAREN
		LBRACE compases[$indicacion] RBRACE {validarAlMenosUnCompas($compases.listaCompases)}? { $voces.add(new Voz($instrumento, $compases.listaCompases));validarVoces($voces.size());} )+;

compases[IndicacionCompas indicacion] returns[List<Compas> listaCompases] : 
		{$listaCompases = new ArrayList<Compas>();} compas[$indicacion] {$listaCompases.add($compas.compasObj);} c1 = compases[$indicacion] { $listaCompases.addAll($c1.listaCompases);} | 
		{$listaCompases = new ArrayList<Compas>();} repeticion[$indicacion] {agregarRepetidos($listaCompases,$repeticion.listaCompases,$repeticion.repeticiones);} compases[$indicacion] |
		 {$listaCompases = new ArrayList<Compas>();};

repeticion[IndicacionCompas indicacion] returns [List<Compas> listaCompases, int repeticiones]:
		{$listaCompases = new ArrayList<Compas>();} REPETIR LPAREN NUM {validarRepeticiones($NUM.int);} RPAREN LBRACE (compas[$indicacion] {$listaCompases.add($compas.compasObj);})+ {$repeticiones = $NUM.int;} RBRACE |
		{$listaCompases = new ArrayList<Compas>();} REPETIR LPAREN NOMBRE 
		{ validarConstante($NOMBRE.text);} { validarRepeticiones(constantes.get($NOMBRE.text));}
		  RPAREN LBRACE (compas[$indicacion] {$listaCompases.add($compas.compasObj);})+ 
		  {$repeticiones = constantes.get($NOMBRE.text);} RBRACE;

compas[IndicacionCompas indicacion] returns[Compas compasObj]: 
		{$compasObj = new Compas();}COMPAS LBRACE (
			nota {$compasObj.notas.add($nota.notaObj);} |
			silencio {$compasObj.notas.add($silencio.silencioObj);}
		)+RBRACE {validarDuracion($compasObj.notas, $indicacion)}?;

silencio returns[Nota silencioObj]: SILENCIO LPAREN DURACION PUNTILLO? RPAREN PUNTOYCOMA 
{$silencioObj = new Nota(null,null,$DURACION.text,$PUNTILLO != null ? true : false);};

nota returns[Nota notaObj] : NOTA LPAREN ALTURA  COMA  octava  COMA DURACION PUNTILLO? RPAREN PUNTOYCOMA 
{$notaObj = new Nota($ALTURA.text,$octava.valor,$DURACION.text, $PUNTILLO != null);};

octava returns[int valor]: NUM {validarOctava($NUM.int);} {$valor = $NUM.int;}|
 NOMBRE { validarConstante($NOMBRE.text); validarOctava(constantes.get($NOMBRE.text));}
 	 {$valor = constantes.get($NOMBRE.text);};