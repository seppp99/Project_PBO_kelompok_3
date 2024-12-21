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

    public abstract void display();
}