package model;

public abstract class Alat {

    protected String kodeAlat;
    protected String nama;
    protected int tahunPerolehan;
    protected StatusAlat status = StatusAlat.TERSEDIA;

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

    public String getKodeAlat() {
        return kodeAlat;
    }

    public int getTahunPerolehan() {
        return tahunPerolehan;
    }

    public StatusAlat getStatus() {
        return status;
    }

    public void setStatus(StatusAlat status) {
        this.status = status;
    }
}
