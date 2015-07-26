grammar Musileng;

s : tempos elcompas constantes melodia;

tempos: '#tempo' DURACION NUM ;

elcompas : '#compas' NUM'/'NUM;

constantes: constante*;

constante: 'const' NOMBRE'='(NUM|NOMBRE)';';

melodia: ('voz''('(NUM|NOMBRE)')''{'(compas compas*repeticion* | repeticion compas*repeticion*)'}')+;

repeticion: 'repetir''('NUM')''{'compas+'}';

compas: 'compas''{'(nota|silencio)+'}';

silencio: 'silencio''('DURACION')'';';

nota: 'nota''('ALTURA alteracion?','(OCTAVA|NOMBRE)','DURACION')'';';

alteracion : '+' | '-';

DURACION : ('blanca'|'negra'|'corchea'|'semicorchea'|'fusa'|'semifusa');

ALTURA : ('do'|'re'|'mi'|'fa'|'sol'|'la'|'si');

NUM: [1-9][0-9]*;

NOMBRE: [a-zA-Z0-9_]+;

OCTAVA: [1-9] | '1'[0-5];

//para escaper espacios, tabs, y saltos de linea
WS : [ \t\r\n]+ -> skip ;