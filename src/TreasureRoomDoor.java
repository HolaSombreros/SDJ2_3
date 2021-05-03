import utility.collection.ArrayList;

public interface TreasureRoomDoor {



    void addValuable(Valuable valuable);
    Valuable retrieve();
    Valuable lookAtValuable();
    int count();
    void acquireRead();
    void acquireWrite();
    void releaseRead();
    void releaseWrite();


}
