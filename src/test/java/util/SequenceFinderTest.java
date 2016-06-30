package util;

import model.field.Field;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static model.field.Sign.X;

/**
 * Created by lucz on 30.06.16.
 */
public class SequenceFinderTest {

    List<Sequence> expectedSequences;

    @BeforeGroups(groups = {"sequence"})
    public void init() {
        expectedSequences = Arrays.asList(new Sequence(0, 1), new Sequence(0, 3), new Sequence(0, 4));
    }

    @Test(groups = "sequence")
    public void findSequencesForZero() {
        // given
        SequenceInitializer sequenceInitializer = new SequenceInitializer();
        SequenceFinder sequenceFinder = new SequenceFinder(sequenceInitializer.getAllWinningSequences());

        // when
        List<Sequence> foundSequences = sequenceFinder.findSequencesForField(new Field(0, X));

        // then
        assertThat(foundSequences, is(expectedSequences));
    }
}
