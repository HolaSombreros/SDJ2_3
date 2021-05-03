import utility.collection.ArrayList;
import utility.collection.ListADT;
import utility.collection.QueueADT;

import java.util.concurrent.ThreadLocalRandom;

public class Transporter implements Runnable {

    private QueueADT<Valuable> list;
    private TreasureRoomDoor treasureRoomDoor;

    public Transporter(QueueADT<Valuable> list, TreasureRoomDoor door){
        this.list = list;
        this.treasureRoomDoor = door;
    }

    // TODO - check this method
    @Override
    public void run() {
        while(true){
            int val = (int)(Math.random()*(200-50));
            int total = 0;
            ListADT<Valuable> valuables = new ArrayList<>();
            for (int i = 0; i < list.size(); i++){
                Valuable valuable = list.first();
                total += valuable.getWorth();
                list.dequeue();
                Log.getInstance().addLog("Transporter has transported the valuables");
                period();
            }
        }
    }
    
    private void period(){
        int period = ThreadLocalRandom.current().nextInt(5000, 3000);
        try{
            Thread.sleep(period);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
