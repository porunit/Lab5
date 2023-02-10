package data;

public class Location {
    private float x;
    private Integer y; //Поле не может быть null
    private int z;

    public Location(float x, Integer y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
