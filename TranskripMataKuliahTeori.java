import java.util.Scanner;

public class TranskripMatakuliahTeori {
    private double uts;
    private double uas;
    private double tugas;

    public void inputNilai(Scanner scanner, String matakuliah) {
        System.out.print("Masukkan nilai UTS untuk " + matakuliah + ": ");
        this.uts = scanner.nextDouble();
        System.out.print("Masukkan nilai UAS untuk " + matakuliah + ": ");
        this.uas = scanner.nextDouble();
        System.out.print("Masukkan nilai Tugas untuk " + matakuliah + ": ");
        this.tugas = scanner.nextDouble();
        scanner.nextLine();
    }

    public double hitungRataRata() {
        return (uts * 0.3) + (uas * 0.4) + (tugas * 0.3);
    }
}
