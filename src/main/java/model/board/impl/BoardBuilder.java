package model.board.impl;

import model.board.GameBoard;
import model.board.GameBoardBuilder;
import model.field.impl.Field;

/**
 * Created by lucz on 29.06.16.
 */
public class BoardBuilder implements GameBoardBuilder {
    private Integer dimension;

    public BoardBuilder(Integer dimension) {
        this.dimension = dimension;
    }

    public GameBoard createEmptyBoard() {
        return new Board(new Field[dimension]);
    }
}
