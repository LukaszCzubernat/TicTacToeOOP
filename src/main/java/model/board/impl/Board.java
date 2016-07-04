package model.board.impl;

import model.board.GameBoard;
import model.field.impl.Field;
import model.field.GameField;
import model.field.impl.Sign;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by Hawk on 28.06.16.
 */
public class Board implements GameBoard {
    private GameField[] fields;

    public Board(GameField[] fields) {
        this.fields = fields;
    }

    @Override
    public void fillFieldOnBoard(GameField field) {
        fields[field.showIndex()] = field;
    }

    @Override
    public GameField getFieldForIndex(Integer index){
        return fields[index];
    }

    @Override
    public Sign getSignOfFieldForIndex(Integer index){
        return Optional.ofNullable(fields[index]).map(GameField::showSign).orElse(null);
    }

    @Override
    public String display() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= fields.length; i++) {
            GameField field = fields[i - 1];
            if (Objects.isNull(field))
                builder.append("_ | ");
            else
                builder.append(field.showSign().toString().concat(" | "));
            if (i % 3 == 0)
                builder.append("\n");
        }
        return builder.toString();
    }
}
