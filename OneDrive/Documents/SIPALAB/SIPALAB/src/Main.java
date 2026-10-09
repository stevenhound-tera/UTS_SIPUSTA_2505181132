import eksepsi.*;
import java.time.LocalDate;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;
import koleksi.Keranjang;
import layanan.*;
import model.*;
import pembanding.UrutNama;
import pembanding.UrutStatusLaluNama;
import transaksi.DetailPeminjaman;
import transaksi.Peminjaman;

public class Main {
    public static void main(String[] args) {
        Laptop lap = new Laptop("LP-002", "Lenovo ThinkPad", 2023, 16, true,
                                 "SN-LT-2023-001", "Lab Jaringan");
        
        Proyektor pro = new Proyektor("PJ-003", "Epson EB-X51", 2022, 3300, 1200,
                                       "SN-PJ-2022-007", "Ruang Rapat A");
        
        AlatUkur ukur = new AlatUkur("AU-004", "Multimeter Fluke", 2020,
                                      "volt", LocalDate.of(2024, 3, 10));
        
        Komponen kom1 = new Komponen("KP-005", "Resistor 10K", 2023, 50, 10);
        
        Komponen kom2 = new Komponen("KP-006", "Kapasitor 100uF", 2023, 5, 10);

        System.out.println(lap.deskripsi() + " | siap: " + lap.siapDipinjam());
        System.out.println(lap.ringkasanLacak());
        System.out.println(pro.deskripsi() + " | siap: " + pro.siapDipinjam());
        System.out.println(pro.ringkasanLacak());
        System.out.println(ukur.deskripsi() + " | siap: " + ukur.siapDipinjam());
        System.out.println(ukur.statusKalibrasi());

        InventarisLab inventaris = new InventarisLab();
        inventaris.tambah(lap);
        inventaris.tambah(pro);
        inventaris.tambah(ukur);
        inventaris.tambah(kom1);
        inventaris.tambah(kom2);

        System.out.println();
        System.out.println("=== Status Inventaris ===");
        inventaris.cetakStatus();

        System.out.println();
        System.out.println("=== Jadwal Kalibrasi ===");
        inventaris.cetakJadwalKalibrasi();

        System.out.println();
        System.out.println("=== Job Sheet 4: Relasi Peminjaman ===");

        Mahasiswa mhs = new Mahasiswa("2205062001", "Rani Simatupang", "TRPL");
        Petugas ptg = new Petugas("198701012015041002", "Bapak Sutrisno");

        Laboratorium lab = new Laboratorium("LAB-RPL", "Laboratorium Rekayasa PL");
        lab.tambahAlat(lap);
        lab.tambahAlat(pro);
        System.out.println("Jumlah alat di lab: " + lab.jumlahAlat());

        Peminjaman pinjam = new Peminjaman("PJM-0001", mhs, ptg);
        pinjam.tambahDetail(lap, 1);
        pinjam.tambahDetail(pro, 2);
        System.out.println("Total item dipinjam: " + pinjam.totalItem());

        for (DetailPeminjaman d : pinjam.getDetail()) {
            System.out.println("  " + d.baris());
        }

        // Tugas Mandiri F.1 dan F.2
        pinjam.kembalikan();
        System.out.println("Hari terlambat: " + pinjam.hitungHariTerlambat());

        jobSheet5();
        jobSheet6();

    }

    private static void jobSheet5() {
        System.out.println();
        System.out.println("=== Keranjang generic ===");
        Keranjang<Alat> keranjang = new Keranjang<>(2);
        keranjang.tambah(new Laptop("LP-009", "Dell Latitude", 2023, 16, true,
                                    "SN-LP-2023-009", "Lab RPL"));
        
        for (Alat a : keranjang) {
            System.out.println("  " + a.deskripsi());
        }
        System.out.println("  Sisa ruang: " + keranjang.sisaRuang());

        InventarisLab inv = DataContoh.buatInventaris();

        System.out.println();
        System.out.println("=== Comparator ===");
        System.out.println("-- urutan asli --");
        cetakDaftar(inv.semuaAlat());
        System.out.println("-- UrutNama --");
        cetakDaftar(inv.urut(new UrutNama()));
        System.out.println("-- UrutStatusLaluNama (bawaan, seperti Gambar 1) --");
        cetakDaftar(inv.urutBawaan());
        System.out.println("-- urutan asli setelah diurut (harus tetap sama) --");
        cetakDaftar(inv.semuaAlat());

        System.out.println();
        System.out.println("=== Menyaring koleksi ===");
        try {
            DataContoh.buatInventaris().hapusYangTidakSiapSalah();
        } catch (ConcurrentModificationException e) {
            System.out.println("  Galat yang diharapkan: " + e);
        }
        System.out.println("  Sebelum hapus: " + inv.semuaAlat().size() + " alat");
        inv.hapusYangTidakSiap();
        System.out.println("  Sesudah removeIf: " + inv.semuaAlat().size() + " alat");

        System.out.println("  Cari 'Kabel':");
        cetakDaftar(DataContoh.buatInventaris().cari("Kabel"));
    }

    private static void cetakDaftar(List<Alat> daftar) {
        for (Alat a : daftar) {
            System.out.println("  " + a.laporanRingkas());
        }
    }

    private static void jobSheet6() {
        System.out.println();
        System.out.println("=== Eksepsi aturan bisnis ===");
        InventarisLab inv = DataContoh.buatInventaris();
        LayananPeminjaman layanan = new LayananPeminjaman();
        Mahasiswa mhs = new Mahasiswa("2205062001", "Rani Simatupang", "TRPL");
        Petugas ptg = new Petugas("198701012015041002", "Bapak Sutrisno");

        cobaPinjam(layanan, mhs, ptg, inv.cariKode("LP-002"));
        cobaPinjam(layanan, mhs, ptg, inv.cariKode("KM-002"));
        cobaPinjam(layanan, mhs, ptg, inv.cariKode("LP-001"));
        cobaPinjam(layanan, mhs, ptg, inv.cariKode("LP-001"));

        System.out.println();
        System.out.println("=== Validasi masukan ===");
        ValidatorAlat validator = new ValidatorAlat();
        Alat tahunSalah = new Laptop("LP-099", "Laptop Uji", 1980, 8, true,
                                     "SN-X", "Lab RPL");
        try {
            validator.periksa(tahunSalah);
            System.out.println("  Data valid.");
        } catch (DataTidakValidException e) {
            System.out.println("  Kolom [" + e.getNamaKolom() + "]: " + e.getMessage());
        }
    }

    private static void cobaPinjam(LayananPeminjaman layanan, Mahasiswa mhs,
                                   Petugas ptg, Alat alat) {
        try {
            Peminjaman p = layanan.pinjam(mhs, ptg, alat, 1);
            System.out.println("  BERHASIL " + p.getNomorPeminjaman());
        } catch (SipalabException e) {
            System.out.println("  DITOLAK " + e.getMessage());
        }
    }

    public static void ujiRapuh() {
        Scanner masukan = new Scanner(System.in);
        System.out.print("Masukkan tahun perolehan: ");
        int tahun = Integer.parseInt(masukan.nextLine());
        System.out.println("Tahun tercatat: " + tahun);
    }

    public static void ujiTangguh() {
        Scanner masukan = new Scanner(System.in);
        System.out.print("Masukkan tahun perolehan: ");
        try {
            int tahun = Integer.parseInt(masukan.nextLine());
            System.out.println("Tahun tercatat: " + tahun);
        } catch (NumberFormatException e) {
            System.out.println("Tahun harus berupa angka, contoh 2024.");
        }
    }
}
