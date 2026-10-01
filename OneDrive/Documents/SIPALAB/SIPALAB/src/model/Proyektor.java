package model;

public class Proyektor extends Alat implements Terlacak {

    private int lumen;
    private int jamPakaiLampu;
    private String nomorSeri;
    private String lokasiTerakhir;

    public Proyektor(String kodeAlat, String nama, int tahunPerolehan,
                      int lumen, int jamPakaiLampu,
                      String nomorSeri, String lokasiTerakhir) {
        super(kodeAlat, nama, tahunPerolehan);
        this.lumen = lumen;
        this.jamPakaiLampu = jamPakaiLampu;
        this.nomorSeri = nomorSeri;
        this.lokasiTerakhir = lokasiTerakhir;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " " + lumen + " lumen";
    }

    @Override
    public boolean siapDipinjam() {
        return jamPakaiLampu <= 2000;
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
