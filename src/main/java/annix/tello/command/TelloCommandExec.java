package annix.tello.command;


import annix.tello.Communication.TelloCommunication;
import annix.tello.Communication.TelloCommunicationExec;
import annix.tello.Exception.TelloException;
import annix.tello.Telemetry.TelloDrone;
import annix.tello.Telemetry.TelloDroneConnect;
import annix.tello.Telemetry.TelloState;

import java.util.logging.Logger;

public class TelloCommandExec implements TelloCommand{

    private static final Logger logger = Logger.getLogger(TelloCommandExec.class.getName());

    private TelloDrone telloDrone;
    private TelloCommunication telloCommunication;

    public TelloCommandExec(String commandMode) throws TelloException {
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
        boolean connectionClose = telloCommunication.disconnect();
        if (connectionClose) {
            telloDrone.setTelloConnection(TelloState.DISCONNECTED);
            logger.info("Desconectado!");
        }
    }

    @Override
    public void enterCommandMode() throws TelloException {
        //boolean connectionSuccessful = telloCommunication.sendData(TelloCommandValue.COMMAND_MODE);
    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

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

    }

    @Override
    public void rotatateRight(Integer angle) {

    }

    @Override
    public void rotateLeft(Integer angle) {

    }
}
