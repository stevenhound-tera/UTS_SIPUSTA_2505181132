package model;

public class Petugas {

    private final String nip;
    private final String nama;

    public Petugas(String nip, String nama) {
        this.nip = nip;
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public String getNama() {
        return nama;
    }
}
