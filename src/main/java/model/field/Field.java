package model.field;

import java.util.Objects;

/**
 * Created by lucz on 28.06.16.
 */
public class Field extends GameField{
    private Sign sign;

    public Field(Integer index, Sign sign) {
        this.index = index;
        this.sign = sign;
    }

    public Integer showIndex() {
        return index;
    }

    public Sign showSign() {
        return sign;
    }

    @Override
    public int hashCode(){
        return Objects.hash(index, sign);
    }

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(Objects.isNull(object)) return false;
        if(getClass() != object.getClass()) return false;
        Field other = (Field) object;
        return this.index.equals(other.index) && this.sign.equals(other.sign);
    }
}
