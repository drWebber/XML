package knife.domain;

public class Blade {
    private int widht;
    private int length;
    private BladeMaterial material;
    private boolean fuller;

    public Blade() { }

    public Blade(final int widht, final int length,
            final BladeMaterial material, final boolean fuller) {
        this.widht = widht;
        this.length = length;
        this.material = material;
        this.fuller = fuller;
    }

    public int getWidht() {
        return widht;
    }
    public void setWidht(final int widht) {
        this.widht = widht;
    }
    public int getLength() {
        return length;
    }
    public void setLength(final int length) {
        this.length = length;
    }
    public BladeMaterial getMaterial() {
        return material;
    }
    public void setMaterial(final BladeMaterial material) {
        this.material = material;
    }
    public boolean hasFuller() {
        return fuller;
    }
    public void setFuller(final boolean fuller) {
        this.fuller = fuller;
    }

    @Override
    public String toString() {
        return "Blade [widht=" + widht + ", length=" + length + ", "
                + "material=" + material + ", fuller=" + fuller + "]";
    }
}
