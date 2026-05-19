class Mobil {
    private String merkMobil;
    private String warna;
    private final Mesin mesin;
    private Ban[] daftarBan;

    public Mobil(String merkMobil, String warna, String nomorSeriMesin, int ccMesin) {
        this.merkMobil = merkMobil;
        this.warna = warna;
        this.mesin = new Mesin(nomorSeriMesin, ccMesin);
        this.daftarBan = new Ban[4];
    }

    public void pasangSetBan(Ban[] setBan) {
        if (setBan != null && setBan.length <= 4) {
            for (int i = 0; i < setBan.length; i++) {
                this.daftarBan[i] = setBan[i];
            }
        }
    }

    public void tampilkanSpesifikasi() {
        System.out.println("Merk Mobil : " + this.merkMobil);
        System.out.println("Warna      : " + this.warna);
        System.out.println("No Seri MSN: " + this.mesin.getNomorSeri());
        System.out.println("Kapasitas  : " + this.mesin.getKapasitasCC() + " CC");
        System.out.print("Daftar Ban : ");
        for (Ban b : daftarBan) {
            if (b != null) {
                System.out.print(b.getMerk() + "(R" + b.getUkuranRing() + ") ");
            }
        }
    }
}