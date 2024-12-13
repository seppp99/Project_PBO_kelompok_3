// File: Person.java
public abstract class Person {
    // Atribut
    private String name;
    private int age;

    // Konstruktor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter dan Setter untuk name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan Setter untuk age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Metode abstrak yang harus diimplementasikan oleh kelas turunan
    public abstract void displayInfo();
}
