abstract  class MatkulTeori extends Matakuliah{
    private int sks; 
    public MatkulTeori(String kodeMatkul, String namaMatkul, int sks) {
        super(namaMatkul, kodeMatkul);
        this.sks = sks;
    }

    // Getter dan Setter


    public int getSks() {
        return this.sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
    
    // Untuk Display

    public void display(){};


  

}