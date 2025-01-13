import java.util.Scanner;

public class MatakuliahTeori extends Matakuliah {
    private double uts;
    private double uas;
    private double tugas;

    public MatakuliahTeori(String kode, String nama, String hari, String waktu, String dosen, double uts, double uas, double tugas) {
        super(kode, nama, hari, waktu, dosen);
        this.uts = uts;
        this.uas = uas;
        this.tugas = tugas;
    }
    public MatakuliahTeori(){
        super("","","","","");
        this.uts = 0;
        this.uas = 0;
        this.tugas = 0;
    }

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
