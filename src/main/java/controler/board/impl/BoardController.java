package controler.board.impl;

import controler.arbiter.GameArbiter;
import controler.arbiter.impl.Arbiter;
import controler.board.GameBoardController;
import model.board.GameBoard;
import model.field.GameField;
import model.field.impl.Sign;
import util.Sequence;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by lucz on 01.07.16.
 */
public class BoardController implements GameBoardController {

    private GameBoard board;
    private GameArbiter gameArbiter;

    public BoardController(GameBoard board) {
        this.board = board;
        this.gameArbiter = new Arbiter();
    }

    @Override
    public List<Sign> getValuesForSequence(Sequence sequence) {
        return sequence.showSequenceValues().stream().filter(index -> Objects.nonNull(board.getSignOfFieldForIndex(index))).
                map(index -> board.getSignOfFieldForIndex(index)).collect(Collectors.toList());
    }

    @Override
    public Boolean placeSignOnBoard(GameField field) {
        if (Objects.isNull(board.getFieldForIndex(field.showIndex()))) {
            board.fillFieldOnBoard(field);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public String displayBoard(){
        return board.display();
    }
}
