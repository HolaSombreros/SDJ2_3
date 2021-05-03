import utility.collection.ArrayList;

public interface TreasureRoomDoor {



    void addValuable(Valuable valuable);
    Valuable retrieve();
    Valuable lookAtValuable();
    ArrayList getValuables();
    int count();
    void acquireRead();
    void acquireWrite();
    void releaseRead();
    void releaseWrite();


}
