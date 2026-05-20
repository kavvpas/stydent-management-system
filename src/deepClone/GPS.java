package deepClone;
// To enable cloning, this class must implement Cloneable
// 为了能克隆，这个类必须实现 Cloneable 接口
public class GPS implements Cloneable {
    // Package-private visibility so Bike class can access it directly
    // 去掉 private，让隔壁的 Bike 类可以直接通过 . 语法进行修改
    String coordinates;

    public GPS(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Call Object's native memory copy ability
        // 调用 Object 老祖宗自带的底层 C++ 内存复制能力
        return super.clone();
    }
}