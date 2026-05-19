class Montir {
    private String idMontir;
    private String nama;

    public Montir(String idMontir, String nama) {
        this.idMontir = idMontir;
        this.nama = nama;
    }

    public void lakukanQualityControl(Mobil m) {
        System.out.println("Montir " + this.nama + " (ID: " + this.idMontir + ") sedang melakukan Quality Control.");
        m.tampilkanSpesifikasi();
    }
}