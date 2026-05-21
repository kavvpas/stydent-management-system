package deepClone;

import java.util.Objects;
import java.util.StringJoiner;

public class Bike implements Cloneable {
    private String id;
    private GPS gps;
    private Status status; // 👔 New field: Enum status (新增属性：车辆状态枚举)

    public Bike(String id, GPS gps) {
        this.id = id;
        this.gps = gps;
        this.status = Status.AVAILABLE; // Default status is Available (默认待骑行)
    }

    // Business Method: Update bike's position and status
    // 业务方法优化：同时修改GPS坐标和车辆状态
    public void dispatch(String newCoords, Status newStatus) {
        this.gps.coordinates = newCoords;
        this.status = newStatus;
    }

    // 1. Shallow Clone (浅克隆)
    public Bike shallowClone() throws CloneNotSupportedException {
        return (Bike) super.clone();
    }

    // 2. Deep Clone (深克隆)
    public Bike deepClone() throws CloneNotSupportedException {
        Bike clonedBike = (Bike) super.clone();
        clonedBike.gps = (GPS) this.gps.clone(); // Deep copy inside (深度复制内部零件)
        return clonedBike;
    }

    // Professional log format using StringJoiner
    // 工业级日志：完美展现车辆的所有关键元数据
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
}