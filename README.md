IUSIS 2014
==========


Proyecto de software libre (GPLv3) de gestión para Estudios Jurídicos.

por nacho cartes y pablo climent

Lenguaje Ubicuo

Procesos: Es un caso judicial.

Carátula: Es la descripción de la caso 

Tipos de procesos: Especifica la problemática. 

Domicilio Constituido: Es el domicilio que fija el abogado a los efectos del proceso.

Juzgado: Lugar donde cursa el caso.

Instancia: Etapa en la que esta el Proceso. 

Partes: Actores que participan en el caso.

Pruebas: Información ligada al caso.

Gestoría: Responsable de los tramites.

Responsable:(asignación de un proceso a un miembro del estudio)

——————————————————————
Conceptos

1) Ejemplos de procesos judiciales: 
Estas son las listas de procesos de la Suprema Corte de Buenos Aires. Sólo rige acá, pero es un 99% de la cantidad de procesos que existen. Están divididos en cuatro grupos, pero para Iusis podrían ir todos juntos, en una lista, ordenados alfabéticamente. (http://www.scba.gov.ar/informacion/tablas.asp)
Si quieren trabajar sólo con uno de los cuatro grupos, podrían utilizar Civil y Comercial, que es el que más se suele usar. Luego Laboral, Familia y por último Contencioso Administrativo.

2) Una instancia refiere a qué juez tiene el expediente en sus manos y por ende, en qué parte del proceso está el mismo. 
Todo juicio se inicia en Primera Instancia, que es el Juez común que le toca a todos cuando arrancan un expediente. 
Luego, cuando el juez dicta alguna sentencia (que puede haber muchas "pequeñas sentencias" durante el proceso, hasta llegar a la sentencia final), dicha resolución es apelada y pasa a una Segunda Instancia, dónde un grupo de jueces de mayor jerarquía decide si lo que falló la Primera Instancia, es correcto o no. El expediente puede "subir" y "bajar" varias veces durante su vida.
La Tercera Instancia, es casi inexistente, consiste en in a la Corte Suprema, es el máximo tribunal que existe en nuestro país y es una instancia excepcional. 
Las Instancias son diferentes jerarquías de jueces que tienen el expediente, para decirlo de alguna manera.

3) El expediente en sí mismo, para nosotros los abogados, no es más que el registro, ordenado, cronológico de los eventos. 
Imaginen una carpeta, cuya primera página es la demanda, la segunda página es la contestación, la tercera es el juez ordenando una fecha de audiencia, la cuarta es un acta de dicha audiencia, etc. 
El expediente en Iusis, es una tabla que reúne a todos los pasos procesales (demanda, contestación, proveído del juez, acta de audiencia) que el usuario ingresa.
Procesos, es la tabla que contiene a todos los Expedientes. 
"Procesos" lo llamó Lex Doctor, también podría llamarse "Expedientes". En dicha entrada estarán todos los expedientes y dentro de cada uno, los pasos procesales que le corresponden.
