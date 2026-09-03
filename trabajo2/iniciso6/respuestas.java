package trabajo2.iniciso6;

/*
 * 
 * Imagine que está organizando una carrera de atletismo con varios corredores.
 * Usted quiere
 * simular esta carrera utilizando múltiples hilos en Java. Cada corredor será
 * representado por
 * un hilo independiente que avanzará en la pista de carreras. El primer paso es
 * crear una clase
 * llamada Corredor que serán los hilos. Dentro de esta clase, defina los
 * atributos necesarios
 * como el nombre del corredor y la distancia recorrida.
 * Cada corredor sabe la distancia que recorrió, por lo tanto, en cada paso que
 * realiza deberá
 * imprimir su nombre y la distancia que pudo avanzar (aleatorio entre 1 y 10).
 * Luego de
 * realizado el paso debe descansar. Una vez alcanzado los 100 pasos, el
 * corredor termina.
 * En la clase principal, debe crear un arreglo de 100 objetos Corredor
 * (instancias de la clase
 * Corredor). Para cada corredor en el arreglo, debe crear un objeto Thread y
 * pasar la instancia
 * del corredor como argumento al constructor del Thread.
 * Debe iniciar todos los hilos creados usando el método start(). Utilice
 * Thread.sleep() dentro
 * del método run() de cada corredor para simular el tiempo entre pasos.
 * Al finalizar la competencia de todos los atletas, el programa deberá
 * determinar e informar
 * por consola qué corredor logró la mayor distancia recorrida y cuál fue dicha
 * distancia.
 */
