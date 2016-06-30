package model.board;

import model.field.Field;
import model.field.Sign;
import util.Sequence;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Hawk on 28.06.16.
 */
public class Board {
    private Field[] fields;

    public Board(Field[] fields) {
        this.fields = fields;
    }

    public Boolean placeSign(Field field) {
        if (Objects.isNull(fields[field.showIndex()])) {
            fields[field.showIndex()] = field;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<Sign> getValuesForSequence(Sequence sequence) {
        return sequence.showSequenceValues().stream().filter(index -> Objects.nonNull(fields[index])).
                map(index -> fields[index].showSign()).collect(Collectors.toList());
    }
}
