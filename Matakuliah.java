public class Matakuliah {
    
    protected String kode;
    protected String nama;
    protected String hari;
    protected String waktu;
    protected String dosen;

    public Matakuliah(String kode, String nama, String hari, String waktu, String dosen) {
        this.kode = kode;
        this.nama = nama;
        this.hari = hari;
        this.waktu = waktu;
        this.dosen = dosen;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getHari() {
        return hari;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getDosen() {
        return dosen;
    }
}
