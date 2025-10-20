package uts_pbo_ivan;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private static ArrayList<Pejabat> daftarPejabat = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("===========================================");
            System.out.println("      SISTEM PENDATAAN PEJABAT");
            System.out.println("===========================================");
            System.out.println("[1] Tambah Data Pejabat");
            System.out.println("[2] Lihat Data Pejabat");
            System.out.println("[3] Cari Pejabat Berdasarkan NIP");
            System.out.println("[4] Hapus Data Pejabat");
            System.out.println("[5] Hitung Tunjangan");
            System.out.println("[6] Keluar Program");
            System.out.println("-------------------------------------------");
            System.out.print("Pilih menu (1-6): ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    cariData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    hitungTunjangan();
                    break;
                case 6:
                    keluarProgram();
                    break;
                default:
                    System.out.println("\nPilihan tidak valid. Silakan pilih 1-6.\n");
            }

            if (pilihan != 6) {
                System.out.print("\nTekan ENTER untuk kembali ke menu utama...");
                input.nextLine();
                System.out.println();
            }

        } while (pilihan != 6);
    }

    // ================================
    // Fitur 1: Tambah Data Pejabat
    // ================================
    private static void tambahData() {
        System.out.println("\n>> Tambah Data Pejabat <<");
        System.out.print("Masukkan NIP         : ");
        String nip = input.nextLine();
        System.out.print("Masukkan Nama        : ");
        String nama = input.nextLine();
        System.out.print("Masukkan Jabatan     : ");
        String jabatan = input.nextLine();
        System.out.print("Masukkan Gaji Pokok  : ");
        double gaji = input.nextDouble();
        input.nextLine();

        Pejabat pj = new Pejabat(nama, nip, jabatan, gaji);
        daftarPejabat.add(pj);

        System.out.println("\nData pejabat berhasil ditambahkan!");
    }

    // ================================
    // Fitur 2: Lihat Data Pejabat
    // ================================
    private static void lihatData() {
        System.out.println("\n>> Daftar Data Pejabat <<");

        if (daftarPejabat.isEmpty()) {
            System.out.println("Belum ada data pejabat yang tersimpan.");
        } else {
            int i = 1;
            for (Pejabat p : daftarPejabat) {
                System.out.println("-------------------------------------------");
                System.out.println("Pejabat ke-" + i++);
                System.out.println(p.toString());
            }
            System.out.println("-------------------------------------------");
            System.out.println("Total Data: " + daftarPejabat.size());
        }
    }

    // ================================
    // Fitur 3: Cari Pejabat Berdasarkan NIP
    // ================================
    private static void cariData() {
        System.out.println("\n>> Cari Pejabat Berdasarkan NIP <<");
        System.out.print("Masukkan NIP yang ingin dicari: ");
        String nipCari = input.nextLine();

        boolean ditemukan = false;

        for (Pejabat p : daftarPejabat) {
            if (p.getNip().equalsIgnoreCase(nipCari)) {
                System.out.println("\nData Pejabat Ditemukan:");
                System.out.println("-------------------------------------------");
                System.out.println(p.toString());
                System.out.println("-------------------------------------------");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("\nData dengan NIP " + nipCari + " tidak ditemukan.");
        }
    }

    // ================================
    // Fitur 4: Hapus Data Pejabat
    // ================================
    private static void hapusData() {
        System.out.println("\n>> Hapus Data Pejabat <<");
        System.out.print("Masukkan NIP pejabat yang ingin dihapus: ");
        String nipHapus = input.nextLine();

        boolean ditemukan = false;

        for (Pejabat p : daftarPejabat) {
            if (p.getNip().equalsIgnoreCase(nipHapus)) {
                System.out.println("\nData ditemukan:");
                System.out.println(p.toString());
                System.out.print("\nApakah Anda yakin ingin menghapus data ini? (y/n): ");
                String konfirmasi = input.nextLine();

                if (konfirmasi.equalsIgnoreCase("y")) {
                    daftarPejabat.remove(p);
                    System.out.println("\nData pejabat berhasil dihapus!");
                } else {
                    System.out.println("\nData tidak jadi dihapus.");
                }

                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("\nData dengan NIP " + nipHapus + " tidak ditemukan.");
        }
    }

    // ================================
    // Fitur 5: Hitung Tunjangan Pejabat
    // ================================
    private static void hitungTunjangan() {
        System.out.println("\n>> Hitung Tunjangan Pejabat <<");
        System.out.print("Masukkan NIP pejabat: ");
        String nipCari = input.nextLine();

        boolean ditemukan = false;

        for (Pejabat p : daftarPejabat) {
            if (p.getNip().equalsIgnoreCase(nipCari)) {
                System.out.println("\nData Pejabat:");
                System.out.println("-------------------------------------------");
                System.out.println(p.toString());
                System.out.println("-------------------------------------------");
                System.out.println("Tunjangan : Rp " + p.getTunjangan());
                System.out.println("Total Gaji: Rp " + p.getTotalGaji());
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("\nData dengan NIP " + nipCari + " tidak ditemukan.");
        }
    }

    // ================================
    // Fitur 6: Keluar dari Program
    // ================================
    private static void keluarProgram() {
        System.out.println("\n======================================");
        System.out.println("Terima kasih telah menggunakan sistem.");
        System.out.println("Dibuat oleh: Ivan");
        System.out.println("======================================");

        // Tampilkan waktu keluar
        java.time.LocalDateTime waktuKeluar = java.time.LocalDateTime.now();
        java.time.format.DateTimeFormatter format =
            java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Waktu keluar: " + waktuKeluar.format(format));

        System.out.println("Program akan ditutup...");

        // Delay sedikit biar smooth
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSampai jumpa 👋");
        System.exit(0);
    }

}
