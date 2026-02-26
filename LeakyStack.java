public class LeakyStack {

    private class Node {
        String item;
        Node last;

        public Node(String item) {
            this.item = item;
        }
    }

    int size = 0;
    Node current;

    public LeakyStack() {

    }

    public void push(String item) {
        Node newNode = new Node(item);
        if (size != 0) {
            newNode.last = current;
        }

        current = newNode;
        size++;

    }

    public String pop() {
        Node toDelete = current;
        current = current.last;
        size--;
        return toDelete.item;
    }

    public void leak() {
        int index = (int) (Math.random() * size) - 1;

        if (index == 0) {
            current = current.last;
            return;
        }

        Node pointer = current;
        Node previousNode = null;

        for (int i = 0; i < size; i++) {
            if (i != index) {
                previousNode = pointer;
                pointer = current.last;
                continue;
            }

            previousNode.last = pointer.last;
            return;
        }
    }
}
