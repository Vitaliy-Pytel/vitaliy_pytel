import java.util.Collection;

public interface JoinOperation <D1, D2, R> {
    Collection<R> join(Collection<D1> leftCollection, Collection<D2> rightCollection);
}
