package controler;

import controler.core.GameEngine;
import model.field.impl.Field;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static model.field.impl.Sign.O;
import static model.field.impl.Sign.X;
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
    public void placeXOXOnNonOccupiedFieldsOnBoard() {
        // given
        Field firstXField = new Field(0, X);
        Field secondOField = new Field(1, O);
        Field thirdXField = new Field(2, X);

        // when - then
        assertTrue(gameEngine.placeOnBoard(firstXField));
        assertTrue(gameEngine.placeOnBoard(secondOField));
        assertTrue(gameEngine.placeOnBoard(thirdXField));
    }

    @Test(groups = "gameEngine", dependsOnMethods = { "placeXOXOnNonOccupiedFieldsOnBoard" })
    public void placeOXOOnOccupiedFieldsOnBoard() {
        // given
        Field firstOField = new Field(0, O);
        Field secondXField = new Field(1, X);
        Field thirdOField = new Field(2, O);

        // when - then
        assertFalse(gameEngine.placeOnBoard(firstOField));
        assertFalse(gameEngine.placeOnBoard(secondXField));
        assertFalse(gameEngine.placeOnBoard(thirdOField));
    }


}
