package controler;

import controler.arbiter.ArbiterDecisionEngine;
import model.board.impl.Board;
import model.field.Field;
import org.apache.commons.collections.SetUtils;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import util.Sequence;
import util.SequenceInitializer;

import java.util.Set;

import static model.field.Sign.O;
import static model.field.Sign.X;
import static org.testng.Assert.assertTrue;

/**
 * Created by lucz on 30.06.16.
 */
public class ArbiterDecisionEngineTest {

    private Set<Sequence> expectedWinningSequences;
    private Board board;

    @BeforeGroups(groups = { "arbiterHelperUpdateSequences" })
    public void initSequences(){
        expectedWinningSequences = SequenceInitializer.getAllWinningSequences();
        expectedWinningSequences.remove(new Sequence(0, 1));
    }

    @BeforeGroups(groups = { "arbiterHelperUpdateSequences" })
    public void initFilledBoardWithConflictedSequences(){
        Field[] fields = new Field[9];
        fields[0] = new Field(0, O);
        fields[1] = new Field(1, X);
        board = new Board(fields);
    }


    @Test(groups = "arbiterHelperUpdateSequences")
    public void updateWinningSequences(){
        // given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();

        // when
        arbiterDecisionEngine.updateWinningSequences(board);

        // then
        assertTrue(SetUtils.isEqualSet(arbiterDecisionEngine.getPossibleWinningSequences(), expectedWinningSequences));
    }

    @BeforeGroups(groups = { "arbiterHelperWinningSequence" })
    public void initFilledBoardWithWinningSequence(){
        Field[] fields = new Field[9];

        // 3 "O" sings on diagonal
        fields[0] = new Field(0, O);
        fields[4] = new Field(4, O);
        fields[8] = new Field(8, O);

        // additional "X" sings on most left vertical column
        fields[1] = new Field(3, X);
        fields[2] = new Field(6, X);

        board = new Board(fields);
    }

    @Test(groups = "arbiterHelperWinningSequence")
    public void isBoardContainsWinningSequence(){
        // given
        ArbiterDecisionEngine arbiterDecisionEngine = new ArbiterDecisionEngine();

        // when - then
        assertTrue(arbiterDecisionEngine.isBoardContainsWinningSequence(board));
    }

}
