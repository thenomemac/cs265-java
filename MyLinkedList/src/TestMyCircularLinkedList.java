/**
 * Created by thenome on 5/10/16.
 */

public class TestMyCircularLinkedList {
    public static void main(String[] args) {
        // Create a list
        MyCircularLinkedList<String> list = new MyCircularLinkedList<String>();

        // Add elements to the list
        list.add("America"); // Add it to the list
        System.out.println("(1) " + list);

        list.add(0, "Canada"); // Add it to the beginning of the list
        System.out.println("(2) " + list);

        list.add("Russia"); // Add it to the end of the list
        System.out.println("(3) " + list);

        list.add("France"); // Add it to the end of the list
        System.out.println("(4) " + list);

        list.add(2, "Germany"); // Add it to the list at index 2
        System.out.println("(5) " + list);

        list.add(5, "Norway"); // Add it to the list at index 5
        System.out.println("(6) " + list);

        // Remove elements from the list
        list.remove("Canada"); // Same as list.remove(0) in this case
        System.out.println("(7) " + list);

        list.remove(2); // Remove the element at index 2
        System.out.println("(8) " + list);

        list.remove(list.size() - 1); // Remove the last element
        System.out.println("(9) " + list);

        list.clear(); // Clear elements
        System.out.println("(10) " + list + " Size: " + list.size());

        // Create a list
        String[] strVec = {"America", "Germany", "France", "Norway"};
        list = new MyCircularLinkedList<String>(strVec);
        System.out.println("(11) " + list);

        // test contains
        System.out.println("(12) Am: " + list.contains("Am") + " France: " + list.contains("France"));

        // test remove
        list.removeFirst();
        System.out.println("(13) " + list);
        list.remove(1);
        System.out.println("(14) " + list);
        list.removeLast();
        System.out.println("(15) " + list);
        list.removeLast();
        System.out.println("(16) " + list);
        list.removeFirst();
        System.out.println("(17) " + list);


    }
}
