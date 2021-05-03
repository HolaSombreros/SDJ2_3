import utility.collection.ArrayList;

public class TreasureRoom implements TreasureRoomDoor {

    private ArrayList<Valuable> list;
    private int readers;
    private int writers;

    public TreasureRoom() {
        readers = 0;
        writers = 0;
        list = new ArrayList();
    }

    @Override
    public int count() {
       int sum = 0;
       for(int i = 0; i < list.size(); i++)
           sum += list.remove(i).getWorth();
       return sum;
    }

    @Override
    public ArrayList getValuables() {
        return list;
    }

    @Override
    public void addValuable(Valuable valuable) {
        list.add(valuable);
    }

    @Override
    public Valuable retrieve() {
        if(list.size() > 0)
            return list.remove(0);
        else
            return null;
    }

    @Override
    public Valuable lookAtValuable() {
        if(list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Override
    public synchronized void acquireRead() {
        while (writers > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readers++;
    }


    @Override
    public synchronized void acquireWrite() {
        while (readers > 0 || writers > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } writers++;
    }

    @Override
    public synchronized void releaseRead() {
        readers--;
        if (readers == 0)
            notify();
    }

    @Override
    public synchronized void releaseWrite() {
        writers--;
        notifyAll();
    }
}
