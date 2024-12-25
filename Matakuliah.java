
import java.util.ArrayList;
import java.util.List;

abstract class Matakuliah{
    protected String kode;
    protected String nama;
    protected int jumlahSKS;
    protected Dosen dosenPengampu;
    protected JadwalKuliah jadwal;
    protected int kuota;
    protected List<Mahasiswa> mahasiswaTerdaftar;

    public Matakuliah(String kode, String nama, int jumlahSKS, Dosen dosenPengampu, JadwalKuliah jadwal, int kuota) {
        this.kode = kode;
        this.nama = nama;
        this.jumlahSKS = jumlahSKS;
        this.dosenPengampu = dosenPengampu;
        this.jadwal = jadwal;
        this.kuota = kuota;
        this.mahasiswaTerdaftar = new ArrayList<>();
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public JadwalKuliah getJadwal() {
        return jadwal;
    }
    public abstract void berikanNilai(Mahasiswa mahasiswa, double... nilai);

}