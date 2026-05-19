class Dokter {
    private String nama;
    private String spesialisasi;

    public Dokter(String nama, String spesialisasi) {
        this.nama = nama;
        this.spesialisasi = spesialisasi;
    }

    public String getNama() {
        return this.nama;
    }

    public String getSpesialisasi() {
        return this.spesialisasi;
    }

    public void DisplayInfo() {
        System.out.println("Nama Dokter : " + nama);
        System.out.println("Spesialisasi : " + spesialisasi);
    }

    public void periksaPasien(Pasien pasien) {
        System.out.println("Dokter Penanggung Jawab : " + this.nama + " (" + this.spesialisasi + ")");
        System.out.println("Pasien yang Ditangani   : " + pasien.getNama() + " (Usia: " + pasien.getUmur() + " tahun)");
    }
}