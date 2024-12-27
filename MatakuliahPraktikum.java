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

    public double hitungNilai() {
        return (laporan * 0.4) + (responsi * 0.4) + (kehadiran * 0.2);
    }

    public void setNilai(double laporan, double responsi, double kehadiran) {
        this.laporan = laporan;
        this.responsi = responsi;
        this.kehadiran = kehadiran;
    }

    @Override
    public String toString() {
        return super.getNama() + " (Laporan: " + laporan + ", Responsi: " + responsi + ", Kehadiran: " + kehadiran + ")";
    }
}
