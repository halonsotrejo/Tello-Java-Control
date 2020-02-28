package annix.tello.Communication;

import annix.tello.Exception.TelloException;
import annix.tello.Telemetry.TelloDroneConnect;
import annix.tello.command.TelloCommand;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/** Enviar y Recibir datos del Drone Tello DJI. */

public class TelloCommunicationExec implements TelloCommunication{

    private static final Logger logger = Logger.getLogger(TelloCommunication.class.getName());

    /** Datagram connection to the Tello drone. */
    private DatagramSocket dataSocket;
    private DatagramSocket stateSocket;

    /** Direccion IP del Drone. */
    private InetAddress ipAddress;

    /** Puerto UDP del Drone. */
    private Integer commandPort;

    public TelloCommunicationExec() throws TelloException {
        try{
            this.ipAddress = InetAddress.getByName(TelloDroneConnect.IP_ADDRESS);
            this.commandPort = TelloDroneConnect.COMMAND_PORT;
        }catch (UnknownHostException e){
            throw new TelloException("Dispositivo Desconocido");
        }
    }

    public boolean connect() {
        try{
            dataSocket = new DatagramSocket();
            dataSocket.connect(this.ipAddress, this.commandPort);
            stateSocket = new DatagramSocket();
            stateSocket.connect(this.ipAddress,this.commandPort);
        } catch (SocketException e) {
            logger.info("La Conexion del drone podria no ser establecida");
        }
        return true;
    }

    public boolean disconnect() {
        if (this.dataSocket != null || this.stateSocket != null) {
            this.dataSocket.disconnect();
            this.dataSocket.close();
            this.stateSocket.disconnect();
            this.stateSocket.close();
            return true;
        }
        return false;
    }

    public boolean sendData(TelloCommand telloCommand){

        if(telloCommand == null){
            logger.info("Comando es null");
            return false;
        }
        if(!dataSocket.isConnected()){
            logger.info("Desconexion con el dispositivo Tello");
            return false;
        }

        final String command = telloCommand.toString();
        logger.info("Ejecutando Comando Tello: " + command);

        try {
            final byte[] data = command.getBytes();
            dataSocket.send(new DatagramPacket(data, data.length, this.ipAddress, this.commandPort));
            String response = receiveData();
            logger.info("Respuesta del dispositivo Tello: " + response);
        } catch (IOException e) {
            logger.info("Excepcion ocurrida durante el envio y recepcion de comandos");
            logger.info(e.getMessage());
            return false;
        }
        return true;
    }

    private String receiveData() throws IOException {
        final byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        dataSocket.receive(receivePacket);
        return new String(Arrays.copyOf(receiveData, receivePacket.getLength()), StandardCharsets.UTF_8);
    }
}
