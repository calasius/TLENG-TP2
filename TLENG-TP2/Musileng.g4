grammar Musileng;

@header {
	import java.util.HashMap;
	import java.util.Map;
}

@members {
	private Map<String,Integer> constantes = new HashMap<String,Integer>();
	
	private void agregarConstante(String nombre, Integer valor) {
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
}
s : tempos elcompas constantes melodia;

tempos: '#tempo' DURACION NUM ;

elcompas : '#compas' NUM'/'NUM;

constantes: constante*;

constante: 'const' n1 = NOMBRE'='(NUM {agregarConstante($n1.text, $NUM.int);}|n2 = NOMBRE{agregarConstante($n1.text, $n2.text, $n1.line);})';';

melodia: ('voz''('(NUM|NOMBRE)')''{'(compas compas*repeticion* | repeticion compas*repeticion*)'}')+;

repeticion: 'repetir''('NUM')''{'compas+'}';

compas: 'compas''{'(nota|silencio)+'}';

silencio: 'silencio''('DURACION')'';';

nota: 'nota''('ALTURA alteracion?','(OCTAVA|NOMBRE)','DURACION')'';';

alteracion : '+' | '-';

DURACION : ('blanca'|'negra'|'corchea'|'semicorchea'|'fusa'|'semifusa');

ALTURA : ('do'|'re'|'mi'|'fa'|'sol'|'la'|'si');

NUM: [0-9]+;

NOMBRE: [a-zA-Z_]+;

OCTAVA: [1-9] | '1'[0-5];

//para escaper espacios, tabs, y saltos de linea
WS : [ \t\r\n]+ -> skip ;