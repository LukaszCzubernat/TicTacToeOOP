package controler.arbiter.impl;

import controler.board.GameBoardController;
import model.field.impl.Sign;
import util.Sequence;
import util.impl.SequenceInitializer;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by lucz on 30.06.16.
 */
public class ArbiterDecisionEngine {

    private Set<Sequence> possibleWinningSequences;

    public ArbiterDecisionEngine() {
        this.possibleWinningSequences = SequenceInitializer.getAllWinningSequences();
    }

    public Boolean isBoardContainsWinningSequence(GameBoardController boardController) {
        // ME: REFACTOR MY FRIEND, WHERE ARE YOU? CAN YOU HELP ME? REFACTOR WHY ARE YOU SO SILENT?
        // REFACTOR: STFU! I DON'T KNOW HOW TO DO MY JOB
        Iterator<Sequence> sequenceIterator = possibleWinningSequences.iterator();
        while (sequenceIterator.hasNext()) {
            if (isWinningSequence(boardController.getValuesForSequence(sequenceIterator.next()))) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public void updateWinningSequences(GameBoardController boardController) {
        // ME: REFACTOR MY FRIEND, WHERE ARE YOU? CAN YOU HELP ME? REFACTOR WHY ARE YOU SO SILENT?
        // REFACTOR: STFU! I DON'T KNOW HOW TO DO MY JOB
        Iterator<Sequence> sequenceIterator = possibleWinningSequences.iterator();
        while (sequenceIterator.hasNext()) {
            updatePossibleWinningSequences(boardController.getValuesForSequence(sequenceIterator.next()), sequenceIterator);
        }
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
