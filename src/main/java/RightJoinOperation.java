import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RightJoinOperation<D1, D2, R> implements JoinOperation{
    @Override
    public Collection join(Collection leftCollection, Collection rightCollection) {
        Collection<R> joined = new ArrayList<>();
        List<D1> leftList = (List<D1>) leftCollection;
        List<D2> rightList = (List<D2>) rightCollection;

        for (int i = 0; i < rightCollection.size(); i++) {
            DataRow<Object, Object> rightObject = (DataRow<Object, Object>) rightList.get(i);
            JoinedDataRow joinedRow = new JoinedDataRow();
            joinedRow.setKey(rightObject.getKey());
            joinedRow.setValueTwo(rightObject.getValue());
            for (int j = 0; j < leftCollection.size(); j++) {
                DataRow<Object, Object> leftObject = (DataRow<Object, Object>) leftList.get(j);
                if (rightObject.key.equals(leftObject.key)) {
                    joinedRow.setValueOne(leftObject.getValue());
                }
            }
            joined.add((R) joinedRow);
        }
        return joined;
    }
}
