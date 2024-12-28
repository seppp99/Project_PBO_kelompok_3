import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Dosen> dosenList = bacaDosenDariFile("Dosen.txt");
        ArrayList<Mahasiswa> mahasiswaList = bacaMahasiswaDariFile("Mahasiswa.txt");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nMenu:");
            System.out.println("1. Daftarkan Mahasiswa Baru");
            System.out.println("2. Tambah Matakuliah");
            System.out.println("3. Lihat Info Dosen");
            System.out.println("4. Lihat Semua Matkul Mahasiswa");
            System.out.println("5. Simpan Jadwal ke File");
            System.out.println("6. Hitung dan Simpan Transkrip Mahasiswa");
            System.out.println("7. Lihat Isi File JadwalMahasiswa.txt");
            System.out.println("8. Kurangi Matakuliah");
            System.out.println("9. Keluar");
            System.out.print("Pilih opsi: ");

            int opsi = scanner.nextInt();
            scanner.nextLine();

            switch (opsi) {
                case 1:
                    Mahasiswa.daftarkanMahasiswa(scanner, mahasiswaList);
                    simpanMahasiswaKeFile(mahasiswaList, "Mahasiswa.txt");
                    break;

                case 2:
                    if (!mahasiswaList.isEmpty()) {
                        Mahasiswa.tambahMatakuliah(scanner, mahasiswaList, dosenList);
                    } else {
                        System.out.println("Belum ada mahasiswa terdaftar.");
                    }
                    break;

                case 3:
                    Dosen.tampilkanInfoDosen("Dosen.txt");
                    break;

                case 4:
                    Mahasiswa.tampilkanJadwalSemuaMahasiswa("JadwalMahasiswa.txt");
                    break;

                case 5:
                    Mahasiswa.simpanJadwalKeFile(mahasiswaList, "JadwalMahasiswa.txt");
                    break;

                case 6:
                    if (!mahasiswaList.isEmpty()) {
                        Mahasiswa.hitungDanSimpanTranskrip(scanner, mahasiswaList);
                    } else {
                        System.out.println("Belum ada mahasiswa terdaftar.");
                    }
                    break;

                case 7:
                    Mahasiswa.tampilkanIsiFile("TranskipMahasiswa.txt");
                    break;

                case 8:
                    if (!mahasiswaList.isEmpty()) {
                        Mahasiswa.kurangiMatakuliah(scanner, mahasiswaList);
                    } else {
                        System.out.println("Belum ada mahasiswa terdaftar.");
                    }
                    break;

                case 9:
                    isRunning = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
        scanner.close();
    }

    public static ArrayList<Dosen> bacaDosenDariFile(String fileName) {
        ArrayList<Dosen> dosenList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 5) {
                    System.out.println("Baris tidak valid, dilewati: " + line);
                    continue;
                }
                dosenList.add(new Dosen(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), Integer.parseInt(data[4].trim())));
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file dosen.");
        }
        return dosenList;
    }

    public static ArrayList<Mahasiswa> bacaMahasiswaDariFile(String fileName) {
        ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 2) {
                    System.out.println("Baris tidak valid, dilewati: " + line);
                    continue;
                }
                mahasiswaList.add(new Mahasiswa(data[0].trim(), data[1].trim()));
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file mahasiswa.");
        }
        return mahasiswaList;
    }

    public static void simpanMahasiswaKeFile(ArrayList<Mahasiswa> mahasiswaList, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Mahasiswa mahasiswa : mahasiswaList) {
                writer.println(mahasiswa.getNama() + "," + mahasiswa.nim);
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data mahasiswa.");
        }
    }
}
