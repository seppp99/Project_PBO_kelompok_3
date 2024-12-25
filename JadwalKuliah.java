class JadwalKuliah implements Jadwal {
    private String hari;
    private String waktuMulai;
    private String waktuSelesai;

    public JadwalKuliah(String hari, String waktuMulai, String waktuSelesai) {
        this.hari = hari;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = waktuSelesai;
    }

    public boolean isJadwalBentrok(JadwalKuliah jadwalLain) {
        if (this.hari.equalsIgnoreCase(jadwalLain.hari)) {
            if (this.waktuMulai.compareTo(jadwalLain.waktuSelesai) < 0 && this.waktuSelesai.compareTo(jadwalLain.waktuMulai) > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return hari + " " + waktuMulai + " - " + waktuSelesai;
    }
}