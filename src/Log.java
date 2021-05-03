import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Log {
    private static Log instance;
    private static Object lock = new Object();
    private static ArrayList<String> logs = new ArrayList<>();
    private Log(){

    }

    public static Log getInstance(){
        if(instance == null){
            synchronized (lock){
                if(instance ==null)
                    instance = new Log();
            }
        }
        return instance;
    }

    public void addLog(String log){
        logs.add(log);
        addToFile(log);
    }

    private void addToFile(String log) {
        if (log == null) {
            return;
        }
        BufferedWriter out = null;
        try {
            String filename = "Log.txt";
            out = new BufferedWriter(new FileWriter(filename, true));
            out.write(log + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
