public class TranskripMataKuliahTeori {
    private MatakuliahTeori matakuliahTeori;

    public TranskripMataKuliahTeori(MatakuliahTeori matakuliahTeori) {
        this.matakuliahTeori = matakuliahTeori;
    }

    public double hitungNilaiAkhir() {
        return matakuliahTeori.hitungNilai();
    }

    @Override
    public String toString() {
        return matakuliahTeori.getNama() + " - Nilai Akhir: " + hitungNilaiAkhir();
    }
}