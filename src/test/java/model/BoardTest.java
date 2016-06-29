package model;

import model.board.Board;
import model.field.Field;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static model.field.Sign.O;
import static model.field.Sign.X;
import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
        Field centralOField = new Field(4, O);

        // when - then
        assertTrue(board.placeSign(centralOField));
    }

    @Test(groups = "board", dependsOnMethods = {"placeSignOInCenterOfBoard"})
    public void placeXOXOnBoardHappyPath(){
        // given
        Field firstXField = new Field(0, X);
        Field secondOField = new Field(1, O);
        Field thirdXField = new Field(2, X);

        // when - then
        assertTrue(board.placeSign(firstXField));
        assertTrue(board.placeSign(secondOField));
        assertTrue(board.placeSign(thirdXField));
    }

    @Test(groups = "board", dependsOnMethods = {"placeXOXOnBoardHappyPath"})
    public void placeXOXOnBoardErrorPath(){
        // given
        Field firstXField = new Field(0, X);
        Field secondOField = new Field(1, O);
        Field thirdXField = new Field(2, X);
        Field centerXField = new Field(4, X);

        // when - then
        assertFalse(board.placeSign(firstXField));
        assertFalse(board.placeSign(secondOField));
        assertFalse(board.placeSign(thirdXField));
        assertFalse(board.placeSign(centerXField));
    }
}
