import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T item) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return (T) elements[index];
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        // Сдвигаем элементы влево, начиная с индекса, который нужно удалить
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null; // Очищаем последний элемент
        size--; // Уменьшаем размер списка
    }

    public void clear() {
        Arrays.fill(elements, null); // Очищаем все элементы
        size = 0; // Устанавливаем размер списка в 0
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void sort(Comparator<? super T> comparator) {
        quickSort(comparator, 0, size - 1);
    }

    private void quickSort(Comparator<? super T> comparator, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(comparator, low, high);
            quickSort(comparator, low, partitionIndex - 1);
            quickSort(comparator, partitionIndex + 1, high);
        }
    }

    private int partition(Comparator<? super T> comparator, int low, int high) {
        T pivot = get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        elements[index] = item;
    }

    private void swap(int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }
}
