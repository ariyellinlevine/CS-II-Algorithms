import java.util.Iterator;

public class LLStack<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;

        public Node(Item s) {
            item = s;
            next = null;
        }
    }

    Node top;
    int n;

    public LLStack() {
        top = null;
        n = 0;
    }

    public void push(Item s) {
        Node newNode = new Node(s);
        newNode.next = top;
        top = newNode;
        n++;
    }

    public Item pop() {
        if (n > 0) {
            Item result = top.item;
            top = top.next;
            n--;
            return result;
        }
        return null;
    }

    private class LLStackIter implements Iterator<Item> {
        private Node current;

        public LLStackIter() {
            current = top;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public Item next() {
            Item result = current.item;

            current = current.next;
            return result;
        }
    }

    public Iterator<Item> iterator() {
        return new LLStackIter();
    }

    public String toString() {
        String s = "";
        for (Item i : this) {
            s += i;
            s += "; ";
        }
        return s;
    }

    public static void main(String[] args) {
        LLStack<String> myStack = new LLStack<String>();
        // myStack.push("Hello");
        myStack.push("there");
        myStack.push("programming");
        myStack.push("is");
        myStack.push("a");
        myStack.push("joy");
        for (String s : myStack) {
            System.out.println(s);
        }
    }

}