public class TranskripTotal {
    public double hitungNilaiKomulatif(double rataRataTeori, double rataRataPraktikum, int jumlahTeori, int jumlahPraktikum) {
        if (jumlahTeori > 0 && jumlahPraktikum == 0) {
            return rataRataTeori; // Jika hanya mengambil teori
        } else {
            return (rataRataTeori * 0.75) + (rataRataPraktikum * 0.25); // Gabungan teori dan praktikum
        }
    }
}
