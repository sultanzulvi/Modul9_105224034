public class CustomerService {
    private String namaAgen;
    private String idAgen;

    public CustomerService(String namaAgen, String idAgen) {
        this.namaAgen = namaAgen;
        this.idAgen = idAgen;
    }

    public void laporkanKeluhan(Nasabah nasabah, String keluhan) { // Proses pelaporan keluhan dari nasabah ke customer service dengan menampilkan informasi nasabah dan isi keluhan
        System.out.println("[Customer Service - " + namaAgen + "] Menerima laporan dari nasabah " + nasabah.getNama() + " (ID: " + nasabah.getIdNasabah() + ")");
        System.out.println("  Keluhan: " + keluhan);
        System.out.println("  Status: Keluhan dicatat, terima kasih atas laporannya");
    }
}