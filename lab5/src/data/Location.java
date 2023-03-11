package data;

import exceptions.WrongDataTypeException;

public class Location {
    private float x;
    private Integer y; //Поле не может быть null
    private int z;

    public Location() {
    }

    public Location(float x, Integer y, int z) {
        this.x = x;
        setY(y);
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        if (y != null) this.y = y;
        else throw new WrongDataTypeException();
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
