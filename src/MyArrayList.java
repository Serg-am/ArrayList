import java.util.Arrays;
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
}
