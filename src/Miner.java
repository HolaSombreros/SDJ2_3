import utility.collection.QueueADT;

import java.util.concurrent.ThreadLocalRandom;

public class Miner implements Runnable
{
    private QueueADT<Valuable> deposit;
    private Mine mine;

    public Miner(Mine mine, QueueADT<Valuable> deposit){
        this.mine = mine;
        this.deposit = deposit;
    }
 
    @Override
    public void run() {
        while(true){
            Valuable valuable = mine.getRandomValuable();
            Log.getInstance().addLog(Thread.currentThread().getName() + " has acquired a " + valuable.getName() + " worth $" + valuable.getWorth());
            deposit.enqueue(valuable);
            Log.getInstance().addLog(Thread.currentThread().getName() + " put a " + valuable.getName() + " worth $" + valuable.getWorth() + " into the deposit");
            sleep();
        }
    }
    
    private void sleep() {
        int period = ThreadLocalRandom.current().nextInt(3000, 5000);
        try{
            Thread.sleep(period);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
