package animal;

public class dog extends animal {
    public dog() {
    }
    public dog(int age,String col0r) {
        super(age,col0r);
    }
@Override
    public void eat(String something){
        System.out.println("the"+getColor()+"and"+getAge()+"eating"+something);
}
    public void keephouse(){
        System.out.println("catching mice");
    }
}

