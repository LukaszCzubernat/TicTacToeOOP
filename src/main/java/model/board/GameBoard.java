package model.board;

import model.field.Field;
import model.field.GameField;
import model.field.Sign;

/**
 * Created by lucz on 01.07.16.
 */
public interface GameBoard {
    void fillFieldOnBoard(GameField field);
    Field getFieldForIndex(Integer index);
    Sign getSignOfFieldForIndex(Integer index);
    String display();
}