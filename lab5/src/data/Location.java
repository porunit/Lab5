package data;

public class Location {
    private float x;
    private Integer y; //Поле не может быть null
    private int z;

    public Location(){}
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

    public void setX(float x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
