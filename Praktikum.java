abstract class Praktikum extends Matakuliah {
    private int slot;

    public Praktikum(String kodeMatkul, String namaMatkul, int slot) {
        super(kodeMatkul, namaMatkul);
        this.slot = slot;
    }

    // Getter for slot
    public int getSlot() {
        return slot;
    }

    // Setter for slot
    public void setSlot(int slot) {
        this.slot = slot;
    }

    // Implementing the display method
    public void display() {
    }
}