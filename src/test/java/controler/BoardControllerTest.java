package controler;

import controler.board.impl.BoardController;
import model.board.GameBoard;
import model.board.impl.Board;
import model.board.impl.BoardBuilder;
import model.field.GameField;
import model.field.impl.Field;
import model.field.impl.Sign;
import org.apache.commons.collections.ListUtils;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Sequence;
import util.impl.WinSequence;

import java.util.Arrays;
import java.util.List;

import static model.field.impl.Sign.O;
import static model.field.impl.Sign.X;
import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by lucz on 01.07.16.
 */
public class BoardControllerTest {

    private GameBoard gameBoard;
    private BoardController boardController;

    @BeforeGroups(groups = {"placeSignOnBoard"})
    public void initEmptyBoard() {
        this.gameBoard = new BoardBuilder(9).createEmptyBoard();
        this.boardController = new BoardController(gameBoard);
    }

    @Test(groups = "placeSignOnBoard")
    public void placeSignOInCenterOfBoard(){
        // given
        GameField centralOField = new Field(4, O);

        // when - then
        assertTrue(boardController.placeSignOnBoard(centralOField));
    }

    @Test(groups = "placeSignOnBoard", dependsOnMethods = {"placeSignOInCenterOfBoard"})
    public void placeXOXOOnNonOccupiedFieldsOnBoard() {
        // given
        GameField firstXField = new Field(0, X);
        GameField secondOField = new Field(1, O);
        GameField thirdXField = new Field(2, X);

        // when - then
        assertTrue(boardController.placeSignOnBoard(firstXField));
        assertTrue(boardController.placeSignOnBoard(secondOField));
        assertTrue(boardController.placeSignOnBoard(thirdXField));
    }

    @Test(groups = "placeSignOnBoard", dependsOnMethods = {"placeXOXOOnNonOccupiedFieldsOnBoard"})
    public void placeXOXOOnOccupiedFieldsOnBoard() {
        // given
        GameField firstXField = new Field(0, X);
        GameField secondOField = new Field(1, O);
        GameField thirdXField = new Field(2, X);
        GameField centerXField = new Field(4, O);

        // when - then
        assertFalse(boardController.placeSignOnBoard(firstXField));
        assertFalse(boardController.placeSignOnBoard(secondOField));
        assertFalse(boardController.placeSignOnBoard(thirdXField));
        assertFalse(boardController.placeSignOnBoard(centerXField));
    }

    @DataProvider
    private static final Object[][] getBoardWithValues(){
        GameField[] fields = new Field[9];
        // 3 "O" sings on diagonal
        fields[0] = new Field(0, O);
        fields[4] = new Field(4, O);
        fields[8] = new Field(8, O);

        // additional "X" sings on top horizontal row
        fields[1] = new Field(1, X);
        fields[2] = new Field(2, X);
        GameBoard board = new Board(fields);
        return new Object[][]{
                { new BoardController(board), new WinSequence(0, 4), Arrays.asList(O, O, O) },
                { new BoardController(board), new WinSequence(0, 1), Arrays.asList(O, X, X) }
        };
    }

    @Test(groups = "getValuesFromBoard", dataProvider = "getBoardWithValues")
    public void getValuesForSequence(BoardController boardController, Sequence sequence,  List<Sign> expectedValue) {
        // given

        // when - then
        assertTrue(ListUtils.isEqualList(boardController.getValuesForSequence(sequence), expectedValue));
    }
}
