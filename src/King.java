import utility.collection.ArrayList;
import utility.collection.ListADT;

import java.util.concurrent.ThreadLocalRandom;

public class King implements Runnable {
    private TreasureRoomDoor door;
    
    public King(TreasureRoomDoor door) {
        this.door = door;
    }
    
    @Override
    public void run() {
        while (true) {
            int randomAmount = getRandomNumber(50, 150);
            int total = 0;
            door.acquireWrite();
            
            ListADT<Valuable> valuables = new ArrayList<>();
            for (int i = 0; i < door.getValuables().size(); i++) {
                Valuable valuable = (Valuable) door.getValuables().get(i);
                total += valuable.getWorth();
                valuables.add(door.retrieve());
                if (total >= randomAmount) {
                    break;
                }
            }
            if (total < randomAmount) {
                Log.getInstance().addLog(Thread.currentThread().getName() + " did not collect enough valuables to throw a party...");
                for (int i = 0; i < valuables.size(); i++) {
                    door.addValuable(valuables.get(i));
                }
            }
            else {
                Log.getInstance().addLog(Thread.currentThread().getName() + " is throwing a party!");
            }
            
            door.releaseWrite();
            sleep();
        }
    }
    
    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * max - min) + min;
    }
    
    private void sleep() {
        int period = ThreadLocalRandom.current().nextInt(8000, 12000);
        try{
            Thread.sleep(period);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
