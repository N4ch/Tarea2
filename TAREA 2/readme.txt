   ############################################################
   #                        Tarea # 2                         #
   #                                                          #
   #             Elo329 - Diseño y Programación               #
   #                      Orientados a Objeto                 #
   #                                                          #
   #                Nombres:                    Rol:          #
   #                Ignacio Ambiado       	2921034-9     #
   #                Renato Casas-Cordero	2990002-7     #
   #                					      #
   #                                                          #
   #                    Fecha : 28 de Mayo del 2014            #
   #                                                          #
   ############################################################


Descripción:

En esta tarea se modela la interacción objetos reales resortes,bolas, bloques y ganchos fijos sujetos a las leyes de la "naturaleza" en una dimensión. 
A partir del modelo físico se crean clases para poder definir objetos de software que simulan ser los objetos reales.
 
Para el desarrollo de esta tarea las masas serán modeladas como partículas siguiendo la física newtoniana .

Los resortes son modelados sin masa y cumplirán la ley de Hooke sin límite de elasticidad,
es decir, Hooke vale en todas las extensiones del resorte. 

Para lograr mayor simplicidad las bolas se modelan sin momentum angular es decir no giran solo se desplazaran linealmente

Los Hook o ganchos sirven para fijar extremos de resortes o bolas en algún punto del espacio R. 

Por otra parte se desarrollara una interfaz gráfica la cual permitirá  ingresar un escenario predefinido o ya sea poder agregar elementosy hacerlos 
interactuar entre ellos

Para ejecutar lel programa tenemos tenemos 2 caminos :


1) Compilar y luego ejecutar:

-Ingresar a la carpeta Etapa4

-Escribir en consola make, acción que permitirá compilar el código completo de la tarea

-Escribir java PhysicsLab para ejecutar el programa.


2)Mediante Make Run

- Ingresar a la carpeta Etapa4

- Escribir en la consola make run, esta acción compilara los archivos fuente en java y abrira inmediatamente la aplicación.
//"	falta ver como meter los parámetros mediante el makefile //



una vez ingresados estos datos iniciales el programa procede a calcular la posición, velocidad y aceleración actual de los objetos, 
luego estos son incrementados según corresponda físicamente finalmente la simulación se mantendrá en funcionamiento hasta completar el "tiempo total a simular"
, los resultados (las posiciones de los cuerpos en el tiempo) serán escritos en pantalla.


Archivos que componen la tarea:

readme.txt:     	Archivo qué explica la utilización de la orientación a objetos en la tarea, junto al procedimiento para ejecutar el programa y una breve
			explicación de las funciones que realizan cada clase. 
			
BallView.java		Este archivo contiene metodos que definen la forma(shape) de visualización de las bolas(interfaz gráfica de la bola).

MyWorldView.java	Este archivo contiene metodos que permiten mostrar todas las interacciones de los objetos insertados la aplicación(interfaz grafica de world).

SpringView 		Este archivo contiene metodos que definen la forma(shape) de visualizacion de los resortes(interfaz gráfica de los Springs).

Simulateable		Interfaz que define metodos para los objetos que efectivamente se simulan.

FixedHookView.Java      Este archivo contiene metodos que definen la forma(shape) de visualización de los FixedHook(interfaz gráfica de los FixedHook).

SpringAttachable.java:  Este archivo describe una clase que define una interfaz, dicha interfaz permite engancharle al Spring un FixedHook o una Ball.
			indistintamente sin tener que realizar cambios en el código debido a que Ball y FixedHook son objetos distintos pero comparten métodos.
			De no haber existido esta interfaz se hubiese tenido que implementar los métodos para cada objeto por separado, debido a que, estos hubiesen
		        sido objetos de distinto tipo lo cual hubiese provocado que el compilador reclamara por el tipo de objeto al no pasarle un objeto del tipo que 
			fue declarado en la referencia.

Ball.java:		Este archivo contiene el código que define los atributos y métodos utilizados por las Bolas.

CreateConfiguration.java Contiene los metodos que instancian los objetos que son agregados en el world

PhysicsLab.java		Este archivo contiene metodos que le dan vida al entorno grafico donde se muestran los objetos graficos(shape).

LabMenuListener.java	Este archivo contiene los metodos que actuan frente a los eventos del menu.

MouseListener.java	Este archivo contiene los metodos que actuan frente a los ventes del mouse.
		
FixedHook.java:		Este archivo contiene el código que define los atributos y métodos utilizados por los Ganchos.

MyWorld.java: 		Este archivo contiene la información del ambiente donde se encuentra la simulación como por ejemplo el paso del tiempo.

PhysicsElement.java:	Este archivo contiene el código que define los atributos y métodos utilizados tanto por los ganchos, bolas y resortes (mediante herencia).

PhysicsLab.java:	Se encuentra el main de la simulación, además es donde podemos setiar los parámetros de simulación mediante la entrada de datos por consola.

Spring.java:		Este archivo contiene los atributos y métodos utilizados por los resortes.

makefile:		Este archivo permite compilar todas las clases de la tarea de una manera más cómoda y rápida.

documentacion.pdf:	Este archivo contiene una explicación detallada de la tarea.

