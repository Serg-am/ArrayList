
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        System.out.println("Size: " + myArrayList.size());
        System.out.println("Elements: " + myArrayList);
        System.out.println("Element at index 1: " + myArrayList.get(1));

        myArrayList.delete(1);
        System.out.println("After deleting index 1: " + myArrayList);

        myArrayList.clear();
        System.out.println("After clearing: " + myArrayList);
    }
}