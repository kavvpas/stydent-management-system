package gitdeepClone;

// To enable cloning, this class must implement Cloneable
// 为了能克隆，这个类也必须实现 Cloneable 接口
public class GPS implements Cloneable {
    String coordinates; // 坐标数据

    public GPS(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}