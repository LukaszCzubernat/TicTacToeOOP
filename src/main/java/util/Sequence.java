package util;

import org.apache.commons.collections.SetUtils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by lucz on 29.06.16.
 */
public class Sequence {
    private Set<Integer> sequence = new HashSet<>();

    public Sequence(Integer beginIndex, Integer step){
        sequence.add(beginIndex);
        sequence.add(new Integer(beginIndex+step));
        sequence.add(new Integer(beginIndex+step+step));
    }

    public Boolean contains(Integer index){
        return sequence.contains(index);
    }

    @Override
    public int hashCode(){
        return Objects.hash(sequence);
    }

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(Objects.isNull(object)) return false;
        if(getClass() != object.getClass()) return false;
        Sequence other = (Sequence) object;
        return SetUtils.isEqualSet(sequence, other.sequence);
    }
}