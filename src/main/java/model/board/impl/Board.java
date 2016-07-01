package model.board.impl;

import model.board.GameBoard;
import model.field.Field;
import model.field.GameField;
import model.field.Sign;
import util.Sequence;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Hawk on 28.06.16.
 */
public class Board implements GameBoard {
    private Field[] fields;

    public Board(Field[] fields) {
        this.fields = fields;
    }

    @Override
    public Boolean placeSign(GameField field) {
        if (Objects.isNull(fields[field.showIndex()])) {
            fields[field.showIndex()] = (Field) field;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public List<Sign> getValuesForSequence(Sequence sequence) {
        return sequence.showSequenceValues().stream().filter(index -> Objects.nonNull(fields[index])).
                map(index -> fields[index].showSign()).collect(Collectors.toList());
    }

    @Override
    public String display() {
        return null;
    }
}
