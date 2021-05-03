import utility.collection.ArrayList;
import utility.collection.ListADT;
import utility.collection.QueueADT;

public class Deposit<T> implements QueueADT<T>
{
    private ListADT<T> list;

    // TODO - modify this class
    public Deposit(){
        this.list = new ArrayList<>();
    }
    @Override
    public synchronized void enqueue(T element)
    {
        list.add(list.size(), element);
    }

    @Override
    public synchronized T dequeue()
    {
        return list.remove(0);
    }

    @Override
    public synchronized T first()
    {
        return list.get(0);
    }

    @Override
    public synchronized int indexOf(T element)
    {
        return list.indexOf(element);
    }

    @Override
    public synchronized boolean isEmpty()
    {
        return list.isEmpty();
    }

    @Override
    public synchronized boolean isFull()
    {
        return list.isFull();
    }

    @Override
    public synchronized int size()
    {
        return list.size();
    }

    @Override
    public synchronized int capacity()
    {
        return -1;
    }
    public synchronized String toString(){
        return list.toString();
    }
}
