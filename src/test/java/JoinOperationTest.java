import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JoinOperationTest {
    ArrayList<DataRow<Integer, String>> leftCollection = new ArrayList<DataRow<Integer, String>>(Arrays.asList(
            new DataRow<>(0, "Ukraine"),
            new DataRow<>(1, "Germany"),
            new DataRow<>(2, "France")
    ));
    Collection<DataRow<Integer, String>> rightCollection = new ArrayList<DataRow<Integer, String>>(Arrays.asList(
            new DataRow<>(0, "Kyiv"),
            new DataRow<>(1, "Berlin"),
            new DataRow<>(3, "Budapest")
    ));

    @Test
    void innerJoinShouldReturnCorrectJoinedCollection() {
        Collection<JoinedDataRow<Integer, String, String>> expected = new LinkedList<>(
                Arrays.asList(
                        new JoinedDataRow<Integer, String, String>(0, "Ukraine", "Kyiv"),
                        new JoinedDataRow<Integer, String, String>(1, "Germany", "Berlin")
                ));
        assertEquals((Collection) expected, new InnerJoinOperation<DataRow<Integer, String>,
                DataRow<Integer, String>,
                JoinedDataRow<Integer, String, String>>().join(leftCollection, rightCollection));
    }

    @Test
    void leftJoinShouldReturnCorrectJoinedCollection() {
        Collection<JoinedDataRow<Integer, String, String>> expected = new LinkedList<>(
                Arrays.asList(
                        new JoinedDataRow<Integer, String, String>(0, "Ukraine", "Kyiv"),
                        new JoinedDataRow<Integer, String, String>(1, "Germany", "Berlin"),
                        new JoinedDataRow<Integer, String, String>(2, "France", null)

                ));
        assertEquals((Collection) expected, new LeftJoinOperation<DataRow<Integer, String>,
                DataRow<Integer, String>,
                JoinedDataRow<Integer, String, String>>().join(leftCollection, rightCollection));
    }

    @Test
    void rightJoinShouldReturnCorrectJoinedCollection() {
        Collection<JoinedDataRow<Integer, String, String>> expected = new LinkedList<>(
                Arrays.asList(
                        new JoinedDataRow<Integer, String, String>(0, "Ukraine", "Kyiv"),
                        new JoinedDataRow<Integer, String, String>(1, "Germany", "Berlin"),
                        new JoinedDataRow<Integer, String, String>(3, null, "Budapest")

                ));
        assertEquals((Collection) expected, new RightJoinOperation<DataRow<Integer, String>,
                DataRow<Integer, String>,
                JoinedDataRow<Integer, String, String>>().join(leftCollection, rightCollection));
    }

}
