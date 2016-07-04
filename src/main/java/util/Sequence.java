package util;

import java.util.Set;

/**
 * Created by lucz on 04.07.16.
 */
public interface Sequence {
    Boolean contains(Integer index);
    Set<Integer> showSequenceValues();
}
