public interface PengelolaanJadwal {
    void tambahJadwal(String matakuliah, String hari, String waktu, String dosen);
    void hapusJadwal(int indeks);
    void tampilkanJadwal();
}
