class Dosen extends Person{
    private int NIDN;
    private String Matakuliah;
    public Dosen(String name, int age, int nidn, String Matakuliah) {
        super(name, age);
        this.NIDN = nidn;
        this.Matakuliah = Matakuliah;
    }

    public int getNIDN() {
        return this.NIDN;
    }

    public void setNIDN(int NIDN) {
        this.NIDN = NIDN;
    }

    public String getMatakuliah() {
        return this.Matakuliah;
    }

    public void setMatakuliah(String Matakuliah) {
        this.Matakuliah = Matakuliah;
    }
    
}