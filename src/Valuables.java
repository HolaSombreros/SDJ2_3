import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Valuables {
    private ArrayList<String> valuables;
    private static Map<String,Valuables> map = new HashMap<>();
    private String key;

    private Valuables(String key){
        valuables = new ArrayList<>();
        this.key = key;
    }

    public static Valuables getInstance(String key){
        Valuables instance = map.get(key);
        if(instance == null){
            synchronized (map){
                instance = map.get(key);
                if(instance == null){
                    instance = new Valuables(key);
                    map.put(key,instance);
                }
            }
        }
        return instance;
    }

    public void addValuable(String text){
        valuables.add(text);
    }
}
