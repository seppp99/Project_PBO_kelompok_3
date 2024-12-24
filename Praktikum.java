abstract class Praktikum extends Matakuliah{
    private String namaPrak;
    private int slot;

    public Praktikum(String namaPrak, int slot){
        this.namaPrak = namaPrak;
        this.slot = slot;
    }

    // Getter dan Setter

    public String getNamaPrak() {
        return namaPrak;
    }

    public void setNamaPrak(String namaPrak) {
        this.namaPrak = namaPrak;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    // Untuk Display

    public void display(){};

}