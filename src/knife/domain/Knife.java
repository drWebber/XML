package knife.domain;

public class Knife {
    private int id;
    private String type;
    private Handy handy;
    private String origin;
    private Visual visual = new Visual();
    private boolean value;

    public Knife() { }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Handy getHandy() {
        return handy;
    }

    public void setHandy(final Handy handy) {
        this.handy = handy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public Visual getVisual() {
        return visual;
    }

    public void setVisual(final Visual visual) {
        this.visual = visual;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(final boolean value) {
        this.value = value;
    }

    @Override
    public final String toString() {
        return "Knife [id=" + id + ", type=" + type + ", handy=" + handy + ", "
                + "origin=" + origin + ", visual=" + visual
                + ", value=" + value + "]";
    }
}
