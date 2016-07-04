package util.impl;

import util.Sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucz on 29.06.16.
 */
public class SequenceInitializer {

    public static Set<Sequence> getAllWinningSequences() {
        Set<Sequence> allWinningSequences = new HashSet<>();
        allWinningSequences.add(new WinSequence(0, 1));
        allWinningSequences.add(new WinSequence(0, 3));
        allWinningSequences.add(new WinSequence(0, 4));
        allWinningSequences.add(new WinSequence(1, 3));
        allWinningSequences.add(new WinSequence(2, 3));
        allWinningSequences.add(new WinSequence(3, 1));
        allWinningSequences.add(new WinSequence(6, 1));
        allWinningSequences.add(new WinSequence(2, 2));
        return allWinningSequences;
    }
}
