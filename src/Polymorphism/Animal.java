package Polymorphism;

public class Animal {

    String name;
    int age;

    void Tanimla(){
        System.out.println("Ben hayvan sınıfına ait bir nesneyim");
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
