package annix.tello.command;

import java.util.Objects;

public class TelloCommandExec extends AbstractTelloCommand{

    public TelloCommandExec(String command) {
        super(command);
    }

    @Override
    public String composeCommand() {
        return command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelloCommandExec that = (TelloCommandExec) o;
        return Objects.equals(command, that.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }

    @Override
    public String toString() {
        return "Comando Tello {"
                + "command='" + command + '\''
                + '}';
    }
}
