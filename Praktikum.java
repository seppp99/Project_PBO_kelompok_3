class Praktikum extends Matakuliah {
    public Praktikum(String kode, String nama, int jumlahSKS, Dosen dosenPengampu, JadwalKuliah jadwal, int kuota) {
        super(kode, nama, jumlahSKS, dosenPengampu, jadwal, kuota);
    }

    @Override
    public void berikanNilai(Mahasiswa mahasiswa, double... nilai) {
        if (nilai.length == 2) {
            double kehadiran = nilai[0];
            double praktikum = nilai[1];
            double nilaiAkhir = 0.3 * kehadiran + 0.7 * praktikum;
            mahasiswa.getTranskrip().tambahNilaiPraktikum(nilaiAkhir);
            System.out.println("Nilai akhir mahasiswa " + mahasiswa.getName() + " di " + nama + ": " + nilaiAkhir);
        } else {
            System.out.println("Masukkan nilai kehadiran dan praktikum.");
        }
    }
}