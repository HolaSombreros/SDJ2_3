import utility.collection.QueueADT;

import java.util.concurrent.ThreadLocalRandom;

public class Miner implements Runnable
{
    private QueueADT<Valuable> list;
    private Mine mine;

    public Miner(Mine mine, QueueADT<Valuable> deposit){
        this.mine = mine;
        this.list = deposit;
    }

    @Override
    public void run() {
        while(true){
            //Valuable valuable = mine.getRandomValuable();
//            list.enqueue(mine.getRandomValuable());
            Log.getInstance().addLog("Miner has acquired <valuable>");
            period();

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
