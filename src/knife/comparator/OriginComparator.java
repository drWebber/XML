package knife.comparator;

import java.util.Comparator;

import knife.domain.Knife;

public class OriginComparator implements Comparator<Knife> {
    @Override
    public final int compare(final Knife k1, final Knife k2) {
        return k1.getOrigin().compareTo(k2.getOrigin());
    }
}
