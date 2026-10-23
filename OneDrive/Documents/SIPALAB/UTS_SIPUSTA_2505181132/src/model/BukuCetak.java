package model;

public class BukuCetak extends Koleksi implements Terarsip {
    private int jumlahHalaman;
    private String nomorRak;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit, int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    public boolean isSedangDiperbaiki() {
        return sedangDiperbaiki;
    }

    @Override
    public boolean isLayakPinjam() {
        // Layak apabila tidak sedang diperbaiki
        return !sedangDiperbaiki;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return "Lantai 1 - Gedung Utama Perpustakaan";
    }

    @Override
    public String deskripsi() {
        String statusPerbaikan = sedangDiperbaiki ? "Sedang diperbaiki" : "Tidak sedang diperbaiki";
        return super.deskripsi() + " | Tipe: Buku Cetak | Halaman: " + jumlahHalaman + " | " + ringkasanArsip() + " | Status: " + statusPerbaikan;
    }
}