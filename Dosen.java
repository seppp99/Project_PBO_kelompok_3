import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    
    public static void tampilkanInfoDosen(String fileName) {
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        System.out.println("Informasi Dosen:");
        System.out.println("-----------------------------------");

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(","); // Format file: nama,matakuliah,hari,waktu,slotMax
            if (data.length == 5) {
                String nama = data[0].trim();
                String matakuliah = data[1].trim();
                String hari = data[2].trim();
                String waktu = data[3].trim();
                int slotMax = Integer.parseInt(data[4].trim());

                System.out.println("Nama: " + nama);
                System.out.println("Matakuliah: " + matakuliah);
                System.out.println("Hari: " + hari);
                System.out.println("Waktu: " + waktu);
                System.out.println("Slot Maksimal: " + slotMax);
                System.out.println("-----------------------------------");
            } else {
                System.out.println("Format baris tidak valid, dilewati: " + line);
            }
        }
    } catch (IOException e) {
        System.out.println("Gagal membaca file: " + fileName);
    }
}
    
}
