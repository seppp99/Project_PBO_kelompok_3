public class TranskripPraktikum {
    private MatakuliahPraktikum matakuliahPraktikum;

    public TranskripPraktikum(MatakuliahPraktikum matakuliahPraktikum) {
        this.matakuliahPraktikum = matakuliahPraktikum;
    }

    public double hitungNilaiAkhir() {
        return matakuliahPraktikum.hitungNilai();
    }

    @Override
    public String toString() {
        return matakuliahPraktikum.getNama() + " - Nilai Akhir: " + hitungNilaiAkhir();
    }
}