public class TranskripTotal {
    private double rataRataTeori;
    private double rataRataPraktikum;

    public TranskripTotal(double rataRataTeori, double rataRataPraktikum) {
        this.rataRataTeori = rataRataTeori;
        this.rataRataPraktikum = rataRataPraktikum;
    }

    public double hitungTotal() {
        if (rataRataPraktikum == 0) {
            // Jika tidak ada praktikum, total hanya dari teori
            return rataRataTeori;
        } else {
            return (rataRataTeori * 0.75) + (rataRataPraktikum * 0.25);
        }
    }

    @Override
    public String toString() {
        return "Rata-Rata Teori: " + rataRataTeori + ", Rata-Rata Praktikum: " + rataRataPraktikum +
               ", Nilai Total: " + hitungTotal();
    }
}