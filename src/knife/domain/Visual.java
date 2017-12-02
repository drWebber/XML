package knife.domain;

public class Visual {
    private Blade blade;
    private Handle handle;

    public Visual() { }
    
    public Visual(Blade blade, Handle handle) {
        this.blade = blade;
        this.handle = handle;
    }
    
    public Blade getBlade() {
        return blade;
    }

    public void setBlade(Blade blade) {
        this.blade = blade;
    }

    public Handle getHandle() {
        return handle;
    }

    public void setHandle(Handle handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return "Visual [blade=" + blade + ", handle=" + handle + "]";
    }
}
