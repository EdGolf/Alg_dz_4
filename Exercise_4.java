// Итоговый проект: Реализовать метод contains в классе Tree


import java.util.Objects;

public class Exercise_4<T extends Comparable<T>> {

    public static void main(String[] args) {
        int[] values = {2, 4, 12, 54, 21, 5, 53, 3, 13, 6, 14, 8};
        Exercise_4<Integer> tree = new Exercise_4<Integer>();
        for (int value : values) {
            tree.add(value);
        }
        int[] checkValues = { 16, 7, 1, 10, 53, 41, 6, 12, 3, 8};
        for (int value : checkValues) {
            System.out.printf("%d %s contained in tree\n", value, tree.contains(value)?"":"not");
        }
        System.out.println();
    }

    private Node root;

    private class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }

        
        public String toString() {
            return value.toString();
        }
    }

    public void add(T value) {
        Objects.requireNonNull(value);
        root = appendNode(root, value);
    }

    private Node appendNode(Node current, T value) {
        if (current == null) {
            return new Node(value);
        }

        int compare = value.compareTo(current.value);
        if (compare < 0) {
            current.left = appendNode(current.left, value);
        } else if (compare > 0) {
            current.right = appendNode(current.right, value);
        }

        return current;
    }

    public boolean contains(T value) {
        Objects.requireNonNull(value);
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, T value) {
        if (current == null)
            return false;
        if (value.compareTo(current.value) == 0)
            return true;
        if(value.compareTo(current.value) < 0)
            return containsRecursive(current.left, value);
        return containsRecursive(current.right, value);
    }

}