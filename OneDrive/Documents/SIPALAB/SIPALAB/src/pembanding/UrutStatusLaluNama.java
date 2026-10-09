package pembanding;

import java.util.Comparator;
import model.Alat;

public class UrutStatusLaluNama implements Comparator<Alat> {
    @Override
    public int compare(Alat a, Alat b) {
        
        int bandingStatus = Boolean.compare(b.siapDipinjam(), a.siapDipinjam());
        if (bandingStatus != 0) {
            return bandingStatus;
        }
        return a.getNama().compareToIgnoreCase(b.getNama());
    }
}
