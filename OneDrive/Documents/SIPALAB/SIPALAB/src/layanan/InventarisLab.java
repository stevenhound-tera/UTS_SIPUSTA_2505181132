    package layanan;

import java.util.ArrayList;
import java.util.List;
import model.Alat;
import model.Kalibrasiable;

public class InventarisLab {

    private final List<Alat> daftarAlat = new ArrayList<>();

    public void tambah(Alat alat) {
        daftarAlat.add(alat);
    }

    public List<Alat> semuaAlat() {
        return daftarAlat;
    }

    public void cetakStatus() {
        for (Alat a : daftarAlat) {
            System.out.println(a.laporanRingkas());
        }
    }

    public void cetakJadwalKalibrasi() {
        for (Alat a : daftarAlat) {
            if (a instanceof Kalibrasiable k) {
                System.out.println(a.getNama() + " -> " + k.statusKalibrasi());
            }
        }
    }
}
