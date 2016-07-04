package model;

import model.board.impl.Board;
import model.field.impl.Field;
import model.field.impl.Sign;
import org.junit.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static model.field.impl.Sign.O;
import static model.field.impl.Sign.X;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Hawk on 28.06.16.
 */
public class BoardTest {

    private Board board;

    @BeforeGroups(groups = { "getFieldFromBoard" , "getSignFromField" })
    public void initBoard(){
        Field[] fields = new Field[9];
        fields[0] = new Field(0, X);
        fields[1] = new Field(1, O);
        fields[2] = new Field(2, X);

        this.board = new Board(fields);
    }

    @Test(groups = "getFieldFromBoard")
    public void getExistingFieldForIndex(){
        // given
        Field firstExpectedField = new Field(0, X);
        Field secondExpectedField = new Field(1, O);
        Field thirdExpectedField = new Field(2, X);

        // when - then
        assertEquals(board.getFieldForIndex(0), firstExpectedField);
        assertEquals(board.getFieldForIndex(1), secondExpectedField);
        assertEquals(board.getFieldForIndex(2), thirdExpectedField);
    }

    @Test(groups = "getFieldFromBoard")
    public void getNonExistingFieldForIndex(){
        // given

        // when - then
        assertNull(board.getFieldForIndex(6));
        assertNull(board.getFieldForIndex(7));
        assertNull(board.getFieldForIndex(8));
    }


    @Test(groups = "getSignFromField")
    public void getSignOfExistingFieldForIndex(){
        // given
        Sign firstExpectedSign = X;
        Sign secondExpectedSign = O;
        Sign thirdExpectedSign = X;

        // when - then
        Assert.assertEquals(board.getSignOfFieldForIndex(0), firstExpectedSign);
        Assert.assertEquals(board.getSignOfFieldForIndex(1), secondExpectedSign);
        Assert.assertEquals(board.getSignOfFieldForIndex(2), thirdExpectedSign);
    }

    @Test(groups = "getSignFromField")
    public void getSignOfNonExistingFieldForIndex(){
        // given

        // when - then
        assertNull(board.getSignOfFieldForIndex(6));
        assertNull(board.getSignOfFieldForIndex(7));
        assertNull(board.getSignOfFieldForIndex(8));
    }

}
