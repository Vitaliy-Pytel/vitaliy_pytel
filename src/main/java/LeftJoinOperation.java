import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LeftJoinOperation<D1, D2, R> implements JoinOperation<D1, D2, R>{

    @Override
    public Collection<R> join(Collection<D1> leftCollection, Collection<D2> rightCollection) {
        Collection<R> joined = new ArrayList<>();
        List<D1> leftList = (List<D1>) leftCollection;
        List<D2> rightList = (List<D2>) rightCollection;

        for (int i = 0; i < leftCollection.size(); i++) {
            DataRow<Object, Object> leftObject = (DataRow<Object, Object>) leftList.get(i);
            JoinedDataRow joinedRow = new JoinedDataRow();
            joinedRow.setKey(leftObject.getKey());
            joinedRow.setValueOne(leftObject.getValue());
            for (int j = 0; j < rightCollection.size(); j++) {
                DataRow<Object, Object> rightObject = (DataRow<Object, Object>) rightList.get(j);
                if (leftObject.key.equals(rightObject.key)) {
                    joinedRow.setValueTwo(rightObject.getValue());
                }
            }
            joined.add((R) joinedRow);
        }
        return joined;
    }
}
