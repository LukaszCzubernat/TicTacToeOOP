package util;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by lucz on 29.06.16.
 */
public class SequenceTest {

    private Sequence sequence;

    @BeforeGroups(groups = "sequence")
    public void init(){
        sequence = new Sequence(0, 4);
    }

    @Test(groups = "sequence")
    public void isSequenceContainsValue(){
        // given
        Integer value = new Integer(4);

        // when - then
        assertTrue(sequence.contains(value));
    }

    @Test(groups = "sequence")
    public void isSequenceNotContainsValue(){
        // given
        Integer value = new Integer(1);

        // when - then
        assertFalse(sequence.contains(value));
    }
}


