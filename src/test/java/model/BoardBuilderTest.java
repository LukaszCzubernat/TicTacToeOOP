package model;

import model.board.GameBoard;
import model.board.GameBoardBuilder;
import model.board.impl.Board;
import model.board.impl.BoardBuilder;
import model.field.impl.Field;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by lucz on 29.06.16.
 */
public class BoardBuilderTest {

    @Test
    public void createBoard(){
        // given
        GameBoardBuilder boardBuilder = new BoardBuilder(9);
        GameBoard board = new Board(new Field[9]);

        // when - then
        Assert.assertNotSame(boardBuilder.createEmptyBoard(), board);
        Assert.assertEquals(boardBuilder.createEmptyBoard().getClass(), Board.class);
    }
}
