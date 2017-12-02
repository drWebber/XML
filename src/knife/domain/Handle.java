package knife.domain;

public class Handle {
    private HandleMaterial material;
    private String type;
    
    public Handle() { }

    public HandleMaterial getMaterial() {
        return material;
    }

    public void setMaterial(HandleMaterial material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Handle [material=" + material + ", type=" + type + "]";
    }
}
