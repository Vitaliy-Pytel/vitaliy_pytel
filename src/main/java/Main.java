import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        JoinOperation<DataRow<Integer, String>,
                DataRow<Integer, String>,
                JoinedDataRow<Integer, String, String>> innerJoinOperation
                = new InnerJoinOperation<>();
        JoinOperation<DataRow<Integer, String>,
                DataRow<Integer, String>,
                JoinedDataRow<Integer, String, String>> leftJoinOperation
                = new LeftJoinOperation<>();
        JoinOperation<DataRow<Integer, String>,
                DataRow<Integer, String>,
                JoinedDataRow<Integer, String, String>> rightJoinOperation
                = new RightJoinOperation<>();
        Collection<DataRow<Integer, String>> leftCollection = new ArrayList<DataRow<Integer, String>>(Arrays.asList(
                new DataRow<>(0, "Ukraine"),
                new DataRow<>(1, "Germany"),
                new DataRow<>(2, "France")
        ));
        Collection<DataRow<Integer, String>> rightCollection = new ArrayList<DataRow<Integer, String>>(Arrays.asList(
                new DataRow<>(0, "Kyiv"),
                new DataRow<>(1, "Berlin"),
                new DataRow<>(3, "Budapest")
        ));
        Collection joinedInner;
        Collection joinedLeft;
        Collection joinedRight;
        joinedInner = innerJoinOperation.join(leftCollection, rightCollection);
        joinedRight =  rightJoinOperation.join(leftCollection, rightCollection);
        joinedLeft = leftJoinOperation.join(leftCollection, rightCollection);

        System.out.println("Output for innerJoinOperation");
        joinedInner.stream().forEach(System.out::println);

        System.out.println("Output for rightJoinOperation");
        joinedRight.stream().forEach(System.out::println);

        System.out.println("Output for leftJoinOperation");
        joinedLeft.stream().forEach(System.out::println);
    }
}
