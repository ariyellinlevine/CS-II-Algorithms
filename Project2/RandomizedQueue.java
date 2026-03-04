package Project2;

import java.util.Iterator;

public class RandomizedQueue implements Iterable<Integer> {

    private int amount = 0;
    private int[] arr = new int[8];

    public boolean isEmpty() {
        return amount == 0;
    }

    public int size() {
        return amount;
    }

    public void add(int item) {
        if (amount == arr.length) {
            int[] newArr = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[amount] = item;
        amount++;
    }

    public int sample() {
        return arr[(int) Math.ceil(Math.random() * amount) - 1];
    }

    public int remove() {

        if (amount <= arr.length / 4) {
            int[] newArr = new int[arr.length / 2];

            for (int i = 0; i < amount; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
        }

        int index = (int) Math.ceil(Math.random() * amount) - 1;
        int toRemove = arr[index];
        arr[index] = arr[amount - 1];
        amount--;
        return toRemove;
    }

    // public int[] iterate() {
    // int[] randomArr = new int[amount];
    // RandomizedQueue newArr = new RandomizedQueue();
    // for (int i = 0; i < amount; i++) {
    // newArr.arr[i] = arr[i];
    // }
    // for (int i = 0; i < amount; i++) {
    // randomArr[i] = newArr.remove();
    // }
    // return randomArr;
    // }

    private class RandomizedQueueIter implements Iterator<Integer> {

        RandomizedQueue newArr;

        public RandomizedQueueIter() {
            newArr = new RandomizedQueue();
            for (int i = 0; i < amount; i++) {
                newArr.add(arr[i]);

            }
        }

        public boolean hasNext() {
            return !newArr.isEmpty();
        }

        public Integer next() {
            return newArr.remove();
        }
    }

    public Iterator<Integer> iterator() {
        return new RandomizedQueueIter();
    }

    public String toString() {
        String s = "";

        int counter = 0;
        for (int i : this) {
            s += String.format("Index: %d; Value: %d \n", counter, i);
            counter++;
        }
        return s;
    }

    public static void main(String[] args) {
        RandomizedQueue randQ = new RandomizedQueue();
        randQ.add(932);
        randQ.add(26);
        randQ.add(73);

        for (int i : randQ) {
            System.out.println(String.format("Value: %d", i));
        }
        System.out.println("______");

        for (int i : randQ) {
            System.out.println(String.format("Value: %d", i));
        }
        System.out.println("______");

        for (int i : randQ) {
            System.out.println(String.format("Value: %d", i));
        }
        System.out.println("______");

    }

}
