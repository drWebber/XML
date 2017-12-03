package knife.domain;

public class Visual {
    private Blade blade = new Blade();
    private Handle handle = new Handle();

    public Visual() { }
    
    public Visual(final Blade blade, final Handle handle) {
        this.blade = blade;
        this.handle = handle;
    }
    
    public Blade getBlade() {
        return blade;
    }

    public void setBlade(final Blade blade) {
        this.blade = blade;
    }

    public Handle getHandle() {
        return handle;
    }

    public void setHandle(final Handle handle) {
        this.handle = handle;
    }

    @Override
    public final String toString() {
        return "Visual [blade=" + blade + ", handle=" + handle + "]";
    }
}
