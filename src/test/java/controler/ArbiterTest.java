package controler;

import controler.arbiter.Arbiter;
import model.board.Board;
import model.field.Field;
import model.field.Sign;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static model.field.Sign.O;
import static model.field.Sign.X;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by lucz on 29.06.16.
 */
public class ArbiterTest {

    private Arbiter arbiter;
    private Board board;

    @BeforeGroups(groups = {"arbiter"})
    public void init() {
        board = new Board(new Field[9]);
        board.placeSign(new Field(0, O));
        board.placeSign(new Field(4, O));
        board.placeSign(new Field(8, O));
        board.placeSign(new Field(1, X));

        arbiter = new Arbiter();
    }

    @Test(groups = "arbiter")
    public void wasThisMoveVictorious() {
        // given
        Field field = new Field(8, O);

        // when
        board.placeSign(field);

        // then
        assertTrue(arbiter.wasThisMoveVictorious(board));
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
