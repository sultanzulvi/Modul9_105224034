public class BukuMutasi {
    private String[] riwayat;
    private int jumlahEntri;
    private static final int KAPASITAS = 100;

    public BukuMutasi() { 
        this.riwayat = new String[KAPASITAS];
        this.jumlahEntri = 0;
    }

    public void catatMutasi(String keterangan) { // Menambahkan entri mutasi baru ke dalam buku mutasi
        if (jumlahEntri < KAPASITAS) {
            riwayat[jumlahEntri++] = keterangan;
        }
    }

    public void cetakHistori() { // Menampilkan seluruh riwayat mutasi
        if (jumlahEntri == 0) {
            System.out.println("  (Belum ada riwayat transaksi)");
            return;
        }
        for (int i = 0; i < jumlahEntri; i++) {
            System.out.println("  " + (i + 1) + ". " + riwayat[i]);
        }
    }
}