import java.io.*;
import java.util.ArrayList;

public class Jadwal implements PengelolaanJadwal {
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

    private boolean isTimeOverlap(String time1, String time2) {
        try {
            String[] time1Parts = time1.split("-");
            String[] time2Parts = time2.split("-");
            
            int time1Start = Integer.parseInt(time1Parts[0].split(":")[0]);
            int time1End = Integer.parseInt(time1Parts[1].split(":")[0]);
            int time2Start = Integer.parseInt(time2Parts[0].split(":")[0]);
            int time2End = Integer.parseInt(time2Parts[1].split(":")[0]);
            
            return (time1Start < time2End && time2Start < time1End);
        } catch (Exception e) {
            System.out.println("Error: Format waktu tidak valid. Gunakan format HH:00-HH:00");
            return true; // Mengembalikan true untuk mencegah penambahan jadwal jika format tidak valid
        }
    }

    public boolean cekBentrokJadwal(String hari, String waktu) {
        for (int i = 0; i < hariList.size(); i++) {
            if (hariList.get(i).equals(hari)) {
                if (isTimeOverlap(waktuList.get(i), waktu)) {
                    System.out.println("PERINGATAN: Bentrok dengan matakuliah " + 
                        matakuliahList.get(i) + " (" + waktuList.get(i) + ")");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void tambahJadwal(String matakuliah, String hari, String waktu, String dosen) {
        // Validasi input
        if (matakuliah == null || hari == null || waktu == null || dosen == null ||
            matakuliah.isEmpty() || hari.isEmpty() || waktu.isEmpty() || dosen.isEmpty()) {
            System.out.println("Error: Semua field harus diisi!");
            return;
        }

        // Validasi format hari
        String[] validDays = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        boolean validDay = false;
        for (String day : validDays) {
            if (day.equals(hari)) {
                validDay = true;
                break;
            }
        }
        if (!validDay) {
            System.out.println("Error: Hari tidak valid! Gunakan: Senin, Selasa, Rabu, Kamis, atau Jumat");
            return;
        }

        // Validasi format waktu
        if (!waktu.matches("\\d{2}:00-\\d{2}:00")) {
            System.out.println("Error: Format waktu tidak valid! Gunakan format HH:00-HH:00");
            return;
        }

        // Cek bentrok jadwal
        if (cekBentrokJadwal(hari, waktu)) {
            System.out.println("PERINGATAN: Tidak dapat menambahkan matakuliah " + matakuliah + 
                " karena bentrok jadwal pada " + hari + " " + waktu);
            return;
        }
        
        this.matakuliahList.add(matakuliah);
        this.hariList.add(hari);
        this.waktuList.add(waktu);
        this.dosenList.add(dosen);
        System.out.println("Jadwal berhasil ditambahkan: " + matakuliah + 
            " (" + hari + " " + waktu + ")");
    }

    public void tambahJadwal(Dosen dosen) {
        tambahJadwal(dosen.matakuliah, dosen.hari, dosen.waktu, dosen.nama);
    }

    @Override
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

    @Override
    public void tampilkanJadwal() {
        if (matakuliahList.isEmpty()) {
            System.out.println("Jadwal kosong.");
            return;
        }
        
        System.out.println("Daftar Jadwal:");
        for (int i = 0; i < matakuliahList.size(); i++) {
            System.out.printf("%d. %s (Hari: %s, Waktu: %s, Dosen: %s)%n",
                    i + 1, matakuliahList.get(i), hariList.get(i),
                    waktuList.get(i), dosenList.get(i));
        }
    }

    // Utility methods
    public int getJumlahJadwal() {
        return matakuliahList.size();
    }

    public String getMatakuliah(int indeks) {
        if (indeks < 0 || indeks >= matakuliahList.size()) {
            throw new IndexOutOfBoundsException("Indeks tidak valid");
        }
        return matakuliahList.get(indeks);
    }

    public String getWaktu(int indeks) {
        if (indeks < 0 || indeks >= waktuList.size()) {
            throw new IndexOutOfBoundsException("Indeks tidak valid");
        }
        return waktuList.get(indeks);
    }

    public String getHari(int indeks) {
        if (indeks < 0 || indeks >= hariList.size()) {
            throw new IndexOutOfBoundsException("Indeks tidak valid");
        }
        return hariList.get(indeks);
    }

    public void simpanKeFile(PrintWriter writer) {
        for (int i = 0; i < matakuliahList.size(); i++) {
            writer.println("- " + matakuliahList.get(i) +
                    " (Hari: " + hariList.get(i) +
                    ", Waktu: " + waktuList.get(i) +
                    ", Dosen: " + dosenList.get(i) + ")");
        }
    }

    public void simpanKeString(StringBuilder jadwalInfo) {
        for (int i = 0; i < matakuliahList.size(); i++) {
            jadwalInfo.append("- ").append(matakuliahList.get(i))
                    .append(" (Hari: ").append(hariList.get(i))
                    .append(", Waktu: ").append(waktuList.get(i))
                    .append(", Dosen: ").append(dosenList.get(i)).append(")\n");
        }
    }
}