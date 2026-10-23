package eksepsi;

public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String judul) {
        super("Maaf, koleksi \"" + judul + "\" tidak memenuhi aturan syarat layak pinjam.");
    }
}