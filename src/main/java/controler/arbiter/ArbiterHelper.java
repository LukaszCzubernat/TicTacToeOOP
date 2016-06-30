package controler.arbiter;

import model.board.Board;
import model.field.Sign;
import util.Sequence;
import util.SequenceInitializer;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by lucz on 30.06.16.
 */
public class ArbiterHelper {

    private Set<Sequence> possibleWinningSequences;

    public ArbiterHelper() {
        this.possibleWinningSequences = SequenceInitializer.getAllWinningSequences();
    }

    public Boolean isBoardContainsWinningSequence(Board board) {
        Iterator<Sequence> sequenceIterator = possibleWinningSequences.iterator();
        while (sequenceIterator.hasNext()) {
            List<Sign> signs = board.getValuesForSequence(sequenceIterator.next());
            if (isWinningSequence(signs))
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void updateWinningSequences(Board board) {
        Iterator<Sequence> sequenceIterator = possibleWinningSequences.iterator();
        while (sequenceIterator.hasNext()) {
            List<Sign> signs = board.getValuesForSequence(sequenceIterator.next());
            updatePossibleWinningSequences(signs, sequenceIterator);
        }
    }

    private boolean isWinningSequence(List<Sign> signs) {
        if (signs.size() == 3 && !signs.contains(Sign.X))
            return signs.stream().filter(sign -> Objects.nonNull(sign)).filter(sign -> sign.equals(Sign.O)).count() == 3;
        if (signs.size() == 3 && !signs.contains(Sign.O))
            return signs.stream().filter(sign -> Objects.nonNull(sign)).filter(sign -> sign.equals(Sign.X)).count() == 3;
        return false;
    }

    private void updatePossibleWinningSequences(List<Sign> signs, Iterator<Sequence> sequenceIterator) {
        if (signs.contains(Sign.O) && signs.contains(Sign.X))
            sequenceIterator.remove();
    }

    public Set<Sequence> getPossibleWinningSequences() {
        return possibleWinningSequences;
    }
}
