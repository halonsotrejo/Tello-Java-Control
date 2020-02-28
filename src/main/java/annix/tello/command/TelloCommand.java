package annix.tello.command;

import annix.tello.Exception.TelloException;

public interface TelloCommand {
    /** Establece la conexion con Tello Drone.
     */
    void connect();
    /** Desconectando de Tello Drone .
     */
    void disconnect();
    /** Ingreza a Modo Comando. Tu puedes solo ejecutar comandos despues de esta funcion.
     */
    void enterCommandMode() throws TelloException;
    /** Despegar del suelo.
     */
    void takeOff();
    /** Aterrizaje en el suelo.
     */
    void land();
    /** Doing a flip in the chosen direction. @param telloFlip Type of the flip.
     */
    //void doFlip(TelloFlip telloFlip);

    /** Ajuste la velocidad del dron. velocidad @param Velocidad elegida.
     */
    void setSpeed(Integer speed);

    void forward(Integer distance);

    void backward(Integer distance);

    void right(Integer distance);

    void left(Integer distance);

    void rotatateRight(Integer angle);

    void rotateLeft(Integer angle);
}
