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
            sleep(2);
            Log.getInstance().addLog("Total sum of valuables in the treasury: " + total);
            door.releaseRead();
            sleep(5);
        }
    }
    
    private void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e) {
            //
        }
    }
}
