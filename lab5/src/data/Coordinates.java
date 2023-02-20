package data;

import exceptions.WrongDataTypeException;

public class Coordinates {
    private Float x; //Значение поля должно быть больше -156, Поле не может быть null
    private Long y; //Поле не может быть null

    public Coordinates(){}
    public Coordinates(Float x, Long y){
        setX(x);
        this.y = y;
    }


    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        float minX = -156;
        if (x == null) throw new WrongDataTypeException();
        else if (x<minX) this.x = minX+1;
        else this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        if (y!=null) this.y = y;
        else throw new WrongDataTypeException();
    }
}
