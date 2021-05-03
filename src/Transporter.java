import utility.collection.QueueADT;

import java.util.concurrent.ThreadLocalRandom;

public class Transporter implements Runnable {

    private QueueADT<Valuable> list;
    private TreasureRoomDoor treasureRoomDoor;

    public Transporter(QueueADT<Valuable> list){
        this.list = list;
        this.treasureRoomDoor = new Guardsman();
    }

    @Override
    public void run() {
        while(true){
            for(int i=0; i <(int)(Math.random()*(200-50));i++){
                //TODO: check step 2
                list.dequeue();
                period();
            }
        }
    }
    private void period(){
        int period = ThreadLocalRandom.current().nextInt(3000, 5000);
        try{
            Thread.sleep(period);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
