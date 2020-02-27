package annix.tello.command;

public enum TelloCommandValue {
    SDK_MODE("command"), TAKE_OFF("takeoff"), LAND("land"), STREAM_ON("streamon"), STREAM_OFF("streamoff"), EMERGENCY("emergency"), UP("up"), DOWN("down"),
    LEFT("left"), RIGHT("right"), FORWARD("forward"), BACKWARDS("back"), ROTATE_CW("cw"), ROTATE_CCW("ccw"), FLIP("flip");

    final String command;

    TelloCommandValue(String command) {
        this.command = command;
    }

    public String command(String parameters) {
        return (this.command + ((parameters != null ? " "+parameters : ""))).trim();
    }
}
