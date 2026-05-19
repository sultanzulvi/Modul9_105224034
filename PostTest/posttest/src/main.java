public class main {
    public static void main(String[] args) {

        Ban ban1 = new Ban("Bridgestone", 17);
        Ban ban2 = new Ban("Bridgestone", 17);
        Ban ban3 = new Ban("Bridgestone", 17);
        Ban ban4 = new Ban("Bridgestone", 17);
        Ban[] setBanMobil = {ban1, ban2, ban3, ban4};

        Mobil mobilUtama = new Mobil("Toyota Yaris", "Putih", "G16E-GTS", 1600);
        mobilUtama.pasangSetBan(setBanMobil);

        Montir montirEko = new Montir("MTR-001", "Eko");
        montirEko.lakukanQualityControl(mobilUtama);

        System.out.println("\nHasil: GAGAL UJI KELAYAKAN! Menghancurkan mobil...");
        mobilUtama = null;

        System.out.println("Ban 1       : " + (ban1 != null ? "Selamat di Gudang" : "Musnah"));
        System.out.println("Montir Eko  : " + (montirEko != null ? "Masih Eksis" : "Musnah"));
    
    }
}