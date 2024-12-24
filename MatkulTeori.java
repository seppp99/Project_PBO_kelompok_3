abstract class MatkulTeori extends Matakuliah{
    private String namaMatkul;
    //TOLONG INI DITAMBAHIN SUPER() SUPAYA RELASI 
    
    public Praktikum(String namaMatkul){
        this.namaMatkul = namaMatkul;
        super(); // kayak yang ini
    }

    // Getter dan Setter

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    // Untuk Display

    public void display(){};


  

}