package controler.core;

import controler.board.BoardController;
import model.board.impl.BoardBuilder;
import model.field.Field;
import model.field.GameField;

/**
 * Created by lucz on 01.07.16.
 */
public class GameEngine {

    private BoardController boardController;

    public GameEngine() {
        this.boardController = new BoardController(new BoardBuilder(9).createEmptyBoard());
    }

    public Boolean placeOnBoard(GameField field) {
        return boardController.placeSignOnBoard(field);
    }
}
