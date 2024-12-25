public abstract class Person {
    private String name;
    private String alamat;

    public Person(String name, String alamat) {
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
