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

    public double hitungNilai() {
        return (uts * 0.3) + (uas * 0.4) + (tugas * 0.3);
    }

    public void setNilai(double uts, double uas, double tugas) {
        this.uts = uts;
        this.uas = uas;
        this.tugas = tugas;
    }

    @Override
    public String toString() {
        return super.getNama() + " (UTS: " + uts + ", UAS: " + uas + ", Tugas: " + tugas + ")";
    }
}
