package model;

public class BerkasDigital extends Koleksi {
    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kodeKoleksi, String judul, int tahunTerbit, double ukuranMB, String tautanUnduh) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean isLayakPinjam() {
        // Berkas Digital selalu layak dipinjam
        return true;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Tipe: Berkas Digital | Ukuran: " + ukuranMB + " MB | Tautan: " + tautanUnduh;
    }
}