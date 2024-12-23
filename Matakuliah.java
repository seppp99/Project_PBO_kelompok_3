abstract class Matakuliah{
    private String nama;
    private String kode;
    private String dosen;
    private int sks;

    public Matakuliah(String nama, String kode, String dosen, int sks){
        this.nama = nama;
        this.kode = kode;
        this.dosen = dosen;
        this.sks = sks;
    }
    
// Getter dan Setter
  
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }
   
    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    // Untuk Display

    public abstract void display();

}