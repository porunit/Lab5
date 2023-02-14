package data;

import exceptions.WrongDataTypeException;

public class Coordinates {
    private Float x; //Значение поля должно быть больше -156, Поле не может быть null
    private Long y; //Поле не может быть null

    public Coordinates(){}
    public Coordinates(Float x, Long y){
        if(x>-155) this.x = Float.valueOf(x);
        else this.x = Float.valueOf(-155);
        this.y = y;
    }


    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        if (x!=null && x>-156)this.x = x;
        else throw new WrongDataTypeException();
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        if (y!=null) this.y = y;
        else throw new WrongDataTypeException();
    }
}
