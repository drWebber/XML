package knife.comparator;

import java.util.Comparator;

import knife.domain.Knife;

public class OriginComparator implements Comparator<Knife> {
    @Override
    public int compare(Knife k1, Knife k2) {
        return k1.getOrigin().compareTo(k2.getOrigin());
    }
}
