import java.util.concurrent.ThreadLocalRandom;

public class Accountant implements Runnable {
    private TreasureRoomDoor door;
    
    public Accountant(TreasureRoomDoor door) {
        this.door = door;
    }
    
    @Override
    public void run() {
        while (true) {
            door.acquireRead();
            int total = door.count();
            sleep();
            Log.getInstance().addLog(Thread.currentThread().getName() + " counted the sum of the worth of all valuables in the treasury to $" + total);
            
            door.releaseRead();
            sleep();
        }
    }
    
    private void sleep() {
        int period = ThreadLocalRandom.current().nextInt(7000, 9000);
        try{
            Thread.sleep(period);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
