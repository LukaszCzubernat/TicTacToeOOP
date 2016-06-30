package util;

import model.field.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by lucz on 30.06.16.
 */
public class SequenceFinder {

    public SequenceFinder(Set<Sequence> allWinningSequences) {
    }

    public List<Sequence> findSequencesForField(Field field) {
        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(0, 1));
        sequences.add(new Sequence(0, 3));
        sequences.add(new Sequence(0, 4));
        return sequences;
    }
}
