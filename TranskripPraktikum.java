import java.util.Scanner;

public class TranskripPraktikum {
    private double laporan;
    private double responsi;
    private double kehadiran;

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
