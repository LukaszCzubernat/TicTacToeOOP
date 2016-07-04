package controler.board;

import model.field.GameField;
import model.field.impl.Sign;
import util.Sequence;

import java.util.List;

/**
 * Created by lucz on 04.07.16.
 */
public interface GameBoardController {
    List<Sign> getValuesForSequence(Sequence sequence);
    Boolean placeSignOnBoard(GameField field);
    String displayBoard();
}
