package model;

public class Majalah extends Koleksi implements Terarsip {
    private int edisi;
    private String bulanTerbit;
    private String nomorRak;
    private boolean edisiTerbaru;

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit, int edisi, String bulanTerbit, String nomorRak, boolean edisiTerbaru) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.nomorRak = nomorRak;
        this.edisiTerbaru = edisiTerbaru;
    }

    public boolean isEdisiTerbaru() {
        return edisiTerbaru;
    }

    @Override
    public boolean isLayakPinjam() {
        // Layak apabila bukan edisi terbaru
        return !edisiTerbaru;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return "Lantai 2 - Zona Periodikal & Majalah";
    }

    @Override
    public String deskripsi() {
        String statusEdisi = edisiTerbaru ? "Edisi Terbaru" : "Bukan Edisi Terbaru";
        return super.deskripsi() + " | Tipe: Majalah | Edisi: " + edisi + " (" + bulanTerbit + ") | " + ringkasanArsip() + " | Status: " + statusEdisi;
    }
}