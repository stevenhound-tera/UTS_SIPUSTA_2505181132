package eksepsi;

public class SipalabException extends Exception {

    public SipalabException(String pesan) {
        super(pesan);
    }

    // konstruktor kedua membawa penyebab aslinya
    public SipalabException(String pesan, Throwable penyebab) {
        super(pesan, penyebab);
    }
}
