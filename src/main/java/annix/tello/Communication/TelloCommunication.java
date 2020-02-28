package annix.tello.Communication;

import annix.tello.command.TelloCommand;

import java.util.List;
import java.util.Map;

public interface TelloCommunication {
    /** Establece la conexion con Tello Drone.
     */
    boolean connect();
    /** Envia comandos a Tello drone.
     */
    boolean disconnect();

    boolean sendData(final TelloCommand telloCommand);

    //void executeCommands(final List<TelloCommand> telloCommandList);

    /** Optener datos acerca del Tello drone.
     */
    //Map<String, String> getTelloOnBoardData(List<String> valuesToBeObtained);
}
