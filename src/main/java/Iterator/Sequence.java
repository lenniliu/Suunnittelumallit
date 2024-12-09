package Iterator;

import java.util.Iterator;

public interface Sequence {
    Iterator<Integer> getIterator();

    Iterator<Integer> iterator();
}
