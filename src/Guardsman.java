
import utility.collection.ListADT;

public class Guardsman implements TreasureRoomDoor {

  private TreasureRoom treasureRoom;

  public Guardsman()
  {
    treasureRoom = new TreasureRoom();
  }

  @Override public void addValuable(Valuable valuable)
  {
    treasureRoom.addValuable(valuable);
  }

  @Override public Valuable retrieve()
  {
    return treasureRoom.retrieve();
  }

  @Override public Valuable lookAtValuable()
  {
    return treasureRoom.lookAtValuable();
  }

  @Override public ListADT<Valuable> getValuables()
  {
    return treasureRoom.getValuables();
  }

  @Override public int count()
  {
    return treasureRoom.count();
  }

  @Override public void acquireRead()
  {
    treasureRoom.acquireRead();
  }

  @Override public void acquireWrite()
  {
    treasureRoom.acquireWrite();
  }

  @Override public void releaseRead()
  {
    treasureRoom.releaseRead();
  }

  @Override public void releaseWrite()
  {
    treasureRoom.releaseWrite();
  }
}
