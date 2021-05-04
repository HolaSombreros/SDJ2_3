import utility.collection.ArrayList;
import utility.collection.ListADT;
import utility.collection.QueueADT;

public class Deposit<T> implements QueueADT<T> {
    private ListADT<T> valuables;
    
    public Deposit() {
        this.valuables = new ArrayList<>();
    }
    
    private int sum() {
        int total = 0;
        for (int i = 0; i < valuables.size(); i++) {
            total += ((Valuable) (valuables.get(i))).getWorth();
        }
        return total;
    }
    
    @Override
    public synchronized void enqueue(T element) {
        notifyAll();
        valuables.add(element);
    }
    
    @Override
    public synchronized T dequeue() {
        while (size() <= 0) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                // empty
            }
        }
        notifyAll();
        return valuables.remove(0);
    }
    
    @Override
    public synchronized T first() {
        while (size() <= 0) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                // empty
            }
        }
        notifyAll();
        return valuables.get(0);
    }
    
    @Override
    public synchronized int indexOf(T element) {
        while (size() <= 0) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                // empty
            }
        }
        notifyAll();
        return valuables.indexOf(element);
    }
    
    @Override
    public synchronized boolean isEmpty() {
        return valuables.isEmpty();
    }
    
    @Override
    public synchronized boolean isFull() {
        return valuables.isFull();
    }
    
    @Override
    public synchronized int size() {
        return valuables.size();
    }
    
    @Override
    public synchronized int capacity() {
        return Integer.MAX_VALUE;
    }
    
    @Override
    public synchronized String toString() {
        return valuables.toString();
    }
}
