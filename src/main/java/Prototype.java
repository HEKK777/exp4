public class Prototype implements Cloneable {
    // 共享的静态属性
    public static int sharedValue = 10;

    // 实例属性
    private int instanceValue;

    public Prototype(int instanceValue) {
        this.instanceValue = instanceValue;
    }

    public int getInstanceValue() {
        return instanceValue;
    }

    public void setInstanceValue(int instanceValue) {
        this.instanceValue = instanceValue;
    }

    // 实现Cloneable接口的clone()方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        try {
            Prototype prototype1 = new Prototype(5);
            System.out.println("Prototype1 instanceValue: " + prototype1.getInstanceValue());
            System.out.println("Prototype1 sharedValue: " + Prototype.sharedValue);

            // 通过clone()方法创建新的Prototype对象
            Prototype prototype2 = (Prototype) prototype1.clone();
            prototype2.setInstanceValue(10);
            System.out.println("Prototype2 instanceValue: " + prototype2.getInstanceValue());
            System.out.println("Prototype2 sharedValue: " + Prototype.sharedValue);

            // 验证共享属性是否被两个实例共享
            Prototype.sharedValue = 20;
            System.out.println("After changing sharedValue:");
            System.out.println("Prototype1 sharedValue: " + Prototype.sharedValue);
            System.out.println("Prototype2 sharedValue: " + Prototype.sharedValue);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}