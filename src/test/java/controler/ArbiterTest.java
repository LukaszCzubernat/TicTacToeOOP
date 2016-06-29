package controler;

import controler.arbiter.Arbiter;
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

    @BeforeGroups(groups = {"arbiter"})
    public void init() {
        arbiter = new Arbiter();
    }

    @Test(groups = "arbiter")
    public void wasThisMoveVictorious() {
        // given
        Field field = new Field(8, O);

        // when - then
        assertTrue(arbiter.wasThisMoveVictorious(field));
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
