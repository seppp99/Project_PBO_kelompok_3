import java.io.*;
import java.util.ArrayList;
public class Jadwal {
    private ArrayList<String> matakuliahList;
    private ArrayList<String> hariList;
    private ArrayList<String> waktuList;
    private ArrayList<String> dosenList;

    public Jadwal() {
        this.matakuliahList = new ArrayList<>();
        this.hariList = new ArrayList<>();
        this.waktuList = new ArrayList<>();
        this.dosenList = new ArrayList<>();
    }

    public void tambahJadwal(Dosen dosen) {
        // Tambahkan data dosen ke jadwal
        this.matakuliahList.add(dosen.matakuliah);
        this.hariList.add(dosen.hari);
        this.waktuList.add(dosen.waktu);
        this.dosenList.add(dosen.nama);
        System.out.println("Jadwal berhasil ditambahkan: " + dosen.matakuliah);
    }

    public void hapusJadwal(int indeks) {
        if (indeks < 0 || indeks >= matakuliahList.size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        System.out.println("Jadwal " + matakuliahList.get(indeks) + " berhasil dihapus.");
        matakuliahList.remove(indeks);
        hariList.remove(indeks);
        waktuList.remove(indeks);
        dosenList.remove(indeks);
    }

    public int getJumlahJadwal() {
        return matakuliahList.size();
    }

    public String getMatakuliah(int indeks) {
        return matakuliahList.get(indeks);
    }

    public void simpanKeFile(PrintWriter writer) {
        for (int i = 0; i < matakuliahList.size(); i++) {
            writer.println("- " + matakuliahList.get(i) +
                    " (Hari: " + hariList.get(i) +
                    ", Waktu: " + waktuList.get(i) +
                    ", Dosen: " + dosenList.get(i) + ")");
        }
    }
}
