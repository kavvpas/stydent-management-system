package deepClone;

import java.util.Objects;
import java.util.StringJoiner;

public class Bike implements Cloneable {
    private String id;
    private GPS gps; // Object type field (引用类型的属性，克隆的核心战场)

    public Bike(String id, GPS gps) {
        this.id = id;
        this.gps = gps;
    }

    // 1. Shallow Clone Example (浅克隆示例)
    public Bike shallowClone() throws CloneNotSupportedException {
        return (Bike) super.clone(); // Just copies primitives and references (只复制基本数据和地址)
    }

    // 2. Deep Clone Example (深克隆示例)
    public Bike deepClone() throws CloneNotSupportedException {
        // Step 1: Clone the bike container first
        // 第一步：先克隆单车外壳
        Bike clonedBike = (Bike) super.clone();

        // Step 2: Manually clone the internal object!
        // 第二步：极其重要！手动克隆内部的引用对象，彻底斩断地址关联！
        clonedBike.gps = (GPS) this.gps.clone();

        return clonedBike;
    }

    // Using StringJoiner API to build a beautiful output
    // 串联新API知识点：使用 StringJoiner 拼接高效、美观的日志
    public String getBikeLog() {
        // Objects API: Prevent NullPointerException (串联Objects工具类，防止空指针)
        Objects.requireNonNull(gps, "GPS device cannot be null! (GPS设备不能为空！)");

        StringJoiner sj = new StringJoiner(" | ", "[Bike Log: ", "]");
        sj.add("ID: " + id);
        sj.add("GPS Loc: " + gps.coordinates);
        return sj.toString();
    }

    public GPS getGps() { return gps; }
}