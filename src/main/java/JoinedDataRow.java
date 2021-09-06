public class JoinedDataRow<K, V1, V2> {
    K key;
    V1 valueOne;
    V2 valueTwo;

    public JoinedDataRow() {

    }

    public JoinedDataRow(K key, V1 valueOne, V2 valueTwo) {
        this.key = key;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    public K getKey() {
        return key;
    }

    public V1 getValueOne() {
        return valueOne;
    }

    public V2 getValueTwo() {
        return valueTwo;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValueOne(V1 valueOne) {
        this.valueOne = valueOne;
    }

    public void setValueTwo(V2 valueTwo) {
        this.valueTwo = valueTwo;
    }

    @Override
    public String toString() {
        return "JoinedDataRow{" +
                "key=" + key +
                ", valueOne=" + valueOne +
                ", valueTwo=" + valueTwo +
                '}';
    }
}
