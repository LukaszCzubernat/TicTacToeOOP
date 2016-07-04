package util;

import org.apache.commons.collections.SetUtils;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import util.impl.WinSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by lucz on 29.06.16.
 */
public class SequenceTest {

    private Sequence sequence;

    @BeforeGroups(groups = "sequence")
    public void init(){
        sequence = new WinSequence(0, 4);
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

    @Test(groups = "sequence")
    public void showSequenceValues(){
        // given
        Set<Integer> expectedValues = new HashSet<>(Arrays.asList(0, 4, 8));

        // when
        Set<Integer> sequenceValues = sequence.showSequenceValues();

        // then
        assertTrue(SetUtils.isEqualSet(sequenceValues, expectedValues));
    }
}


