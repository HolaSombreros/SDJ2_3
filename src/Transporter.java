import utility.collection.ArrayList;
import utility.collection.ListADT;
import utility.collection.QueueADT;

import java.util.concurrent.ThreadLocalRandom;

public class Transporter implements Runnable {

    private QueueADT<Valuable> deposit;
    private TreasureRoomDoor treasureRoomDoor;

    public Transporter(QueueADT<Valuable> deposit, TreasureRoomDoor door){
        this.deposit = deposit;
        this.treasureRoomDoor = door;
    }

    @Override
    public void run() {
        while(true){
            int val = (int)(Math.random()*(200-50)+50);
            int total = 0;
            ListADT<Valuable> valuables = new ArrayList<>();
            while (total<val) {
                Valuable valuable = deposit.dequeue();
                total += valuable.getWorth();
                valuables.add(valuable);
            }
            sleep();
            treasureRoomDoor.acquireWrite();
            while (!valuables.isEmpty()) {
                treasureRoomDoor.addValuable(valuables.get(0));
                valuables.remove(0);
            }
            Log.getInstance().addLog(Thread.currentThread().getName() + " has transported the valuables of total: $" + total);
            treasureRoomDoor.releaseWrite();
            sleep();
        }
    }
    
    private void sleep(){
        int period = ThreadLocalRandom.current().nextInt(3000, 5000);
        try{
            Thread.sleep(period);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
