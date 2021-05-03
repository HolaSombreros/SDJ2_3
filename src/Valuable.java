import java.util.HashMap;
import java.util.Map;

public class Valuable {
    private int worth;
    private String name;
    private static final Map<String, Valuable> instances = new HashMap<>();
    
    private Valuable(String name) {
        this.name = name;
        switch (name) {
            case "Gold":
                this.worth = 25;
                break;
            case "Diamond":
                this.worth = 55;
                break;
            case "Emerald":
                this.worth = 35;
                break;
            case "Crystal":
                this.worth = 50;
                break;
            case "Bitcoin":
                this.worth = 75;
                break;
            case "Dogecoin":
                this.worth = 100;
                break;
            case "Ruby":
                this.worth = 30;
                break;
            case "Sapphire":
                this.worth = 5;
                break;
            case "Topaz":
                this.worth = 10;
                break;
            case "Amethyst":
                this.worth = 20;
                break;
            case "Jade":
                this.worth = 15;
                break;
            case "Coal":
                this.worth = 1;
                break;
        }
    }
    
    public static Valuable getInstance(String key) {
        Valuable instance = instances.get(key);
        if (instance == null) {
            synchronized (instances) {
                instance = instances.get(key);
                if (instance == null) {
                    instance = new Valuable(key);
                    instances.put(key, instance);
                }
            }
        }
        return instance;
    }
    
    public int getWorth() {
        return worth;
    }
    
    public String getName() {
        return name;
    }
}
