package model;

public enum StatusAlat {
    TERSEDIA("Tersedia"),
    DIPINJAM("Dipinjam");

    private final String label;

    StatusAlat(String label) {
        this.label = label;
    }

    public boolean sedangDiluar() {
        return this == DIPINJAM;
    }

    @Override
    public String toString() {
        return label;
    }
}
