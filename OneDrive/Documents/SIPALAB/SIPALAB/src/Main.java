import java.time.LocalDate;
import layanan.InventarisLab;
import model.*;
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

        pinjam.kembalikan();
        System.out.println("Hari terlambat: " + pinjam.hitungHariTerlambat());
    }
}
