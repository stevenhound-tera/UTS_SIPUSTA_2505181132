package model;

public abstract class Alat {

    protected String kodeAlat;
    protected String nama;
    protected int tahunPerolehan;

    public Alat(String kodeAlat, String nama, int tahunPerolehan) {
        this.kodeAlat = kodeAlat;
        this.nama = nama;
        this.tahunPerolehan = tahunPerolehan;
    }

    public String deskripsi() {
        return kodeAlat + " - " + nama + " (" + tahunPerolehan + ")";
    }

    public String laporanRingkas() {
        String status = siapDipinjam() ? "SIAP" : "TIDAK SIAP";
        return String.format("%-8s %-22s %s", kodeAlat, nama, status);
    }

    public abstract boolean siapDipinjam();

    public String getNama() {
        return nama;
    }
}
