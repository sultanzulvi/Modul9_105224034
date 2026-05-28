public class Nasabah {
    private String nama;
    private String idNasabah;
    private Rekening[] daftarRekening;
    private int jumlahRekening;
    private static final int MAKS_REKENING = 3;

    public Nasabah(String nama, String idNasabah) {
        this.nama = nama;
        this.idNasabah = idNasabah;
        this.daftarRekening = new Rekening[MAKS_REKENING];
        this.jumlahRekening = 0;
    }

    public String getNama() { 
        return nama; 
    }
    public String getIdNasabah() { 
        return idNasabah; 
    }

    public boolean tambahRekening(Rekening rekening) { // Proses penambahan rekening baru ke dalam profil nasabah dengan pengecekan batas maksimum rekening yang dapat dimiliki
        if (jumlahRekening >= MAKS_REKENING) {
            System.out.println("Profil " + nama + " sudah mencapai batas maksimum " + MAKS_REKENING + " rekening.");
            return false;
        }
        daftarRekening[jumlahRekening++] = rekening;
        System.out.println("Rekening " + rekening.getNomorRekening() + " berhasil ditambahkan ke profil " + nama);
        return true;
    }

    public void tampilkanSemuaRekening() { // Menampilkan semua rekening yang dimiliki nasabah
        System.out.println("Profil Nasabah: " + nama + " (ID: " + idNasabah + ")");
        if (jumlahRekening == 0) {
            System.out.println("  Belum memiliki rekening.");
            return;
        }
        for (int i = 0; i < jumlahRekening; i++) {
            System.out.println("  Rekening " + (i + 1) + ":");
            daftarRekening[i].infoRekening();
        }
    }
}