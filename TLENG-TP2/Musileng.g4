grammar Musileng;

@header {
	import java.util.HashMap;
	import java.util.Map;
	import java.util.List;
	import java.util.ArrayList;
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
	
	static class IndicacionCompas {
		public int tiempos;
		public int tipoNota;
		public IndicacionCompas(int tiempos, int tipoNota) {
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
		public Integer octava;
		boolean tienePuntillo;
		public Nota(String altura, Integer octava, String duracion, Character alteracion, boolean tienePuntillo) {
			this.altura = altura;
			this.octava = octava;
			this.duracion = duracion;
			this.alteracion = alteracion;
		}
	}
	
	static class Compas {
		public List<Nota> notas;
		public Compas() {
			this.notas = new ArrayList<Nota>();
		}
	}
}



//Gramatica 
s : tempos elcompas constantes melodia[$elcompas.indicacion];

tempos: '#tempo' DURACION NUM ;

elcompas returns [IndicacionCompas indicacion] : '#compas' n1 = NUM'/' n2 = NUM {$elcompas::indicacion = new IndicacionCompas($n1.int,$n2.int);};

constantes: constante*;

constante: 'const' n1 = NOMBRE'='(NUM {agregarConstante($n1.text, $NUM.int);}|n2 = NOMBRE{agregarConstante($n1.text, $n2.text, $n1.line);})';';

melodia[IndicacionCompas indicacion] : ('voz''('(NUM |NOMBRE)')''{'compases[$melodia::indicacion]'}')+;

compases[IndicacionCompas indicacion]: compas[$compases::indicacion] c1 = compases[$compases::indicacion] | repeticion c2 = compases[$compases::indicacion] | ;

repeticion: 'repetir''('NUM {validarRepeticiones($NUM.int);} ')''{'compas[$compases::indicacion]+'}';

compas[IndicacionCompas indicacion] returns[Compas compasObj] locals[Double total = 0]: 'compas''{'(nota {$compasObj.notas.add($nota.notaObj);} |silencio {$compasObj.notas.add($silencio.silencioObj);})+'}';

silencio returns[Nota silencioObj]: 'silencio''('DURACION PUNTILLO?')'';' {$silencio::silencioObj = new Nota(null,null,$DURACION.text,null,$PUNTILLO != null ? true : false);};

nota returns[Nota notaObj]: 'nota''('ALTURA alteracion?',' octava ','DURACION PUNTILLO?')'';' {$nota::notaObj = new Nota($ALTURA.text, 
	$octava.valor, $DURACION.text, $alteracion != null ? $alteracion.valor : null, $PUNTILLO != null ? true : false);};

octava returns[int valor]: OCTAVA {$octava::valor = $OCTAVA.int;}| NOMBRE {$octava::valor = constantes.get($NOMBRE.text);};

alteracion returns[Character valor] : '+' {$alteracion::valor = '+';}| '-' {$alteracion::valor = '-';};

PUNTILLO : '.';

DURACION : ('blanca'|'negra'|'corchea'|'semicorchea'|'fusa'|'semifusa');

ALTURA : ('do'|'re'|'mi'|'fa'|'sol'|'la'|'si');

NUM: [0-9]+;

NOMBRE: [a-zA-Z_]+;

OCTAVA: [1-9] | '1'[0-5];

//para escaper espacios, tabs, y saltos de linea
WS : [ \t\r\n]+ -> skip ;