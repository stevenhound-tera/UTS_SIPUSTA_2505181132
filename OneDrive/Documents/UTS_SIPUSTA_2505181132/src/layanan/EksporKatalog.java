package layanan;


import model.Koleksi;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EksporKatalog {
    public static void tulisKeBerkas(List<Koleksi> daftarKoleksi, String namaFile) {
        // Aliran ditutup secara otomatis menggunakan try-with-resources (Soal 6)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            writer.write(String.format("%-10s | %-32s | %-6s | %-18s\n", "KODE", "JUDUL", "TAHUN", "STATUS KELAYAKAN"));
            writer.write("----------------------------------------------------------------------------------\n");
            
            for (Koleksi k : daftarKoleksi) {
                String status = k.isLayakPinjam() ? "Layak Pinjam" : "Tidak Layak Pinjam";
                writer.write(String.format("%-10s | %-32s | %-6d | %-18s\n", 
                        k.getKodeKoleksi(), 
                        k.getJudul(), 
                        k.getTahunTerbit(), 
                        status));
            }
            System.out.println("Berhasil mengekspor data katalog ke berkas: " + namaFile);
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menulis berkas: " + e.getMessage());
        }
    }
}