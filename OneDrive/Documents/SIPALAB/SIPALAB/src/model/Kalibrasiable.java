package model;

import java.time.LocalDate;

public interface Kalibrasiable {

    boolean perluKalibrasi();

    LocalDate jatuhTempoKalibrasi();

    default String statusKalibrasi() {
        if (perluKalibrasi()) {
            return "PERLU KALIBRASI sejak " + jatuhTempoKalibrasi();
        }
        return "LAYAK PAKAI sampai " + jatuhTempoKalibrasi();
    }
}
