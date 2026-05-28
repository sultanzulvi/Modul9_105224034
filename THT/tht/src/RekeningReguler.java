public class RekeningReguler extends Rekening {
    private static final double BIAYA_ADMIN = 2500; // Biaya admin tetap untuk setiap penarikan

    public RekeningReguler(String nomorRekening, String pemilik, double saldoAwal, String pin) {
        super(nomorRekening, pemilik, saldoAwal, pin);
    }

    @Override
    public void tarik(double jumlah) { // Proses penarikan dengan validasi jumlah, saldo mencukupi untuk penarikan + biaya admin, dan pencatatan mutasi dengan biaya admin
        double totalPenarikan = jumlah + BIAYA_ADMIN;
        if (jumlah <= 0) {
            System.out.println("Jumlah penarikan tidak valid.");
            return;
        }
        if (getSaldo() < totalPenarikan) {
            System.out.println("Saldo tidak mencukupi. (Tarik: Rp" + jumlah + " + Admin: Rp" + BIAYA_ADMIN + ")");
            return;
        }
        setSaldo(getSaldo() - totalPenarikan);
        catatMutasi("Tarik: -Rp" + jumlah + " | Admin: -Rp" + BIAYA_ADMIN + " | Saldo: Rp" + getSaldo());
        System.out.println("Penarikan Rp" + jumlah + " berhasil. Biaya admin: Rp" + BIAYA_ADMIN + ". Saldo: Rp" + getSaldo());
    }
}