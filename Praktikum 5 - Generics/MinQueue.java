import java.util.Collections;
public class MinQueue<T extends Comparable<T>> extends AbstractQueue<T> {
    /**
     * Menambahkan elemen ke dalam queue
     * 
     * @param element elemen yang akan ditambahkan
     */
    @Override
    public void enqueue(T element) {
        elements.add(element);
        Collections.sort(elements);
    }

    /**
     * Menghapus elemen dari queue
     * 
     * @return elemen yang dihapus atau null jika queue kosong
     */
    @Override
    public T dequeue() {
        if (elements.isEmpty()){
            return null;
        }
        T elemenMin = elements.get(0);
        elements.remove(elements.get(0));
        return elemenMin;
    }

    /**
     * Mengembalikan elemen terdepan dari queue
     * 
     * @return elemen teratas atau null jika queue kosong
     */
    @Override
    public T front() {
        if (elements.isEmpty()){
            return null;
        }

        return elements.get(0);
    }
}
