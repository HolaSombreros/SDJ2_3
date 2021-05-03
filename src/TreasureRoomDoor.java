public interface TreasureRoomDoor {

    void addValuable(Valuable valuable);
    Valuable retrieve(String name);
    Valuable lookAtValuable(String name);
    void acquireRead();
    void acquireWrite();
    void releaseRead();
    void releaseWrite();


}
