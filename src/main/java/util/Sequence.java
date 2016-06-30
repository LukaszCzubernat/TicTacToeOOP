package util;

import org.apache.commons.collections.SetUtils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by lucz on 29.06.16.
 */
public class Sequence {
    private Set<Integer> sequenceValues = new HashSet<>();

    public Sequence(Integer beginIndex, Integer step) {
        sequenceValues.add(beginIndex);
        sequenceValues.add(new Integer(beginIndex + step));
        sequenceValues.add(new Integer(beginIndex + step + step));
    }

    public Boolean contains(Integer index) {
        return sequenceValues.contains(index);
    }

    public Set<Integer> showSequenceValues() {
        return sequenceValues;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequenceValues);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (Objects.isNull(object)) return false;
        if (getClass() != object.getClass()) return false;
        Sequence other = (Sequence) object;
        return SetUtils.isEqualSet(sequenceValues, other.sequenceValues);
    }
}