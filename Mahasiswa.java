import java.util.ArrayList;
import java.util.List;

class Mahasiswa extends Person {
    private String nim;
    private  ProgramStudi programStudi;
    private List<Matakuliah> daftarMataKuliah;
    private TranskripTotalMahasiswa transkrip;

    public Mahasiswa(String nama, String alamat, String nim, ProgramStudi programStudi) {
        super(nama, alamat);
        this.nim = nim;
        this.programStudi = programStudi;
        this.daftarMataKuliah = new ArrayList<>();
        this.transkrip = new TranskripTotalMahasiswa(this);
    }

    public String getNim() {
        return nim;
    }

    public ProgramStudi getProgramStudi() {
        return programStudi;
    }

    public List<Matakuliah> getDaftarMataKuliah() {
        return daftarMataKuliah;
    }

    public TranskripTotalMahasiswa getTranskrip() {
        return transkrip;
    }

    
    
}
