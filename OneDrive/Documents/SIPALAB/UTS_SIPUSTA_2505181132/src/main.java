import model.*;
import layanan.*;
import eksepsi.*;

public class main {
    public static void main(String[] args) {
        KatalogPustaka katalog = new KatalogPustaka();

        katalog.tambahKoleksi(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "rak A-12", false));
        katalog.tambahKoleksi(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "rak B-04", true));
        katalog.tambahKoleksi(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", "rak C-01", true));
        katalog.tambahKoleksi(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", "rak C-02", false));
        katalog.tambahKoleksi(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15.0, "unduh.polmed.ac.id/bd001"));
        katalog.tambahKoleksi(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8.0, "unduh.polmed.ac.id/bd002"));

        katalog.setKoleksiDipinjam("BD-001");

        System.out.println("=== 1. MENAMPALKAN STATUS AWAL (POLIMORFISME) ===");
        katalog.cetakStatus();

        System.out.println("=== 2. PENGUJIAN PENGURUTAN MENGGUNAKAN COMPARATOR (Soal 4) ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println("=== 3. PENGUJIAN PEMINJAMAN DAN PENANGANAN EKSEPSI (Soal 5) ===");
        
        try {
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println("Pesan Eksepsi: " + e.getMessage());
        }

        // Pengujian 2: Meminjam koleksi yang tidak layak pinjam (Buku BK-002 sedang diperbaiki)
        try {
            katalog.pinjam("BK-002");
        } catch (PustakaException e) {
            System.out.println("Pesan Eksepsi: " + e.getMessage());
        }

        try {
            katalog.pinjam("BD-001");
        } catch (PustakaException e) {
            System.out.println("Pesan Eksepsi: " + e.getMessage());
        }

        System.out.println("\n=== 4. PENGUJIAN EKSPOR KATALOG KE BERKAS TEKS (Soal 6) ===");
        EksporKatalog.tulisKeBerkas(katalog.getDaftarKoleksi(), "katalog.txt");
    }
}