import java.util.ArrayList;

public class Dosen extends Person {
    public String matakuliah;
    public String hari;
    public String waktu;
    public int slotMax;
    public int slotTerisi;

    public Dosen(String nama, String matakuliah, String hari, String waktu, int slotMax) {
        super(nama);
        this.matakuliah = matakuliah;
        this.hari = hari;
        this.waktu = waktu;
        this.slotMax = slotMax;
        this.slotTerisi = 0;
    }

    public boolean isSlotAvailable() {
        return slotTerisi < slotMax;
    }

    public void tambahSlot() {
        if (isSlotAvailable()) {
            slotTerisi++;
        }
    }

    public void kurangiSlot() {
        if (slotTerisi > 0) {
            slotTerisi--;
        }
    }

    public void displayInfo() {
        System.out.println("Dosen: " + nama + ", Matakuliah: " + matakuliah + ", Hari: " + hari + ", Waktu: " + waktu + ", Slot: " + slotTerisi + "/" + slotMax);
    }

    public static void tampilkanInfoDosen(ArrayList<Dosen> dosenList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tampilkanInfoDosen'");
    }
}
