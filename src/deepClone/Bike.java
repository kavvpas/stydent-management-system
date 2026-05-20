package deepClone;

import java.util.Objects;
import java.util.StringJoiner;

public class Bike implements Cloneable {
    private String id;
    private GPS gps; // Nested object reference (嵌套的引用对象)

    public Bike(String id, GPS gps) {
        this.id = id;
        this.gps = gps;
    }

    // 🌟 THE NEW FUNCTION: Update internal GPS location
    // 🌟 新增的功能：允许修改这台车内部的 GPS 坐标
    public void updateGpsLocation(String newCoords) {
        this.gps.coordinates = newCoords;
    }

    // 1. Shallow Clone Example (浅克隆：只复制外壳和地址)
    public Bike shallowClone() throws CloneNotSupportedException {
        return (Bike) super.clone();
    }

    // 2. Deep Clone Example (深克隆：外壳和内部硬件彻底独立复制)
    public Bike deepClone() throws CloneNotSupportedException {
        // Step 1: Clone the bike container (先复制外壳)
        Bike clonedBike = (Bike) super.clone();
        // Step 2: Manually clone the nested GPS object (手动复制里面的GPS硬件)
        clonedBike.gps = (GPS) this.gps.clone();
        return clonedBike;
    }

    // Using StringJoiner and Objects API to generate logs
    // 串联知识点：使用全新的 StringJoiner 拼接精美日志
    public String getBikeLog() {
        // Objects tool class: Prevent NullPointerException (空指针保护)
        Objects.requireNonNull(gps, "GPS device cannot be null!");

        StringJoiner sj = new StringJoiner(" | ", "[Bike Log: ", "]");
        sj.add("ID: " + id);
        sj.add("GPS Loc: " + gps.coordinates);
        return sj.toString();
    }

    public GPS getGps() { return gps; }
}