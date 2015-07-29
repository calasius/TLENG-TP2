lexer grammar lexerGrammar;

ALTERACION : '+' |'-' ;

PUNTILLO : '.';

DURACION : ('redonda'|'blanca'|'negra'|'corchea'|'semicorchea'|'fusa'|'semifusa');

ALTURA : ('do'|'re'|'mi'|'fa'|'sol'|'la'|'si');

NUM: [0-9]+;

NOMBRE: [a-zA-Z_]+;

OCTAVA: [1-9];

//para escaper espacios, tabs, y saltos de linea
WS : [ \t\r\n]+ -> skip ;