import java.util.Iterator;

public class Deque<Type> implements Iterable<Type> {
    private class Node {
        Type item;
        Node prev;
        Node next;

        public Node(Type item) {
            this.item = item;
        }
    }

    private int size = 0;
    private Node first, last;

    public Deque() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Type item) {
        Node newNode = new Node(item);

        // fix double code
        if (size == 0) {
            first = newNode;
            last = newNode;
            size++;
            return;
        }

        newNode.next = first;
        first.prev = newNode;
        first = newNode;
        size++;
    }

    public void addLast(Type item) {
        Node newNode = new Node(item);

        size++;

        if (size == 1) {
            first = newNode;
            last = newNode;
            return;
        }

        newNode.prev = last;
        last.next = newNode;
        last = newNode;
    }

    public Type removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;

        Node toRemove = first;
        first = first.next;
        first.prev = null;
        return toRemove.item;
    }

    public Type removeLast() {
        if (size == 0) {
            return null;
        }

        Node toRemove = last;
        last = last.prev;
        last.next = null;

        size--;

        return toRemove.item;
    }

    private class DequeIter implements Iterator<Type> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Type next() {
            Type val = current.item;
            current = current.next;
            return val;
        }
    }

    public Iterator<Type> iterator() {
        return new DequeIter();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        System.out.println("Is empty: " + deque.isEmpty());

        deque.addFirst(9);
        deque.addFirst(5);

        deque.addLast(23);
        deque.addLast(232);

        System.out.println("Is empty: " + deque.isEmpty());
        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }
        System.out.println();

        deque.addFirst(0);
        deque.addLast(98);

        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }
        System.out.println();

        deque.removeFirst();
        deque.removeLast();

        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }
        System.out.println();

    }

}
