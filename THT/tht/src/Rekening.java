public abstract class Rekening implements Otorisasi {
    private String nomorRekening;
    private String pemilik;
    private double saldo;
    private String pin;
    private final BukuMutasi bukuMutasi;

    public Rekening(String nomorRekening, String pemilik, double saldoAwal, String pin) {
        this.nomorRekening = nomorRekening;
        this.pemilik = pemilik;
        this.saldo = saldoAwal;
        this.pin = pin;
        this.bukuMutasi = new BukuMutasi();
        bukuMutasi.catatMutasi("Rekening dibuka. Saldo awal: Rp" + saldoAwal);
    }

    public double getSaldo() {
         return saldo; 
        }
    public String getNomorRekening() { 
        return nomorRekening; 
    }
    public String getPemilik() { 
        return pemilik; 
    }

    protected void setSaldo(double saldo) { 
        this.saldo = saldo; 
    }

    protected void catatMutasi(String keterangan) {
        bukuMutasi.catatMutasi(keterangan);
    }

    @Override
    public boolean verifikasiPIN(String pinInput) {
        return this.pin.equals(pinInput);
    }

    public void setor(double jumlah) { // Proses setoran dengan validasi jumlah dan pencatatan mutasi
        if (jumlah <= 0) {
            System.out.println("Jumlah setoran tidak valid.");
            return;
        }
        saldo += jumlah;
        bukuMutasi.catatMutasi("Setor: +Rp" + jumlah + " | Saldo: Rp" + saldo);
        System.out.println("Setoran Rp" + jumlah + " berhasil. Saldo: Rp" + saldo);
    }

    public abstract void tarik(double jumlah);

    public void cetakHistori() { // Menampilkan histori mutasi dari buku mutasi yang terkait dengan rekening ini
        System.out.println("Histori Mutasi - Rekening " + nomorRekening + " (" + pemilik + "):");
        bukuMutasi.cetakHistori();
    }

    public void infoRekening() { // Menampilkan informasi lengkap tentang rekening, termasuk nomor, pemilik, saldo, dan jenis rekening
        System.out.println("No. Rekening : " + nomorRekening);
        System.out.println("Pemilik      : " + pemilik);
        System.out.println("Saldo        : Rp" + saldo);
        System.out.println("Jenis        : " + this.getClass().getSimpleName());
    }
}