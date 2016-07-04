package controler;

import controler.arbiter.impl.Arbiter;
import controler.board.impl.BoardController;
import controler.board.GameBoardController;
import model.board.GameBoard;
import model.board.impl.Board;
import model.field.GameField;
import model.field.impl.Field;
import model.field.impl.Sign;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static model.field.impl.Sign.O;
import static model.field.impl.Sign.X;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by lucz on 29.06.16.
 */
public class ArbiterTest {

    private Arbiter arbiter;
    private GameBoardController boardController;

    @BeforeGroups(groups = {"arbiter"})
    public void init() {
        GameField[] fields = new Field[9];
        fields[0] = new Field(0, O);
        fields[4] = new Field(4, O);
        fields[8] = new Field(8, O);
        fields[1] = new Field(1, X);

        boardController = new BoardController(new Board(fields));
        arbiter = new Arbiter();
    }

    @Test(groups = "arbiter")
    public void wasThisMoveVictorious() {
        // given
        GameField field = new Field(8, O);

        // when
        boardController.placeSignOnBoard(field);

        // then
        assertTrue(arbiter.wasThisMoveVictorious(boardController));
    }

    @Test(groups = "arbiter", dependsOnMethods = {"wasThisMoveVictorious"})
    public void announceWinner() {
        // given
        String playerName = "Player";
        Sign sign = O;

        // when
        String expectedPhrase = "Player (O) in a winner";

        // then
        assertEquals(arbiter.announceWinner(playerName, sign), expectedPhrase);
    }
}
