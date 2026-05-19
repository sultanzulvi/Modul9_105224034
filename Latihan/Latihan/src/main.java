public class main {
    public static void main(String[] args) {
   
        Dokter drHasan = new Dokter("Hasan", "Spesialis Jantung");
        Dokter drSiti = new Dokter("Siti", "Spesialis Anak");

        Pasien pasienBudi = new Pasien("Budi", 45);
        Pasien pasienRani = new Pasien("Rani", 8);

        drHasan.periksaPasien(pasienBudi);
        drSiti.periksaPasien(pasienRani);

        RumahSakit rsSehatSelalu = new RumahSakit("RS Sehat Selalu");

        rsSehatSelalu.tugaskanDokter(drHasan);

        rsSehatSelalu.cetakDaftarRuangan();
        System.out.println();
        rsSehatSelalu.tampilkanDaftarDokter();
        System.out.println();

        rsSehatSelalu = null; 

        System.out.println("Nama: " + drHasan.getNama());
        System.out.println("Nama: " + drSiti.getNama());
        System.out.println("Data Pasien Budi, Nama: " + pasienBudi.getNama());
    }
}