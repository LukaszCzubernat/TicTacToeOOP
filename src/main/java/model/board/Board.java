package model.board;

import model.field.Field;

import java.util.Objects;

/**
 * Created by Hawk on 28.06.16.
 */
public class Board {
    private Field[] fields;

    public Board(Field[] fields) {
        this.fields = fields;
    }

    public Boolean placeSign(Field field) {
        if(Objects.isNull(fields[field.showIndex()])){
            fields[field.showIndex()] = field;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
