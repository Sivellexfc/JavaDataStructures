package Polymorphism;

public class Main {
    public static void main(String[] args) {
        Animal Kedi = new Animal();
        Animal Kopek = new Dog();
        Dog kopek_2 = new Dog();

        Bird kus = new Bird();

        Kedi.Tanimla();
        Kopek.Tanimla();
        kopek_2.Tanimla();
        kus.Tanimla();

    }
}