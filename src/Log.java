import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Log {
    private static Log instance;
    private static Object lock = new Object();
    
    private Log() {
    }
    
    public static Log getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null)
                    instance = new Log();
            }
        }
        return instance;
    }
    
    public void addLog(String log) {
        System.out.println(log);
    }
}
