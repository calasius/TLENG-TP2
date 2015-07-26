grammar Musileng;

@header {
	import java.util.HashMap;
	import java.util.Map;
}

@members {
	private Map<String,Integer> constantes = new HashMap<String,Integer>();
	
	private void agregarConstante(String nombre, Integer valor) {
		if (constantes.containsKey(nombre)) {
			throw new RuntimeException(String.format("La constante \"%s\" ya esta fue definida",nombre));
		}
		constantes.put(nombre, valor);
	}
	
	private void agregarConstante(String nombre, String valor,int line) {
		if (constantes.containsKey(valor)) {
			constantes.put(nombre,constantes.get(valor));
		} else {
			throw new RuntimeException(String.format("La constante \"%s\"no esta previamante declarada",valor));
		}
	}
	
	private void validarRepeticiones(int valor) {
		if (valor <= 0) {
			throw new RuntimeException("La cantidad de repetiones tiene que ser mayor que cero");
		}
	}
	
	static class Compas {
		public int tiempos;
		public int tipoNota;
		public Compas(int tiempos, int tipoNota) {
			this.tiempos = tiempos;
			this.tipoNota = tipoNota;
		}
		
		public Double duracion() {
			return tiempos * Double.valueOf(4 / tipoNota);
		}
	}
	
	static class Nota {
		public String duracion;
		public String altura;
		public Character alteracion;
		public int octava;
		public Nota(String altura, int octava, String duracion, Character alteracion) {
			this.altura = altura;
			this.octava = octava;
			this.duracion = duracion;
			this.alteracion = alteracion;
		}
	}
}



//Gramatica 
s : tempos elcompas constantes melodia[$elcompas.compasObj];

tempos: '#tempo' DURACION NUM ;

elcompas returns [Compas compasObj] : '#compas' n1 = NUM'/' n2 = NUM {$elcompas::compasObj = new Compas($n1.int,$n2.int);};

constantes: constante*;

constante: 'const' n1 = NOMBRE'='(NUM {agregarConstante($n1.text, $NUM.int);}|n2 = NOMBRE{agregarConstante($n1.text, $n2.text, $n1.line);})';';

melodia[Compas compasObj] : ('voz''('(NUM |NOMBRE)')''{'(c1 = compas c2 = compas* r1 = repeticion* | r2 = repeticion c3 = compas* r3 = repeticion*)'}')+;

repeticion: 'repetir''('NUM {validarRepeticiones($NUM.int);} ')''{'compas+'}';

compas: 'compas''{'(nota|silencio)+'}';

silencio: 'silencio''('DURACION')'';';

nota returns[Nota notaObj]: 'nota''('ALTURA alteracion?','(OCTAVA|NOMBRE)','DURACION')'';' {$nota::notaObj = new Nota($ALTURA.text, $OCTAVA.int, $DURACION.text, $alteracion != null ? $alteracion.valor : null);};

octava returns[int valor]: OCTAVA {$octava::valor = $OCTAVA.int;}| NOMBRE {$octava::valor = constantes.get($NOMBRE.text);};

alteracion returns[Character valor] : '+' {$alteracion::valor = '+';}| '-' {$alteracion::valor = '-';};

DURACION : ('blanca'|'negra'|'corchea'|'semicorchea'|'fusa'|'semifusa');

ALTURA : ('do'|'re'|'mi'|'fa'|'sol'|'la'|'si');

NUM: [0-9]+;

NOMBRE: [a-zA-Z_]+;

OCTAVA: [1-9] | '1'[0-5];

//para escaper espacios, tabs, y saltos de linea
WS : [ \t\r\n]+ -> skip ;