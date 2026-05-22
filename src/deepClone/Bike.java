package deepClone;

import java.util.Objects;
import java.util.StringJoiner;

public class Bike implements Cloneable {
    private String id;
    private GPS gps;
    private Status status;

    public Bike(String id, GPS gps) {
        this.id = id;
        this.gps = gps;
        this.status = Status.AVAILABLE;
    }

    public void dispatch(String newCoords, Status newStatus) {
        this.gps.coordinates = newCoords;
        this.status = newStatus;
    }

    public Bike shallowClone() throws CloneNotSupportedException {
        return (Bike) super.clone();
    }

    public Bike deepClone() throws CloneNotSupportedException {
        Bike clonedBike = (Bike) super.clone();
        clonedBike.gps = (GPS) this.gps.clone();
        return clonedBike;
    }

    public String getBikeLog() {
        Objects.requireNonNull(gps, "GPS device missing!");
        Objects.requireNonNull(status, "Bike status missing!");

        return new StringJoiner(" | ", "[Bike - ", "]")
                .add("ID: " + id)
                .add("Status: " + status.getDescription())
                .add("GPS: " + gps.coordinates)
                .toString();
    }

    public GPS getGps() { return gps; }

    // 🌟 ADDED METHOD: Get current status for analytics
    // 🌟 新增方法：允许外部获取当前车辆的状态，用于后台看板统计
    public Status getStatus() { return status; }
}