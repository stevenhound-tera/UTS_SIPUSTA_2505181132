package layanan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Alat;
import model.Kalibrasiable;
import pembanding.UrutStatusLaluNama;

public class InventarisLab {

    private final List<Alat> daftarAlat = new ArrayList<>();

    public void tambah(Alat alat) {
        daftarAlat.add(alat);
    }

    public List<Alat> semuaAlat() {
        return daftarAlat;
    }

    // Polimorfik: tidak perlu tahu jenis alat, dynamic binding memilih
    // versi siapDipinjam() milik kelas turunan saat program berjalan.
    public void cetakStatus() {
        for (Alat a : daftarAlat) {
            System.out.println(a.laporanRingkas());
        }
    }

    // instanceof dipakai di sini hanya untuk menyaring kemampuan tambahan
    // (Kalibrasiable), yang tidak dimiliki semua alat.
    public void cetakJadwalKalibrasi() {
        for (Alat a : daftarAlat) {
            if (a instanceof Kalibrasiable k) {
                System.out.println(a.getNama() + " -> " + k.statusKalibrasi());
            }
        }
    }

    public List<Alat> urut(Comparator<Alat> pembanding) {
        List<Alat> salinan = new ArrayList<>(daftarAlat);
        salinan.sort(pembanding);
        return salinan;
    }

    public List<Alat> urutBawaan() {
        return urut(new UrutStatusLaluNama());
    }

    public void hapusYangTidakSiapSalah() {
        for (Alat a : daftarAlat) {
            if (!a.siapDipinjam()) {
                daftarAlat.remove(a); // menimbulkan galat
            }
        }
    }

    public void hapusYangTidakSiap() {
        daftarAlat.removeIf(a -> !a.siapDipinjam());
    }

    public List<Alat> cari(String kata) {
        String k = kata.toLowerCase();
        List<Alat> hasil = new ArrayList<>();
        for (Alat a : daftarAlat) {
            if (a.getNama().toLowerCase().contains(k)
                    || a.getKodeAlat().toLowerCase().contains(k)) {
                hasil.add(a);
            }
        }
        return hasil;
    }

    public Alat cariKode(String kode) {
        for (Alat a : daftarAlat) {
            if (a.getKodeAlat().equalsIgnoreCase(kode)) {
                return a;
            }
        }
        return null;
    }
}
