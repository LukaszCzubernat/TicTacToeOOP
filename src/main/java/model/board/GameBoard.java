package model.board;

import model.field.GameField;
import model.field.impl.Sign;

/**
 * Created by lucz on 01.07.16.
 */
public interface GameBoard {
    void fillFieldOnBoard(GameField field);

    GameField getFieldForIndex(Integer index);

    Sign getSignOfFieldForIndex(Integer index);

    String display();
}