package challenge;

public enum BodyType {

    STAR(1), PLANET(2), DWARF_PLANET(3), MOON(4), COMET(5), ASTEROID(6);

    int type;

    BodyType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
