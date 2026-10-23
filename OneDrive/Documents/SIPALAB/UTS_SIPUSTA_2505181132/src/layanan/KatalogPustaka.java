package layanan;

import model.Koleksi;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KatalogPustaka {
    private List<Koleksi> daftarKoleksi;
    // Simulasi status pinjam internal berdasarkan kode koleksi
    private List<String> koleksiDipinjam;

    public KatalogPustaka() {
        this.daftarKoleksi = new ArrayList<>();
        this.koleksiDipinjam = new ArrayList<>();
    }

    public void tambahKoleksi(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return daftarKoleksi;
    }

    public void setKoleksiDipinjam(String kodeKoleksi) {
        this.koleksiDipinjam.add(kodeKoleksi);
    }

    // Method cetakStatus polimorfik tanpa menggunakan 'instanceof' (Soal 3)
    public void cetakStatus() {
        System.out.println("==================================================================================");
        System.out.println("                        STATUS KATALOG KOLEKSI PERPUSTAKAAN                       ");
        System.out.println("==================================================================================");
        for (Koleksi k : daftarKoleksi) {
            // Memanggil method deskripsi() dan isLayakPinjam() secara polimorfik murni
            String kelayakan = k.isLayakPinjam() ? "[LAYAK PINJAM]" : "[TIDAK LAYAK PINJAM]";
            System.out.println("- " + kelayakan + " " + k.deskripsi());
        }
        System.out.println("==================================================================================\n");
    }

    // Method urut yang menerima Comparator dari luar (Soal 4)
    public void urut(Comparator<Koleksi> comparator) {
        Collections.sort(daftarKoleksi, comparator);
    }

    // Method pinjam yang melempar eksepsi sesuai keadaan (Soal 5)
    public void pinjam(String kodeKoleksi) throws KoleksiSedangDipinjamException, KoleksiTidakLayakException {
        Koleksi target = null;
        for (Koleksi k : daftarKoleksi) {
            if (k.getKodeKoleksi().equalsIgnoreCase(kodeKoleksi)) {
                target = k;
                break;
            }
        }

        if (target == null) {
            System.out.println("Koleksi dengan kode " + kodeKoleksi + " tidak ditemukan.");
            return;
        }

        // Cek apakah sedang dipinjam
        if (koleksiDipinjam.contains(target.getKodeKoleksi())) {
            throw new KoleksiSedangDipinjamException(target.getJudul());
        }

        // Cek apakah layak dipinjam
        if (!target.isLayakPinjam()) {
            throw new KoleksiTidakLayakException(target.getJudul());
        }

        // Jika lolos semua pemeriksaan
        koleksiDipinjam.add(target.getKodeKoleksi());
        System.out.println("SUKSES: Peminjaman koleksi \"" + target.getJudul() + "\" berhasil dilakukan.");
    }
}