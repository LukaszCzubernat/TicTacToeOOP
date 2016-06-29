package model.field;

/**
 * Created by lucz on 28.06.16.
 */
public class Field {
    private Integer index;
    private Sign sign;

    public Field(Integer index, Sign sign) {
        this.index = index;
        this.sign = sign;
    }

    public Integer showIndex() {
        return index;
    }
}
