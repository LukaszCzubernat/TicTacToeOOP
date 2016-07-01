package controler.arbiter.impl;

import model.board.impl.Board;
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
public class ArbiterDecisionEngine {

    private Set<Sequence> possibleWinningSequences;
    private Sequence winnerSequence;
    private Sign winnerSign;

    public ArbiterDecisionEngine() {
        this.possibleWinningSequences = SequenceInitializer.getAllWinningSequences();
    }

    public Boolean isBoardContainsWinningSequence(Board board) {
//        Iterator<Sequence> sequenceIterator = possibleWinningSequences.iterator();
//        while (sequenceIterator.hasNext()) {
//            if (isWinningSequence(board.getValuesForSequence(sequenceIterator.next()))){
//                return Boolean.TRUE;
//            }
//        }
        return Boolean.FALSE;
    }

    public void updateWinningSequences(Board board) {
//        Iterator<Sequence> sequenceIterator = possibleWinningSequences.iterator();
//        while (sequenceIterator.hasNext()) {
//            updatePossibleWinningSequences(board.getValuesForSequence(sequenceIterator.next()), sequenceIterator);
//        }
    }

    private boolean isWinningSequence(List<Sign> signs) {
        if (signs.size() == 3 && !signs.contains(Sign.X)) {
            return signs.stream().filter(sign -> Objects.nonNull(sign)).filter(sign -> sign.equals(Sign.O)).count() == 3;
        }
        if (signs.size() == 3 && !signs.contains(Sign.O)) {
            return signs.stream().filter(sign -> Objects.nonNull(sign)).filter(sign -> sign.equals(Sign.X)).count() == 3;
        }
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
