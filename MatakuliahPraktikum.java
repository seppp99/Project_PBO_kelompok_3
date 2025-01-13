import java.util.Scanner;

public class MatakuliahPraktikum extends Matakuliah {

    private double laporan;
    private double responsi;
    private double kehadiran;

    public MatakuliahPraktikum(String kode, String nama, String hari, String waktu, String dosen, double laporan, double responsi, double kehadiran) {
        super(kode, nama, hari, waktu, dosen);
        this.laporan = laporan;
        this.responsi = responsi;
        this.kehadiran = kehadiran;
    }

    public MatakuliahPraktikum(){
        super("","","","","");
        this.laporan = 0;
        this.responsi = 0;
        this.kehadiran = 0;
    }

    public void inputNilai(Scanner scanner, String matakuliah) {
        System.out.print("Masukkan nilai Laporan untuk " + matakuliah + ": ");
        this.laporan = scanner.nextDouble();
        System.out.print("Masukkan nilai Responsi untuk " + matakuliah + ": ");
        this.responsi = scanner.nextDouble();
        System.out.print("Masukkan nilai Kehadiran untuk " + matakuliah + ": ");
        this.kehadiran = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
    }

    public double hitungRataRata() {
        return (laporan * 0.4) + (responsi * 0.4) + (kehadiran * 0.2);
    }
}
