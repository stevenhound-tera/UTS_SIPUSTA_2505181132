package model;

public class Laptop extends Alat implements Terlacak {

    private int ramGB;
    private boolean chargerLengkap;
    private String nomorSeri;
    private String lokasiTerakhir;

    public Laptop(String kodeAlat, String nama, int tahunPerolehan,
                  int ramGB, boolean chargerLengkap,
                  String nomorSeri, String lokasiTerakhir) {
        super(kodeAlat, nama, tahunPerolehan);
        this.ramGB = ramGB;
        this.chargerLengkap = chargerLengkap;
        this.nomorSeri = nomorSeri;
        this.lokasiTerakhir = lokasiTerakhir;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " RAM " + ramGB + " GB";
    }

    @Override
    public boolean siapDipinjam() {
        return chargerLengkap;
    }

    @Override
    public String nomorSeri() {
        return nomorSeri;
    }

    @Override
    public String lokasiTerakhir() {
        return lokasiTerakhir;
    }
}
