
import java.util.Scanner;

public class Prestasi {
    static String[][] prestasiList = new String[100][4]; 
    static int[] tahunPrestasi = new int[100];           
    static int jumlahPrestasi = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Tambah Prestasi Mahasiswa");
            System.out.println("2. Tampilkan Semua Prestasi");
            System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1 -> tambahkanPrestasi();
                case 2 -> menampilkanSemuaPrestasi();
                case 3 -> analisisPrestasi();
                case 4 -> System.out.println("Program selesai. Terima kasih!");
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);
    }


    static void tambahkanPrestasi() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        prestasiList[jumlahPrestasi][0] = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        prestasiList[jumlahPrestasi][1] = scanner.nextLine();
        System.out.print("Masukkan Jenis Prestasi: ");
        prestasiList[jumlahPrestasi][2] = scanner.nextLine();

        String tingkat;
        do {
            System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
            tingkat = scanner.nextLine();
            if (!tingkat.equalsIgnoreCase("Lokal") && !tingkat.equalsIgnoreCase("Nasional") && !tingkat.equalsIgnoreCase("Internasional")) {
                System.out.println("Input tidak valid. Masukkan kembali tingkat prestasi.");
            }
        } while (!tingkat.equalsIgnoreCase("Lokal") && !tingkat.equalsIgnoreCase("Nasional") && !tingkat.equalsIgnoreCase("Internasional"));
        prestasiList[jumlahPrestasi][3] = tingkat;

        int tahun;
        do {
            System.out.print("Masukkan Tahun Prestasi (2010 hingga saat ini): ");
            tahun = scanner.nextInt();
            scanner.nextLine(); 
            if (tahun < 2010 || tahun > 2024) {
                System.out.println("Input tidak valid. Masukkan kembali tahun prestasi.");
            }
        } while (tahun < 2010 || tahun > 2024);
        tahunPrestasi[jumlahPrestasi] = tahun;
        jumlahPrestasi++;
        System.out.println("Data prestasi ditambahkan.");
    }

    static void menampilkanSemuaPrestasi() {
        if (jumlahPrestasi == 0) {
            System.out.println("Belum ada data prestasi.");
        } else {
            System.out.println("\n= = = DAFTAR PRESTASI MAHASISWA = = =");
            for (int i = 0; i < jumlahPrestasi; i++) {
                System.out.printf("Nama: %s | NIM: %s | Jenis Prestasi: %s | Tingkat: %s | Tahun: %d%n",
                        prestasiList[i][0], prestasiList[i][1], prestasiList[i][2], prestasiList[i][3], tahunPrestasi[i]);
            }
        }
    }

    static void analisisPrestasi() {
        System.out.print("Masukkan Jenis Prestasi untuk Analisis: ");
        String Analisis = scanner.nextLine();
        boolean ditemukan = false;

        System.out.println("\n= = = ANALISIS PRESTASI = = =");
        for (int i = 0; i < jumlahPrestasi; i++) {
            if (prestasiList[i][2].equalsIgnoreCase(Analisis)) {
                System.out.printf("Nama: %s | NIM: %s | Tingkat: %s | Tahun: %d%n",
                        prestasiList[i][0], prestasiList[i][1], prestasiList[i][3], tahunPrestasi[i]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada data prestasi dengan jenis tersebut.");
        }
    }
}