class Mahasiswa extends Person {
    private String NIM;
    private String Jurusan;
    public Mahasiswa(String name, int alamat, String nim,String jurusan) {
        super(name, alamat);
        this.NIM = nim;
        this.Jurusan = jurusan;
    }

    public String getNIM() {
        return this.NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }


    public String getJurusan() {
        return this.Jurusan;
    }

    public void setJurusan(String Jurusan) {
        this.Jurusan = Jurusan;
    }

    
}
