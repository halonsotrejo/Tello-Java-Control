package annix.tello.Telemetry;

public class TelloDroneConnect implements TelloDrone {

    /** Direccion IP de Conexion.
     * */
    public static final String IP_ADDRESS = "192.168.10.1";
    /** Puerto UDP de conexion.
     */
    public static final Integer COMMAND_PORT = 8889;
    public static final Integer STATE_PORT = 8890;
    public static final Integer STREAM_PORT = 11111;
    private Integer battery;
    private Integer speed;
    private String time;
    private TelloState telloState;
    private TelloMode telloMode;

    public TelloDroneConnect() {
        telloState = TelloState.CONNECTED;
        telloMode = TelloMode.NORMAL;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public TelloState getTelloConnection() {
        return this.telloState;
    }

    @Override
    public void setTelloConnection(TelloState tellostate) {
        this.telloState = tellostate;
    }

    @Override
    public TelloMode getTelloMode() {
        return this.telloMode;
    }

    @Override
    public void setTelloMode(TelloMode telloMode) {
        this.telloMode = telloMode;
    }
}
