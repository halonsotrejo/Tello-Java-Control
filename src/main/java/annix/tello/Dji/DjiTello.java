package annix.tello.Dji;

import annix.tello.Communication.TelloCommunication;
import annix.tello.Communication.TelloCommunicationExec;
import annix.tello.Exception.TelloException;
import annix.tello.Telemetry.TelloDrone;
import annix.tello.Telemetry.TelloDroneConnect;
import annix.tello.Telemetry.TelloState;
import annix.tello.command.TelloCommand;
import annix.tello.command.TelloCommandExec;
import annix.tello.command.TelloCommandValue;

import java.util.logging.Logger;

public class DjiTello implements Tello{

    private static final Logger logger = Logger.getLogger(DjiTello.class.getName());

    private TelloDrone telloDrone;
    private TelloCommunication telloCommunication;

    public DjiTello() throws TelloException {
        telloDrone = new TelloDroneConnect();
        telloCommunication = new TelloCommunicationExec();
    }

    @Override
    public void connect() {
        boolean connectionSuccessful = telloCommunication.connect();
        if (connectionSuccessful) {
            telloDrone.setTelloConnection(TelloState.CONNECTED);
            logger.info("Conectado!");
        }
    }

    @Override
    public void disconnect() {
        /**boolean connectionClose = telloCommunication.disconnect();
        if (connectionClose) {
            telloDrone.setTelloConnection(TelloState.DISCONNECTED);
            logger.info("Desconectado!");
        }*/
    }

    @Override
    public void enterCommandMode() throws TelloException {
        TelloCommand command = new TelloCommandExec(TelloCommandValue.COMMAND_MODE);
        boolean executionSuccessful = telloCommunication.executeCommand(command);
        if (executionSuccessful) {
            logger.info("Ingresando al modo de comando exitosa");
        }
    }

    @Override
    public void takeOff() {
        TelloCommand command = new TelloCommandExec(TelloCommandValue.TAKE_OFF);
        boolean executionSuccessful = telloCommunication.executeCommand(command);
        if (executionSuccessful) {
            logger.info("El comando de despegue se ejecutó con éxito");
        }
    }

    @Override
    public void land() {
        TelloCommand command = new TelloCommandExec(TelloCommandValue.LAND);
        boolean executionSuccessful = telloCommunication.executeCommand(command);
        if (executionSuccessful) {
            logger.info("El comando de aterrizaje se ejecutó con éxito");
        }
    }

    @Override
    public void setSpeed(Integer speed) {

    }

    @Override
    public void forward(Integer distance) {

    }

    @Override
    public void backward(Integer distance) {

    }

    @Override
    public void right(Integer distance) {

    }

    @Override
    public void left(Integer distance) {
        TelloCommand command = new TelloCommandExec(TelloCommandValue.LEFT +" "+ String.valueOf(distance));
        boolean executionSuccessful = telloCommunication.executeCommand(command);
        if (executionSuccessful) {
            logger.info("El comando Izquierda se ejecutó con éxito");
        }
    }

    @Override
    public void rotatateRight(Integer angle) {

    }

    @Override
    public void rotateLeft(Integer angle) {

    }
}
