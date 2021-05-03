import utility.collection.ArrayList;
import utility.collection.ListADT;

public class King implements Runnable {
    private TreasureRoomDoor door;
    
    public King(TreasureRoomDoor door) {
        this.door = door;
    }
    
    @Override
    public void run() {
        while (true) {
            int random = getRandomNumber(50, 150);
            int total = 0;
            door.acquireWrite();
            ListADT<Valuable> valuables = new ArrayList<>();
            for (Valuable valuable : door.getValuables()) {
                total += valuable.getWorth();
                valuables.add(door.retrieve());
                if (total >= random) {
                    break;
                }
            }
            if (total < random) {
                System.out.println("The King did not collect enough valuables to throw a party...");
                for (Valuable valuable : valuables) {
                    door.addValuable(valuable);
                }
            }
            else {
                System.out.println("The King is throwing a party!");
            }
            door.releaseWrite();
            sleep(10);
        }
    }
    
    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e) {
            //
        }
    }
    
    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * max - min) + min;
    }
}
