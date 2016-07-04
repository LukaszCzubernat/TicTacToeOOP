package controler.core;

import controler.board.GameBoardController;
import controler.board.impl.BoardController;
import model.board.impl.BoardBuilder;
import model.field.GameField;

/**
 * Created by lucz on 01.07.16.
 */
public class GameEngine {

    private GameBoardController boardController;

    public GameEngine() {
        this.boardController = new BoardController(new BoardBuilder(9).createEmptyBoard());
    }

    public Boolean placeOnBoard(GameField field) {
        return boardController.placeSignOnBoard(field);
    }
}
