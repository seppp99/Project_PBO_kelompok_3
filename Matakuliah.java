
import java.util.ArrayList;
import java.util.List;


abstract class Matakuliah{
    private String namaMatkul;
    private String kodeMatkul;
    private Dosen dosen;
    private List<Mahasiswa> daftarMahasiswa;
    

    public Matakuliah(String namaMatkul, String kodeMatkul){
        this.namaMatkul = namaMatkul;
        this.kodeMatkul = kodeMatkul;
        this.daftarMahasiswa = new ArrayList<>();
    }
    
// Getter dan Setter
  
    public String getNama() {
        return namaMatkul;
    }

    public void setNama(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getKode() {
        return kodeMatkul;
    }
   
    public void setKode(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }


    // Untuk Display

    public abstract void display();

}