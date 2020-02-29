package annix.tello.Communication;

import annix.tello.Exception.TelloException;
import annix.tello.Telemetry.TelloDroneConnect;
import annix.tello.command.TelloCommand;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/** Enviar y Recibir datos del Drone Tello DJI. */

public class TelloCommunicationExec implements TelloCommunication{

    private static final Logger logger = Logger.getLogger(TelloCommunicationExec.class.getName());

    /** Conexion Datagram con Tello drone.
     */
    private DatagramSocket ds;

    /** Direccion IP del Drone Tello.
     */
    private InetAddress ipAddress;

    /** Puerto UDP del Drone Tello.
     */
    private Integer udpPort;

    public TelloCommunicationExec() throws TelloException {
        try {
            this.ipAddress = InetAddress.getByName(TelloDroneConnect.IP_ADDRESS);
            this.udpPort = TelloDroneConnect.COMMAND_PORT;
        } catch (UnknownHostException e) {
            throw new TelloException("Unknown host");
        }
    }

    /** Realiza la conexion con el Drone Tello.
     */
    @Override
    public boolean connect(){
        try {
            ds = new DatagramSocket(udpPort);
            ds.connect(ipAddress, udpPort);
        } catch (SocketException e) {
            logger.info("No se pudo establecer la conexión con el drone.");
            //throw new TelloException("Could not connect");
        }
        return true;
    }

    /** Envia y recibe los comando a el Drone Tello
     * @param comando de tipo TelloCommand
     */
    @Override
    public boolean executeCommand(final TelloCommand telloCommand) {
        if (telloCommand == null) {
            logger.info("Comando Tello es nulo");
            return false;
        }
        if (!ds.isConnected()) {
            logger.info("TConexion perdida con Tello");
            return false;
        }

        final String command = telloCommand.composeCommand();
        logger.info("Ejecutando comando Tello: " + command);

        try {
            sendData(command);
            String response = receiveData();
            logger.info("Tello response: " + response);
        } catch (IOException e) {
            logger.info("Exception occurred during sending and receiving command");
            logger.info(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Map<String, String> getTelloOnBoardData(List<String> valuesToBeObtained) {
        Map<String, String> dataMap = new HashMap<>();

        return dataMap;
    }

    private String executeReadCommand(TelloCommand telloCommand) throws TelloException {
        if (telloCommand == null) {
            logger.info("Comando fue nulo");
            throw new TelloException("Comando fue vacio");
        }
        if (!ds.isConnected()) {
            logger.info("Conexion perdida con Tello");
            throw new TelloException("No Conexion");
        }

        final String command = telloCommand.composeCommand();
        logger.info("Ejecutando comandos Tello: " + command);

        try {
            sendData(command);
            String response = receiveData();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void executeCommands(List<TelloCommand> telloCommandList) {

    }

    @Override
    public void disconnect() {
        if (this.ds != null) {
            this.ds.disconnect();
            this.ds.close();
        }
    }

    private void sendData(String data) throws IOException {
        byte[] sendData = data.getBytes();
        final DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress,
                udpPort);
        ds.send(sendPacket);
    }

    private String receiveData() throws IOException {
        byte[] receiveData = new byte[1024];
        final DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        ds.receive(receivePacket);
        return trimExecutionResponse(receiveData, receivePacket);
    }

    private String trimExecutionResponse(byte[] response, DatagramPacket receivePacket) {
        response = Arrays.copyOf(response, receivePacket.getLength());
        return new String(response, StandardCharsets.UTF_8);
    }
}
