package controler;

import controler.core.GameEngine;
import model.field.Field;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static model.field.Sign.O;
import static model.field.Sign.X;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by lucz on 01.07.16.
 */
public class GameEngineTest {

    private GameEngine gameEngine;

    @BeforeGroups(groups = {"gameEngine"})
    public void initGameEngine() {
        gameEngine = new GameEngine();
    }

    @Test(groups = "gameEngine")
    public void placeXOXOOnOccupiedFieldsOnBoard() {
        // given
        Field firstXField = new Field(0, X);
        Field secondOField = new Field(1, O);
        Field thirdXField = new Field(2, X);

        // when - then
        assertTrue(gameEngine.placeOnBoard(firstXField));
        assertTrue(gameEngine.placeOnBoard(secondOField));
        assertTrue(gameEngine.placeOnBoard(thirdXField));
    }

    @Test(groups = "gameEngine")
    public void placeXOXOOnNonOccupiedFieldsOnBoard() {
        // given
        Field firstXField = new Field(0, X);
        Field secondOField = new Field(1, O);
        Field thirdXField = new Field(2, X);

        // when - then
        assertFalse(gameEngine.placeOnBoard(firstXField));
        assertFalse(gameEngine.placeOnBoard(secondOField));
        assertFalse(gameEngine.placeOnBoard(thirdXField));
    }


}
