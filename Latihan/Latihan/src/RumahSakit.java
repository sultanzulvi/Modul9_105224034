class RumahSakit {
    private String namaRumahSakit;
    private final Ruangan[] daftarRuangan;
    private Dokter[] daftarDokter;
    private int jumlahDokterAktif;

    public RumahSakit(String namaRumahSakit) {
        this.namaRumahSakit = namaRumahSakit;
        this.jumlahDokterAktif = 0;
        this.daftarRuangan = new Ruangan[2];
        this.daftarDokter = new Dokter[2];

        this.daftarRuangan[0] = new Ruangan("R-01", 5);
        this.daftarRuangan[1] = new Ruangan("R-02", 3);
    }

    public void tugaskanDokter(Dokter dokter) {
        if (jumlahDokterAktif < daftarDokter.length) {
            this.daftarDokter[jumlahDokterAktif] = dokter;
            jumlahDokterAktif++;
        } else {
            System.out.println("Penuh");
        }
    }

    public void cetakDaftarRuangan() {
        System.out.println("Daftar Ruangan " + this.namaRumahSakit + ":");
        for (Ruangan r : daftarRuangan) {
            if (r != null) {
                System.out.println("No. Registrasi: " + r.getNomorRegistrasi());
                System.out.println("Kapasitas Maksimal : " + r.getKapasitasMaksimal() + " pasien");
            }
        }
    }

    public void tampilkanDaftarDokter() {
        System.out.println("Daftar Tenaga Medis di " + this.namaRumahSakit + ":");
        if (jumlahDokterAktif == 0) {
            System.out.println(" X ");
        } else {
            for (int i = 0; i < jumlahDokterAktif; i++) {
                if (daftarDokter[i] != null) {
                    System.out.println("Dokter : " + daftarDokter[i].getNama() + " (" + daftarDokter[i].getSpesialisasi() + ")");
                }
            }
        }
    }
}