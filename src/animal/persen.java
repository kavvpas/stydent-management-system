package animal;

import javax.xml.namespace.QName;

public class persen {
    private String name;
    private int age;
    public persen(){

    }
    public persen(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void keepdog(dog dog,String something){
        System.out.println(getName()+"keep a"+dog.getColor()+"and"+dog.getAge()+"dog");
        dog.eat(something);
    }
    public void keepcat(cat cat,String something){
        System.out.println(getName()+"keep a"+cat.getColor()+"and"+cat.getAge()+"dog");
        cat.eat(something);
    }
}
