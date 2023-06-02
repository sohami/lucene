package org.apache.lucene.search;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.lucene.index.LeafReaderContext;

/**
 * A class holding a subset of the {@link IndexSearcher}s leaf contexts to be executed within a
 * single thread.
 *
 * @lucene.experimental
 */
public class LeafSlice {
    /**
     * The leaves that make up this slice.
     *
     * @lucene.experimental
     */
    public final LeafReaderContext[] leaves;

    public LeafSlice(List<LeafReaderContext> leavesList) {
        Collections.sort(leavesList, Comparator.comparingInt(l -> l.docBase));
        this.leaves = leavesList.toArray(new LeafReaderContext[0]);
    }
}
