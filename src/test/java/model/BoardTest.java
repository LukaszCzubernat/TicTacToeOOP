package model;

import model.board.impl.Board;
import model.field.Field;
import model.field.Sign;
import org.apache.commons.collections.ListUtils;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import util.Sequence;

import java.util.Arrays;
import java.util.List;

import static model.field.Sign.O;
import static model.field.Sign.X;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertTrue;

/**
 * Created by Hawk on 28.06.16.
 */
public class BoardTest {

    private Board board;
    private Field[] fields;

    @BeforeGroups(groups = {"placeSignOnBoard"})
    public void initEmptyBoard(){
        this.board = new Board(new Field[9]);
    }

    @Test(groups = "placeSignOnBoard")
    public void placeSignOInCenterOfBoard(){
        // given
        Field centralOField = new Field(4, O);

        // when - then
        assertTrue(board.placeSign(centralOField));
    }

    @Test(groups = "placeSignOnBoard", dependsOnMethods = {"placeSignOInCenterOfBoard"})
    public void placeXOXOnBoard(){
        // given
        Field firstXField = new Field(0, X);
        Field secondOField = new Field(1, O);
        Field thirdXField = new Field(2, X);

        // when - then
        assertTrue(board.placeSign(firstXField));
        assertTrue(board.placeSign(secondOField));
        assertTrue(board.placeSign(thirdXField));
    }

    @Test(groups = "placeSignOnBoard", dependsOnMethods = {"placeXOXOnBoard"})
    public void placeXOXOOnOccupiedFieldsOnBoard(){
        // given
        Field firstXField = new Field(0, X);
        Field secondOField = new Field(1, O);
        Field thirdXField = new Field(2, X);
        Field centerXField = new Field(4, O);

        // when - then
        assertFalse(board.placeSign(firstXField));
        assertFalse(board.placeSign(secondOField));
        assertFalse(board.placeSign(thirdXField));
        assertFalse(board.placeSign(centerXField));
    }

    @BeforeGroups(groups = {"getValuesForSequence"})
    public void initFilledBoard(){
        fields = new Field[9];

        // 3 "O" sings on diagonal
        fields[0] = new Field(0, O);
        fields[4] = new Field(4, O);
        fields[8] = new Field(8, O);

        // additional "X" sings on top horizontal row
        fields[1] = new Field(1, X);
        fields[2] = new Field(2, X);

        board = new Board(fields);
    }

    @Test(groups = "getValuesForSequence")
    public void getValuesForSequence(){
        // given
        Sequence diagonalSequence = new Sequence(0, 4);
        Sequence topRowSequence = new Sequence(0, 1);

        List<Sign> expectedDiagonalValues = Arrays.asList(O, O, O);
        List<Sign> expectedTopRowValues = Arrays.asList(O, X, X);

        // when - then
        assertTrue(ListUtils.isEqualList(board.getValuesForSequence(diagonalSequence), expectedDiagonalValues));
        assertTrue(ListUtils.isEqualList(board.getValuesForSequence(topRowSequence), expectedTopRowValues));
    }
}
