package transaksi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Alat;
import model.Mahasiswa;
import model.Petugas;

public class Peminjaman {

    private final String nomorPeminjaman;
    private final LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;

    private final Mahasiswa peminjam;
    private final Petugas penyetuju;

    private final List<DetailPeminjaman> detail = new ArrayList<>();

    public Peminjaman(String nomorPeminjaman, Mahasiswa peminjam, Petugas penyetuju) {
        this.nomorPeminjaman = nomorPeminjaman;
        this.peminjam = peminjam;
        this.penyetuju = penyetuju;
        this.tanggalPinjam = LocalDate.now();
    }

    public void tambahDetail(Alat alat, int jumlah) {
        detail.add(new DetailPeminjaman(alat, jumlah));
    }

    public List<DetailPeminjaman> getDetail() {
        return Collections.unmodifiableList(detail);
    }

    public int totalItem() {
        int total = 0;
        for (DetailPeminjaman d : detail) {
            total += d.getJumlah();
        }
        return total;
    }

    public void kembalikan() {
        this.tanggalKembali = LocalDate.now();
    }

    public long hitungHariTerlambat() {
        if (tanggalKembali == null) {
            return 0;
        }
        long lamaPinjam = ChronoUnit.DAYS.between(tanggalPinjam, tanggalKembali);
        long selisih = lamaPinjam - 7;
        return selisih > 0 ? selisih : 0;
    }

    public String getNomorPeminjaman() {
        return nomorPeminjaman;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public Mahasiswa getPeminjam() {
        return peminjam;
    }

    public Petugas getPenyetuju() {
        return penyetuju;
    }
}
