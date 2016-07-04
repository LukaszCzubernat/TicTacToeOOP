package util;

import org.testng.annotations.Test;
import util.impl.SequenceInitializer;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by lucz on 29.06.16.
 */
public class SequenceInitializerTest {

    @Test(groups = "sequence")
    public void checkNumberOfWinningSequences(){
        // given - when
        Set<Sequence> sequences = SequenceInitializer.getAllWinningSequences();

        // then
        assertEquals(sequences.size(), 8);

    }
}
