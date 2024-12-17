public class AlgoFood {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Menu menu = new Menu();
        AntrianPesanan antrianPesanan = new AntrianPesanan();
        RiwayatPesanan riwayatPesanan = new RiwayatPesanan();
        PencariRute pencariRute = new PencariRute();

        menu.tambahMenu("Burger", 20000);
        menu.tambahMenu("Pizza", 50000);
        menu.tambahMenu("Sushi", 30000);

        pencariRute.tambahLokasi("Pengguna");
        pencariRute.tambahLokasi("AlgoFood");
        pencariRute.tambahRute("Pengguna", "AlgoFood", 10);

        while (true) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tampilkan Menu");
            System.out.println("2. Pesan");
            System.out.println("3. Lihat Antrian Pesanan");
            System.out.println("4. Lihat Riwayat Pesanan");
            System.out.println("5. Cari Rute Terpendek ke AlgoFood");
            System.out.println("6. Keluar");

            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    menu.tampilkanMenu();
                    break;
                case 2:
                    System.out.print("Masukkan nama menu: ");
                    String namaPesanan = scanner.nextLine();
                    NodeMenu item = menu.cariMenu(namaPesanan);
                    if (item != null) {
                        antrianPesanan.tambahPesanan(item);
                        riwayatPesanan.tambahPesanan(item);
                        System.out.println("Pesanan berhasil: " + item.nama);
                    } else {
                        System.out.println("Menu tidak ditemukan.");
                    }
                    break;
                case 3:
                    antrianPesanan.tampilkanAntrian();
                    break;
                case 4:
                    riwayatPesanan.tampilkanRiwayat();
                    break;
                case 5:
                    pencariRute.temukanRuteTerpendek("Pengguna", "AlgoFood");
                    break;
                case 6:
                    System.out.println("Terima Kasih Telah Menggunakan AlgoFood!!");
                    return;
                default:
                    System.out.println("Pilihan Tidak Valid");
            }
        }
    }
}