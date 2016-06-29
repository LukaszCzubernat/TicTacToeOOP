package model;

import model.board.Board;
import model.field.Field;
import model.field.Sign;
import org.junit.internal.requests.FilterRequest;
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
        Field field = new Field(4, Sign.O);

        // when - then
        Assert.assertTrue(board.placeSign(field));
    }

    @Test
    public void placeThreeSignsOnBoard(){
        // given
        Field firstField = new Field(0, Sign.X);
        Field secondField = new Field(1, Sign.O);
        Field thirdField = new Field(2, Sign.X);
        Field centerField = new Field(4, Sign.X);

        // when - then
        Assert.assertTrue(board.placeSign(firstField));
        Assert.assertTrue(board.placeSign(secondField));
        Assert.assertTrue(board.placeSign(thirdField));

        Assert.assertFalse(board.placeSign(firstField));
        Assert.assertFalse(board.placeSign(centerField));
    }
}
