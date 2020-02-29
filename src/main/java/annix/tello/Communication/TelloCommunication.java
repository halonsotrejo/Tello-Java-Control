package annix.tello.Communication;

import annix.tello.command.TelloCommand;

import java.util.List;
import java.util.Map;

public interface TelloCommunication {

    /** Establece la conexion con el Tello Drone.
     */
    boolean connect();

    /** Ejecuta los comando a Tello drone.
     * @param telloCommand El comando a ser ejecutado.
     * @return True si la ejecucion fue satisfactoria, false si no.
     * @throws IOException
     */
    boolean executeCommand(final TelloCommand telloCommand);

    void executeCommands(final List<TelloCommand> telloCommandList);

    void disconnect();

    /** Obtiene los datos acerca del Drone Tello.
     *
     * @param valuesToBeObtained Valores optenidos del Drone Tello.
     * @return Mapa de Datos.
     */
    Map<String, String> getTelloOnBoardData(List<String> valuesToBeObtained);
}
