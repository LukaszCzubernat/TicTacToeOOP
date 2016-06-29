package model;

import model.board.Board;
import model.field.Field;
import model.field.Sign;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * Created by Hawk on 28.06.16.
 */
public class BoardTest {

    private Board board;

    @BeforeGroups(groups = {"board"})
    public void initBoard(){
        this.board = new Board(new Field[9]);
    }

    @Test(groups = "board")
    public void placeSignOInCenterOfBoard(){
        // given
        Field field = new Field(1, Sign.O);
        // when - then
        Assert.assertTrue(board.placeSign(field));
    }
}
