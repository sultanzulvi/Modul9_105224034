public class RekeningPrioritas extends Rekening {
    private static final double MINIMUM_TARIK = 50000; // Batas minimum penarikan untuk rekening prioritas

    public RekeningPrioritas(String nomorRekening, String pemilik, double saldoAwal, String pin) {
        super(nomorRekening, pemilik, saldoAwal, pin);
    }

    @Override
    public void tarik(double jumlah) { // Proses penarikan dengan validasi jumlah, minimum penarikan, dan pencatatan mutasi tanpa biaya admin
        if (jumlah <= 0) {
            System.out.println("Jumlah penarikan tidak valid.");
            return;
        }
        if (jumlah < MINIMUM_TARIK) {
            System.out.println("Gagal. Minimum penarikan adalah Rp" + MINIMUM_TARIK);
            return;
        }
        if (getSaldo() < jumlah) {
            System.out.println("Saldo tidak mencukupi untuk menarik Rp" + jumlah);
            return;
        }
        setSaldo(getSaldo() - jumlah);
        catatMutasi("Tarik: -Rp" + jumlah + " | Saldo: Rp" + getSaldo());
        System.out.println("Penarikan Rp" + jumlah + " berhasil (tanpa biaya admin). Saldo: Rp" + getSaldo());
    }
}