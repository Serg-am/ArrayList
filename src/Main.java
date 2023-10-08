import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(13);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(8);
        myArrayList.add(26);
        myArrayList.add(11);

        System.out.println("Size: " + myArrayList.size());
        System.out.println("Elements: " + myArrayList);
        System.out.println("Element at index 1: " + myArrayList.get(1));

        myArrayList.delete(1);
        System.out.println("After deleting index 1: " + myArrayList);


        myArrayList.sort(Comparator.naturalOrder()); // Сортировка по возрастанию
        System.out.println(myArrayList);

        myArrayList.sort(Comparator.reverseOrder()); // Сортировка по убыванию
        System.out.println(myArrayList);


        myArrayList.clear();
        System.out.println("After clearing: " + myArrayList);
    }
}