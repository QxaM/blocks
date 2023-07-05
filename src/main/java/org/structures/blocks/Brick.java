package org.structures.blocks;

public class Brick implements Block {

    private final String color;
    private final String material;

    public Brick(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public int count() {
        return 1;
    }
}
