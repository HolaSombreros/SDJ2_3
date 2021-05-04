import utility.collection.QueueADT;

public class Main {

    public static void main(String[] args) {

        QueueADT<Valuable> deposit = new Deposit<>();
        Mine mine = new Mine();
        Miner miner = new Miner(mine, deposit);
        TreasureRoomDoor treasureRoomDoor = new Guardsman();
        Transporter transporter = new Transporter(deposit, treasureRoomDoor);
        for(int i =0; i < 1; i++)
        new Thread(miner, "Miner " + (i+1)).start();
        for(int i =0; i < 1; i++)
            new Thread(transporter, "Transporter " + (i+1)).start();
        King king = new King(treasureRoomDoor);
        new Thread(king, "King").start();
        Accountant accountant = new Accountant(treasureRoomDoor);
        new Thread(accountant, "Accountant").start();
    }
}
