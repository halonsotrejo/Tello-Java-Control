package annix.tello.Dji;

import annix.tello.Exception.TelloException;

public interface Tello {

    /** estableciendo conexión con el Tello Drone.
     */
    void connect();

    /** Desconectando del dron. Si el dron aún no está aterrizado, comenzará un aterrizaje automático.
     */
    void disconnect();

    /** Ingrese al modo de comando. Solo puede ejecutar comandos después de esta llamada.
     */
    void enterCommandMode() throws TelloException;

    /** Despegando del suelo.
     */
    void takeOff();

    /** Aterrizando en el suelo.
     */
    void land();

    //void doFlip(TelloFlip telloFlip);

    /** Configurar la velocidad del drone Tello.
     * @param speed Velocidad elegida.
     */
    void setSpeed(Integer speed);

    void forward(Integer distance);

    void backward(Integer distance);

    void right(Integer distance);

    void left(Integer distance);

    void rotatateRight(Integer angle);

    void rotateLeft(Integer angle);
}
