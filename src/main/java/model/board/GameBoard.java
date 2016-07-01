package model.board;

import model.field.GameField;
import model.field.Sign;
import util.Sequence;

import java.util.List;

/**
 * Created by lucz on 01.07.16.
 */
public interface GameBoard {
    Boolean placeSign(GameField field);
    List<Sign> getValuesForSequence(Sequence sequence);
    String display();
}