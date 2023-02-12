package data;

public class Coordinates {
    private Float x; //Значение поля должно быть больше -156, Поле не может быть null
    private Long y; //Поле не может быть null

    public Coordinates(Float x, Long y){
        if(x>-155) this.x = x;
        else this.x = Float.valueOf(-155);
        this.y = y;
    }


    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }
}
