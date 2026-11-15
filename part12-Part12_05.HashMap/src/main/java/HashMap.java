
public class HashMap<K, V> {

    private List<Pair<K, V>>[] values;
    private int numberOfValues;

    public HashMap() {
        this.values = new List[32];
        this.numberOfValues = 0;
    }

    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }

        List<Pair<K, V>> valuesAtIndex = this.values[hashValue];
        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }

        return valuesAtIndex.value(index).getValue();
    }

    public void add(K key, V value) {
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        int index = getIndexOfKey(valuesAtIndex, key);

        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.numberOfValues++;
        } else {
            valuesAtIndex.value(index).setValue(value);
        }

        if (1.0 * this.numberOfValues / this.values.length > 0.75) {
            grow();
        }
    }

    public V remove(K key) {
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        if (valuesAtIndex.size() == 0) {
            return null;
        }

        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }

        Pair<K, V> pair = valuesAtIndex.value(index);
        valuesAtIndex.remove(pair);
        this.numberOfValues--;

        return pair.getValue();
    }

    public int size() {
        return this.numberOfValues;
    }

    private void grow() {
        List<Pair<K, V>>[] newArray = new List[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {
            copy(newArray, i);
        }

        this.values = newArray;
    }

    private void copy(List<Pair<K, V>>[] newArray, int fromIndex) {
        if (this.values[fromIndex] == null) {
            return;
        }

        for (int i = 0; i < this.values[fromIndex].size(); i++) {
            Pair<K, V> value = this.values[fromIndex].value(i);

            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new List<>();
            }

            newArray[hashValue].add(value);
        }
    }

    private List<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            this.values[hashValue] = new List<>();
        }

        return this.values[hashValue];
    }

    private int getIndexOfKey(List<Pair<K, V>> myList, K key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.value(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }
}
