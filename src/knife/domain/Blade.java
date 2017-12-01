package knife.domain;

public class Blade {
    private int widht;
    private int length;
    BladeMaterial material;
    boolean fuller;
    
    public Blade() { }
    
    public Blade(int widht, int length, BladeMaterial material, 
            boolean fuller) {
        this.widht = widht;
        this.length = length;
        this.material = material;
        this.fuller = fuller;
    }

    public int getWidht() {
        return widht;
    }
    public void setWidht(int widht) {
        this.widht = widht;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public BladeMaterial getMaterial() {
        return material;
    }
    public void setMaterial(BladeMaterial material) {
        this.material = material;
    }
    public boolean hasFuller() {
        return fuller;
    }
    public void setFuller(boolean fuller) {
        this.fuller = fuller;
    }
}
