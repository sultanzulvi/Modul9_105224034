import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static Nasabah[] daftarNasabah = new Nasabah[10];
    static int jumlahNasabah = 0;
    static Rekening[] semuaRekening = new Rekening[30];
    static int jumlahRekening = 0;

    public static void main(String[] args) {
        System.out.println("Selamat datang di NeoBank!");

        int pilihan; // Variabel untuk menyimpan pilihan menu
        do {
            tampilkanMenu();
            pilihan = bacaInt("Pilih menu: ");

            switch (pilihan) {
                case 1 -> registrasiNasabah();
                case 2 -> bukaRekening();
                case 3 -> simulasiLogin();
                case 4 -> transaksiSetor();
                case 5 -> transaksiTarik();
                case 6 -> hubungiCustomerService();
                case 7 -> penutupanPaksaProfil();
                case 0 -> System.out.println("Terima kasih, sampai jumpa!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }

    static void tampilkanMenu() { // Menampilkan menu utama
        System.out.println();
        System.out.println("1. Registrasi Nasabah Baru");
        System.out.println("2. Buka Rekening");
        System.out.println("3. Simulasi Login (Verifikasi PIN)");
        System.out.println("4. Transaksi Setoran");
        System.out.println("5. Transaksi Penarikan");
        System.out.println("6. Hubungi Customer Service");
        System.out.println("7. Skenario Penutupan Paksa Akun");
        System.out.println("0. Keluar");
    }

    static void registrasiNasabah() { // Proses registrasi nasabah baru
        System.out.println("\nRegistrasi Nasabah Baru");
        System.out.print("Nama lengkap: ");
        String nama = scanner.nextLine();
        String id = "NSB" + String.format("%03d", jumlahNasabah + 1);
        Nasabah nasabah = new Nasabah(nama, id);
        daftarNasabah[jumlahNasabah++] = nasabah;
        System.out.println("Registrasi berhasil! ID Nasabah: " + id);
    }

    static void bukaRekening() { // Proses pembukaan rekening baru untuk nasabah yang sudah terdaftar
        System.out.println("\nBuka Rekening");
        if (jumlahNasabah == 0) { System.out.println("Belum ada nasabah terdaftar."); return; }

        tampilkanDaftarNasabah();
        int idx = bacaInt("Pilih nasabah (nomor): ") - 1;
        if (idx < 0 || idx >= jumlahNasabah) { System.out.println("Pilihan tidak valid."); return; }

        Nasabah nasabah = daftarNasabah[idx];
        System.out.println("Jenis rekening:");
        System.out.println("1. RekeningReguler");
        System.out.println("2. RekeningPrioritas");
        int jenis = bacaInt("Pilih jenis: ");

        System.out.print("Saldo awal (Rp): ");
        double saldo = bacaDouble();
        System.out.print("Buat PIN (6 digit): ");
        String pin = scanner.nextLine();

        String noRek = "REK" + String.format("%04d", jumlahRekening + 1);
        Rekening rekening;

        if (jenis == 1) {
            rekening = new RekeningReguler(noRek, nasabah.getNama(), saldo, pin);
        } else {
            rekening = new RekeningPrioritas(noRek, nasabah.getNama(), saldo, pin);
        }

        semuaRekening[jumlahRekening++] = rekening;
        nasabah.tambahRekening(rekening);
    }

    static void simulasiLogin() { // Proses simulasi login dengan verifikasi PIN
        System.out.println("\nSimulasi Login");
        if (jumlahRekening == 0) { System.out.println("Belum ada rekening terdaftar."); return; }

        tampilkanDaftarRekening();
        int idx = bacaInt("Pilih rekening (nomor): ") - 1;
        if (idx < 0 || idx >= jumlahRekening) { System.out.println("Pilihan tidak valid."); return; }

        System.out.print("Masukkan PIN: ");
        String pin = scanner.nextLine();

        Rekening rek = semuaRekening[idx];
        if (rek.verifikasiPIN(pin)) {
            System.out.println("Login berhasil! Selamat datang, " + rek.getPemilik());
            rek.infoRekening();
        } else {
            System.out.println("PIN salah. Akses ditolak.");
        }
    }

    static void transaksiSetor() { // Proses transaksi setoran dengan verifikasi PIN
        System.out.println("\nTransaksi Setoran");
        Rekening rek = pilihDanVerifikasiRekening();
        if (rek == null) return;
        double jumlah = bacaJumlah("Jumlah setoran (Rp): ");
        rek.setor(jumlah);
        rek.cetakHistori();
    }

    static void transaksiTarik() { // Proses transaksi penarikan dengan verifikasi PIN dan aturan khusus untuk masing-masing jenis rekening
        System.out.println("\nTransaksi Penarikan");
        Rekening rek = pilihDanVerifikasiRekening();
        if (rek == null) return;
        double jumlah = bacaJumlah("Jumlah penarikan (Rp): ");
        rek.tarik(jumlah);
        rek.cetakHistori();
    }

    static void hubungiCustomerService() { // Proses pelaporan keluhan ke customer service dengan memilih nasabah dan menulis keluhan
        System.out.println("\nCustomer Service");
        if (jumlahNasabah == 0) { System.out.println("Belum ada nasabah terdaftar."); return; }

        CustomerService cs = new CustomerService("Rina", "CS001");
        tampilkanDaftarNasabah();
        int idx = bacaInt("Pilih nasabah yang ingin melapor (nomor): ") - 1;
        if (idx < 0 || idx >= jumlahNasabah) { System.out.println("Pilihan tidak valid."); return; }

        System.out.print("Tulis keluhan: ");
        String keluhan = scanner.nextLine();
        cs.laporkanKeluhan(daftarNasabah[idx], keluhan);
    }

    static void penutupanPaksaProfil() { // Proses penutupan paksa profil nasabah dengan memilih nasabah, menampilkan rekening-rekening yang masih eksis, dan menghapus profil nasabah dari sistem (di-set null)
        System.out.println("\nSkenario Penutupan Paksa Akun");
        if (jumlahNasabah == 0) { 
            System.out.println("Belum ada nasabah terdaftar."); 
            return; }

        tampilkanDaftarNasabah();
        int idx = bacaInt("Pilih nasabah yang akan ditutup paksa (nomor): ") - 1;
        if (idx < 0 || idx >= jumlahNasabah) { 
            System.out.println("Pilihan tidak valid."); 
            return; }

        Nasabah target = daftarNasabah[idx];
        System.out.println("Menutup profil nasabah: " + target.getNama() + " ...");

        daftarNasabah[idx] = null;

        System.out.println("Profil nasabah telah dihapus dari sistem (di-set null).");
        System.out.println("Rekening-rekening tetap tercatat di bank pusat:");
        boolean adaRekening = false;
        for (int i = 0; i < jumlahRekening; i++) {
            if (semuaRekening[i] != null && semuaRekening[i].getPemilik().equals(target.getNama())) {
                System.out.println("  - " + semuaRekening[i].getNomorRekening()
                        + " (" + semuaRekening[i].getClass().getSimpleName() + ")"
                        + " Saldo: Rp" + semuaRekening[i].getSaldo() + " -> masih eksis!");
                adaRekening = true;
            }
        }
        if (!adaRekening) 
            System.out.println("  (Nasabah ini belum memiliki rekening)");

        for (int i = idx; i < jumlahNasabah - 1; i++) {
            daftarNasabah[i] = daftarNasabah[i + 1];
        }
        daftarNasabah[--jumlahNasabah] = null;
    }

    static Rekening pilihDanVerifikasiRekening() { // Proses memilih rekening dan verifikasi PIN untuk transaksi setoran atau penarikan
        if (jumlahRekening == 0) { 
            System.out.println("Belum ada rekening terdaftar."); 
            return null; 
     }
        tampilkanDaftarRekening();
        int idx = bacaInt("Pilih rekening (nomor): ") - 1;
        if (idx < 0 || idx >= jumlahRekening) { 
            System.out.println("Pilihan tidak valid."); 
            return null; 
        }

        System.out.print("Masukkan PIN: ");
        String pin = scanner.nextLine();
        Rekening rek = semuaRekening[idx];
        if (!rek.verifikasiPIN(pin)) {
            System.out.println("PIN salah. Transaksi dibatalkan.");
            return null;
        }
        return rek;
    }

    static void tampilkanDaftarNasabah() { // Menampilkan daftar nasabah yang terdaftar di sistem
        System.out.println("Daftar Nasabah:");
        for (int i = 0; i < jumlahNasabah; i++) {
            System.out.println("  " + (i + 1) + ". " + daftarNasabah[i].getNama()
                    + " (ID: " + daftarNasabah[i].getIdNasabah() + ")");
        }
    }

    static void tampilkanDaftarRekening() { // Menampilkan daftar rekening yang terdaftar di sistem
        System.out.println("Daftar Rekening:");
        for (int i = 0; i < jumlahRekening; i++) {
            System.out.println("  " + (i + 1) + ". " + semuaRekening[i].getNomorRekening()
                    + " - " + semuaRekening[i].getPemilik()
                    + " (" + semuaRekening[i].getClass().getSimpleName() + ")"
                    + " Saldo: Rp" + semuaRekening[i].getSaldo());
        }
    }

    static int bacaInt(String prompt) { // Membaca input integer dengan penanganan kesalahan
        System.out.print(prompt);
        try { return Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { 
            return -1; 
        }
    }

    static double bacaDouble() { // Membaca input double dengan penanganan kesalahan
        try { return Double.parseDouble(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { 
            return 0; 
        }
    }

    static double bacaJumlah(String prompt) { // Membaca input jumlah uang dengan penanganan kesalahan
        System.out.print(prompt);
        return bacaDouble();
    }
}