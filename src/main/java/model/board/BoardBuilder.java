package model.board;

import model.field.Field;

/**
 * Created by lucz on 29.06.16.
 */
public class BoardBuilder {
    private Integer dimension;

    public BoardBuilder(Integer dimension) {
        this.dimension = dimension;
    }

    public Board createEmptyBoard() {
        return new Board(new Field[9]);
    }
}
