import utility.collection.ArrayList;
import utility.collection.ListADT;

public interface TreasureRoomDoor {
    void addValuable(Valuable valuable);
    Valuable retrieve();
    Valuable lookAtValuable();
    ListADT getValuables();
    int count();
    void acquireRead();
    void acquireWrite();
    void releaseRead();
    void releaseWrite();


}
