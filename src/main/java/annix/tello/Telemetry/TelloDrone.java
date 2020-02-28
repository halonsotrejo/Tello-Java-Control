package annix.tello.Telemetry;

public interface TelloDrone {

    Integer getSpeed();

    void setSpeed(Integer speed);

    Integer getBattery();

    void setBattery(Integer battery);

    String getTime();

    void setTime(String time);

    TelloState getTelloConnection();

    void setTelloConnection(TelloState telloConnection);

    TelloMode getTelloMode();

    void setTelloMode(TelloMode telloMode);
}
