package deepClone;
// To enable cloning, this class must implement Cloneable
// 为了能克隆，这个类必须实现 Cloneable 接口
public class GPS implements Cloneable {
    String coordinates;

    public GPS(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}