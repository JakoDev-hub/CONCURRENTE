package AlquilerDeEspaciosParaAviones;
import java.util.Date;
/**
 * Alquiler de un avion
 * 
 * 
 * En un aeropuerto se alquilan espacios de estacionamiento para aviones de distinto tipo. Para cada
ALQUILER se guardan los datos del cliente, la fecha y hora de inicio de alquiler, la fecha y hora
de finalización de alquiler, el número de la posición de estacionamiento y el avión que lo
ocupará. Un AVIÓN se caracteriza por su matrícula, su envergadura en metros y el año de
fabricación.

El cálculo del alquiler se realiza multiplicando la duración del alquiler en horas por un módulo
que se obtiene multiplicando por 20 la envergadura en metros. Este valor se incrementa en una
cantidad fija (250 en la actualidad). Es importante considerar que este valor puede cambiar en el
futuro y puede variar en otros aeropuertos.

Ahora se desea diferenciar la información de algunos tipos de aviones:

Número de motores para aviones a reacción.
Potencia en caballos de fuerza (HP) para aviones a hélice.
Potencia en HP y capacidad de pasajeros para aviones comerciales.
El módulo de los aviones de tipos especiales se obtiene como el módulo normal más:

El número de motores para aviones a reacd cación.
La potencia en HP para aviones a hélice.
La potencia en HP más la capacidad de pasajeros para aviones comerciales.

Diseñe el diagrama de clases, con detalle de atributos
Realice el diagrama de secuencia para el mensaje "calcularValor" de un alquiler. Utilice
polimorfismo de forma apropiada. ¿Qué tipo de polimorfismo aplicó?
Realice el diagrama de secuencia para el mensaje "registrarAlquiler (posEstacionamiento,
unBarco, unCliente, cantDias)" para registrar un nuevo alquiler en el puerto.
 */
public class Alquiler {
    private Date fechaInicio,fechaFin;
    private int horaInicio,horaFin;
    private Cliente unCliente;
    private Avion unAvion;
    private int lugarDelParquin;


        public double calculoAlquier(Avion unAvion, Date fechaInicio, Date fechaFin){

            double duracion = (fechaFin.getTime()-fechaInicio.getTime())* unAvion.calculoAlquiler();
            return duracion;
        }
        public Date getFechaFin() {
            return fechaFin;
        }
        public Date getFechaInicio() {
            return fechaInicio;
        }
        public int getHoraInicio() {
            return horaInicio;
        }
        public int getHoraFin() {
            return horaFin;
        }
}