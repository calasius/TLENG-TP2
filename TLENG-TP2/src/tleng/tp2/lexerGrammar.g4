lexer grammar lexerGrammar;

TEMPO: 'tempo';

COMPAS : 'compas';

CONST: 'const';

IGUAL: '=';

VOZ: 'voz';

LPAREN: '(' ;
RPAREN: ')' ;

LBRACE: '{' ;
RBRACE: '}' ;

NUMERAL:  '#';

COMA: ',' ;
PUNTOYCOMA: ';';
SLASH: '/';

COMENTARIOS:   '//' ~[\r\n]* -> skip ;


REPETIR: 'repetir';
SILENCIO: 'silencio';
NOTA:  'nota';

PUNTILLO : '.';

DURACION : ('redonda'|'blanca'|'negra'|'corchea'|'semicorchea'|'fusa'|'semifusa');

ALTURA : ('do'| 're'| 'mi'| 'fa'| 'sol'| 'la'| 'si'|
	'do+'| 're+'| 'mi+'| 'fa+'| 'sol+'| 'la+'| 'si+'|
	'do-'| 're-'| 'mi-'| 'fa-'| 'sol-'| 'la-'| 'si-');

NUM: [0-9][0-9]*;

NOMBRE: [_a-zA-Z][_a-zA-Z0-9]*;

//OCTAVA: [1-9];


//para escaper espacios, tabs, y saltos de linea
WS : [ \t\r\n]+ -> skip ;

