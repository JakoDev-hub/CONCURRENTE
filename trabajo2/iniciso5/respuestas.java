package trabajo2.iniciso5;

/*
 * a) ¿Qué pasaría si quitamos todos los sleep() del programa? ¿Y si solo
 * quitamos el de main, o el de HiloContador? Para cada caso, ¿cuál sería la
 * salida del programa?
 * 
 * al quitar todos los sleep() del programa, el hilo principal y el hilo secundario se ejecutarian de manera concurrente,
 *  por lo que la salida del programa seria una mezcla de los puntos impresos por el hilo principal y los numeros impresos por el hilo secundario.
 * 
 * b) El main() ¿siempre termina al final, o puede suceder que termine antes que el hilo principal si el hilo secundario 
 * el run()?¿Por qué puede suceder esto?
 * el main siempre termina al final, solo puede suceder que termine antes que el run() si el hilo
 * 
 * c) Realizar los cambios necesarios para que la clase HiloContador herede de
 * la clase Thread (recuerde eliminar la interfaz Runnable).
 * d) Realice el ejercicio para que en vez de ejecutar un solo hilo, ejecute 3.
 * Realice el procedimiento varias veces. ¿Qué ocurre? ¿Se ejecutan en orden?
 */
