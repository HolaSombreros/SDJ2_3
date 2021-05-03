public class Mine {
    public static final String[] VALUABLES = {
        "Gold",
        "Diamond",
        "Emerald",
        "Crystal",
        "Bitcoin",
        "Dogecoin",
        "Ruby",
        "Sapphire",
        "Topaz",
        "Amethyst",
        "Jade",
        "Coal"
    };
    
    public Valuable getRandomValuable() {
        int random = getRandomIndex();
        return Valuable.getInstance(VALUABLES[random]);
    }
    
    private int getRandomIndex() {
        return (int) (Math.random() * VALUABLES.length);
    }
}
