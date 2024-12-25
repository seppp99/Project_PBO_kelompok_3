class MatkulTeori extends Matakuliah {
    public MatkulTeori(String kode, String nama, int jumlahSKS, Dosen dosenPengampu, JadwalKuliah jadwal, int kuota) {
        super(kode, nama, jumlahSKS, dosenPengampu, jadwal, kuota);
    }

    @Override
    public void berikanNilai(Mahasiswa mahasiswa, double... nilai) {
        if (nilai.length == 2) {
            double tugas = nilai[0];
            double ujian = nilai[1];
            double nilaiAkhir = 0.4 * tugas + 0.6 * ujian;
            mahasiswa.getTranskrip().tambahNilaiTeori(nilaiAkhir);
            System.out.println("Nilai akhir mahasiswa " + mahasiswa.getName() + " di " + nama + ": " + nilaiAkhir);
        } else {
            System.out.println("Masukkan nilai tugas dan ujian untuk teori.");
        }
    }
}