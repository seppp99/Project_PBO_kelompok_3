public abstract class Person {
    private String name;
    private int alamat;

    public Person(String name, int alamat) {
        this.name = name;
        this.alamat = alamat;
    } 

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return alamat;
    }

    public void setAge(int alamat) {
        this.alamat = alamat;
    }
}
