import java.util.ArrayList;
import java.util.List;

class  TranskripTotalMahasiswa implements PerhitunganNilaiTotal {
    private Mahasiswa mahasiswa;
    private List<Double> nilaiTeori;
    private List<Double> nilaiPraktikum;

    public TranskripTotalMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
        this.nilaiTeori = new ArrayList<>();
        this.nilaiPraktikum = new ArrayList<>();
    }

    public void tambahNilaiTeori(double nilai) {
        nilaiTeori.add(nilai);
    }

    public void tambahNilaiPraktikum(double nilai) {
        nilaiPraktikum.add(nilai);
    }

    public double hitungTotalNilai(List<Double> nilaiMatkulTeori, List<Double> nilaiMatkulPraktikum) {
        double totalTeori = 0;
        for (double nilai : nilaiMatkulTeori) {
            totalTeori += nilai; // Menjumlahkan semua nilai teori
        }
    
        double totalPraktikum = 0;
        for (double nilai : nilaiMatkulPraktikum) {
            totalPraktikum += nilai; // Menjumlahkan semua nilai praktikum
        }
    
        // Menghitung nilai akhir dengan bobot 75% untuk teori dan 25% untuk praktikum
        double nilaiAkhir = (0.75 * totalTeori) + (0.25 * totalPraktikum);
        return nilaiAkhir;
    }

    
}
