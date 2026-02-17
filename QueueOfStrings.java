public class QueueOfStrings {

    private class Node {
        String item;
        Node prev;

        public Node(String s) {
            item = s;
            prev = null;
        }
    }

    Node first = null;
    Node last = null;
    private int size = 0;

    /// inserts a new string onto queue
    public void enqueue(String item) {
        Node newNode = new Node(item);

        if (size == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.prev = newNode;
            last = newNode;
        }

        size++;
    }

    /// removes and returnes the string last recently added
    public String dequeue() {

        if (size == 0) {
            return null;
        }

        String result = first.item;
        first = first.prev;
        size--;

        return result;
    }

    /// Theres no way i need to explain this
    public boolean isEmpty() {
        return (size == 0);
    }

    ///..
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        QueueOfStrings q = new QueueOfStrings();
        q.enqueue("first");
        q.enqueue("second");
        q.enqueue("third");
        q.enqueue("fourth");

        System.out.println(q.size());

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
}
