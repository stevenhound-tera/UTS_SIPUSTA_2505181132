package model;

import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    @Override
    public int compare(Koleksi k1, Koleksi k2) {
        // Layak pinjam (true) didahulukan dibanding yang tidak layak (false)
        Boolean layak1 = k1.isLayakPinjam();
        Boolean layak2 = k2.isLayakPinjam();
        
        int hasilBandingLayak = layak2.compareTo(layak1); // true (bernilai lebih tinggi/didahulukan)
        if (hasilBandingLayak != 0) {
            return hasilBandingLayak;
        }
        // Jika status layak sama, diurutkan berdasarkan judul secara alfabetis
        return k1.getJudul().compareTo(k2.getJudul());
    }
}