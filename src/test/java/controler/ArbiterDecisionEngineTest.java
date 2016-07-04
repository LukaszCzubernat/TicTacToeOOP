package controler;

import controler.arbiter.impl.ArbiterDecisionEngine;
import controler.board.impl.BoardController;
import controler.board.GameBoardController;
import model.board.GameBoard;
import model.board.impl.Board;
import model.field.GameField;
import model.field.impl.Field;
import org.apache.commons.collections.SetUtils;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import util.Sequence;
import util.impl.SequenceInitializer;
import util.impl.WinSequence;

import java.util.Set;

import static model.field.impl.Sign.O;
import static model.field.impl.Sign.X;
import static org.testng.Assert.assertTrue;

/**
 * Created by lucz on 30.06.16.
 */
public class ArbiterDecisionEngineTest {

    private Set<Sequence> expectedWinningSequences;
    private GameBoardController boardController;

    public void initSequences(){
        expectedWinningSequences = SequenceInitializer.getAllWinningSequences();
        expectedWinningSequences.remove(new WinSequence(0, 1));
    }

    @BeforeGroups(groups = { "arbiterHelperUpdateSequences" })
    public void initFilledBoardWithConflictedSequences(){
        GameField[] fields = new Field[9];
        fields[0] = new Field(0, O);
        fields[1] = new Field(1, X);
        GameBoard board = new Board(fields);
        boardController = new BoardController(board);
        initSequences();
    }


    @Test(groups = "arbiterHelperUpdateSequences")
    public void updateWinningSequences(){
        // given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();

        // when
        arbiterDecisionEngine.updateWinningSequences(boardController);

        // then
        assertTrue(SetUtils.isEqualSet(arbiterDecisionEngine.getPossibleWinningSequences(), expectedWinningSequences));
    }

    @BeforeGroups(groups = { "arbiterHelperWinningSequence" })
    public void initFilledBoardWithWinningSequence(){
        GameField[] fields = new Field[9];

        // 3 "O" sings on diagonal
        fields[0] = new Field(0, O);
        fields[4] = new Field(4, O);
        fields[8] = new Field(8, O);

        // additional "X" sings on most left column
        fields[1] = new Field(3, X);
        fields[2] = new Field(6, X);

        GameBoard board = new Board(fields);
        boardController = new BoardController(board);
    }

    @Test(groups = "arbiterHelperWinningSequence")
    public void isBoardContainsWinningSequence(){
        // given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();

        // when - then
        assertTrue(arbiterDecisionEngine.isBoardContainsWinningSequence(boardController));
    }

}
