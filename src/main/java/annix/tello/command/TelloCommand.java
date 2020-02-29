package annix.tello.command;

public interface TelloCommand {
    /** Compone el comando con todos los parametros necesarios.
     * @return Composed command.
     */
    String composeCommand();
}
