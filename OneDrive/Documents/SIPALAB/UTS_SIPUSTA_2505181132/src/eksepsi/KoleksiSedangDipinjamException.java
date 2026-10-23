package eksepsi;

public class KoleksiSedangDipinjamException extends PustakaException {
    public KoleksiSedangDipinjamException(String judul) {
        super("Maaf, koleksi \"" + judul + "\" saat ini sedang dipinjam oleh pengguna lain.");
    }
}