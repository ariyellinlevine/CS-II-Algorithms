public class Duo {

    private class Node {
        int item;
        Node next;

        public Node(int i) {
            this.item = i;
        }
    }

    Node current1;
    int size1 = 0;

    Node current2;
    int size2 = 0;

    public void addToList1(int x) {
        Node newNode = new Node(x);
        if (size1 != 0) {
            newNode.next = current1;
        }

        current1 = newNode;

        size1++;

    }

    public void addToList2(int x) {
        Node newNode = new Node(x);
        if (size2 != 0) {
            newNode.next = current2;
        }

        current2 = newNode;

        size2++;
    }

    public void deleteFromList1(int x) {
        if (current1.item == x) {
            current1 = current1.next;
        }
        Node pointer = current1;
        Node lastNode = null;

        for (int i = 0; i < size1; i++) {
            if (pointer.item != x) {
                lastNode = pointer;
                pointer = pointer.next;
                continue;
            }
            lastNode.next = pointer.next;
        }
    }

    public void deleteFromList2(int x) {
        if (current2.item == x) {
            current2 = current2.next;
        }
        Node pointer = current2;
        Node lastNode = null;

        for (int i = 0; i < size2; i++) {
            if (pointer.item != x) {
                lastNode = pointer;
                pointer = pointer.next;
                continue;
            }
            lastNode.next = pointer.next;
        }
    }

    public boolean hasDuplicate() {
        Node listOne = current1;
        Node listTwo = current2;
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                if (listOne.item == listTwo.item) {
                    return true;
                }
                listTwo = listTwo.next;
            }
            return false;
        }
    }
}
