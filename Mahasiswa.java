import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Mahasiswa extends Person {
    public String nim;
    private Jadwal jadwal;

    public Mahasiswa(String nama, String nim) {
        super(nama);
        this.nim = nim;
        this.jadwal = new Jadwal();
    }

    public String getNama() {
        return nama;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public static void daftarkanMahasiswa(Scanner scanner, ArrayList<Mahasiswa> mahasiswaList) {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String namaMahasiswa = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nimMahasiswa = scanner.nextLine();
        mahasiswaList.add(new Mahasiswa(namaMahasiswa, nimMahasiswa));
        System.out.println("Mahasiswa berhasil didaftarkan.");
    }

    public static void tambahMatakuliah(Scanner scanner, ArrayList<Mahasiswa> mahasiswaList, ArrayList<Dosen> dosenList) {
        System.out.println("Pilih mahasiswa:");
        for (int i = 0; i < mahasiswaList.size(); i++) {
            System.out.println((i + 1) + ". " + mahasiswaList.get(i).getNama());
        }
        int pilihMahasiswa = scanner.nextInt() - 1;
        scanner.nextLine();

        Mahasiswa mahasiswaDipilih = mahasiswaList.get(pilihMahasiswa);

        System.out.println("Pilih Matakuliah:");
        for (int i = 0; i < dosenList.size(); i++) {
            Dosen dosen = dosenList.get(i);
            System.out.println((i + 1) + ". " + dosen.matakuliah +
                    " (Hari: " + dosen.hari + ", Waktu: " + dosen.waktu + ")");
        }
        int pilihMatkul = scanner.nextInt() - 1;
        mahasiswaDipilih.getJadwal().tambahJadwal(dosenList.get(pilihMatkul));
    }

    public static void tampilkanJadwalSemuaMahasiswa(String fileName) {
        System.out.println("\n=== Membaca Isi File JadwalMahasiswa.txt ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file JadwalMahasiswa.txt: " + e.getMessage());
        }
    }

    public static void simpanJadwalKeFile(ArrayList<Mahasiswa> mahasiswaList, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Mahasiswa mahasiswa : mahasiswaList) {
                writer.println("Mahasiswa: " + mahasiswa.getNama() + " (NIM: " + mahasiswa.nim + ")");
                Jadwal jadwal = mahasiswa.getJadwal();
                if (jadwal.getJumlahJadwal() > 0) {
                    jadwal.simpanKeFile(writer);
                } else {
                    writer.println("  Tidak ada jadwal yang terdaftar.");
                }
            }
            System.out.println("Jadwal mahasiswa berhasil disimpan ke file JadwalMahasiswa.txt.");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data ke file.");
        }
    }

    public static void hitungDanSimpanTranskrip(Scanner scanner, ArrayList<Mahasiswa> mahasiswaList) {
        System.out.println("Pilih mahasiswa untuk memasukkan nilai:");
        for (int i = 0; i < mahasiswaList.size(); i++) {
            System.out.println((i + 1) + ". " + mahasiswaList.get(i).getNama() + " (NIM: " + mahasiswaList.get(i).nim + ")");
        }

        int pilihMahasiswaNilai = scanner.nextInt() - 1;
        scanner.nextLine();
        Mahasiswa mahasiswaDipilih = mahasiswaList.get(pilihMahasiswaNilai);
        Jadwal jadwal = mahasiswaDipilih.getJadwal();

        double totalTeori = 0, totalPraktikum = 0;
        int jumlahTeori = 0, jumlahPraktikum = 0;

        for (int i = 0; i < jadwal.getJumlahJadwal(); i++) {
            String matkul = jadwal.getMatakuliah(i);

            if (matkul.contains("Teori")) {
                System.out.print("Masukkan nilai UTS untuk " + matkul + ": ");
                double uts = scanner.nextDouble();
                System.out.print("Masukkan nilai UAS untuk " + matkul + ": ");
                double uas = scanner.nextDouble();
                System.out.print("Masukkan nilai Tugas untuk " + matkul + ": ");
                double tugas = scanner.nextDouble();
                scanner.nextLine();

                double nilaiTeori = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3);
                totalTeori += nilaiTeori;
                jumlahTeori++;
            } else if (matkul.contains("Praktikum")) {
                System.out.print("Masukkan nilai Laporan untuk " + matkul + ": ");
                double laporan = scanner.nextDouble();
                System.out.print("Masukkan nilai Responsi untuk " + matkul + ": ");
                double responsi = scanner.nextDouble();
                System.out.print("Masukkan nilai Kehadiran untuk " + matkul + ": ");
                double kehadiran = scanner.nextDouble();
                scanner.nextLine();

                double nilaiPraktikum = (laporan * 0.4) + (responsi * 0.4) + (kehadiran * 0.2);
                totalPraktikum += nilaiPraktikum;
                jumlahPraktikum++;
            }
        }

        double rataRataTeori = jumlahTeori > 0 ? totalTeori / jumlahTeori : 0;
        double rataRataPraktikum = jumlahPraktikum > 0 ? totalPraktikum / jumlahPraktikum : 0;
        double nilaiKomulatif = jumlahTeori > 0 && jumlahPraktikum == 0 ? rataRataTeori : (rataRataTeori * 0.75) + (rataRataPraktikum * 0.25);

        System.out.println("Mahasiswa: " + mahasiswaDipilih.getNama() + " (NIM: " + mahasiswaDipilih.nim + ")");
        System.out.println("Rata-Rata Teori: " + rataRataTeori);
        System.out.println("Rata-Rata Praktikum: " + rataRataPraktikum);
        System.out.println("Nilai Komulatif: " + nilaiKomulatif);

        try (PrintWriter writer = new PrintWriter(new FileWriter("TranskipMahasiswa.txt", true))) {
            writer.println("Mahasiswa: " + mahasiswaDipilih.getNama() + " (NIM: " + mahasiswaDipilih.nim + ")");
            writer.println("Rata-Rata Teori: " + rataRataTeori);
            writer.println("Rata-Rata Praktikum: " + rataRataPraktikum);
            writer.println("Nilai Komulatif: " + nilaiKomulatif);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan transkrip mahasiswa ke file.");
        }
    }

    public static void tampilkanIsiFile(String fileName) {
        System.out.println("\n=== Membaca Isi File ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }

    public static void kurangiMatakuliah(Scanner scanner, ArrayList<Mahasiswa> mahasiswaList) {
        System.out.println("Pilih mahasiswa untuk menghapus matakuliah:");
        for (int i = 0; i < mahasiswaList.size(); i++) {
            System.out.println((i + 1) + ". " + mahasiswaList.get(i).getNama());
        }

        int pilihMahasiswaHapus = scanner.nextInt() - 1;
        scanner.nextLine();
        Mahasiswa mahasiswaDipilih = mahasiswaList.get(pilihMahasiswaHapus);
        Jadwal jadwal = mahasiswaDipilih.getJadwal();

        if (jadwal.getJumlahJadwal() == 0) {
            System.out.println("Mahasiswa ini belum mengambil matakuliah apa pun.");
            return;
        }

        System.out.println("\nDaftar matakuliah yang diambil:");
        for (int i = 0; i < jadwal.getJumlahJadwal(); i++) {
            System.out.println((i + 1) + ". " + jadwal.getMatakuliah(i));
        }

        System.out.print("Pilih matakuliah yang ingin dihapus: ");
        int pilihMatkulHapus = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("Matakuliah " + jadwal.getMatakuliah(pilihMatkulHapus) + " berhasil dihapus.");
        jadwal.hapusJadwal(pilihMatkulHapus);
    }

    @Override
    public void displayInfo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
