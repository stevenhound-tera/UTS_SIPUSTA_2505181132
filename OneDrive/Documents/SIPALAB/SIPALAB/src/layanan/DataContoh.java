package layanan;

import java.time.LocalDate;
import model.*;

public class DataContoh {

    public static InventarisLab buatInventaris() {
        InventarisLab inv = new InventarisLab();
        LocalDate baruDikalibrasi = LocalDate.now().minusMonths(2);

        inv.tambah(new Proyektor("PJ-002", "BenQ MS550", 2023, 3600, 800,
                "SN-PJ-2023-002", "Lab Multimedia"));
        inv.tambah(new Laptop("LP-003", "HP ProBook 450", 2022, 8, true,
                "SN-LP-2022-003", "Lab Jaringan"));
        inv.tambah(new Komponen("KM-001", "Kabel HDMI 2 meter", 2021, 20, 5));
        
        inv.tambah(new Komponen("KM-003", "Kabel LAN Cat6 3 meter", 2023, 30, 10));
        
        inv.tambah(new Laptop("LP-001", "Lenovo ThinkPad T14", 2023, 16, true,
                "SN-LP-2023-001", "Lab RPL"));
        
        inv.tambah(new AlatUkur("AU-002", "Osiloskop Rigol DS1054Z", 2021,
                "MHz", baruDikalibrasi));
        
        inv.tambah(new Komponen("KM-002", "Adaptor USB-C ke HDMI", 2022, 3, 5));
        
        inv.tambah(new Laptop("LP-002", "Asus VivoBook 14", 2024, 8, false,             
                "SN-LP-2024-002", "Lab RPL"));
        
        inv.tambah(new Proyektor("PJ-001", "Epson EB-X51", 2022, 3300, 2500,
                "SN-PJ-2022-001", "Ruang Rapat A"));
        
        inv.tambah(new AlatUkur("AU-001", "Multimeter Fluke 117", 2020, "volt",
                LocalDate.of(2024, 3, 10)));
        
        return inv;
    }
}
