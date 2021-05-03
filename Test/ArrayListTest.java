import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.collection.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest
{
  private ArrayList<String> arrayList;

  @BeforeEach void setUp()
  {
    arrayList = new ArrayList<>();
  }

  @Test void addZero()
  {
    arrayList.add(null);
    assertNull(arrayList.get(0));
  }

  @Test void addOne()
  {
    arrayList.add("A");
    assertEquals(arrayList.get(0), "A");
  }

  @Test void addMany()
  {
    for (int i = 0; i < 20; i++)
    {
      arrayList.add("AAA");
    }
    assertEquals(arrayList.size(), 20);
  }

  @Test void addBoundsLow()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(-1, null));
  }

  @Test void addBoundsHigh()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(150, null));
  }

  @Test void addException()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(12, "A"));
  }

  @Test void setZero()
  {
    arrayList.add("A");
    arrayList.set(0, null);
    assertNull(arrayList.get(0));
  }

  @Test void setOne()
  {
    arrayList.add("A");
    arrayList.set(0, "B");
    assertEquals(arrayList.get(0), "B");
  }

  @Test void setMany()
  {
    ArrayList<String> b = new ArrayList<>();
    for (int i = 0; i < 20; i++)
    {
      arrayList.add("A");
      b.add("B");
    }
    for (int i = 0; i < 20; i++)
      arrayList.set(i, "B");
    assertEquals(arrayList.toString(), b.toString());
  }

  @Test void setBoundsLow()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(-1, "A"));
  }

  @Test void setBoundsHigh()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(50, "A"));
  }

  @Test void setException()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(0, "A"));
  }

  @Test void removeZero()
  {
    arrayList.add(null);
    assertNull(arrayList.remove(0));
  }

  @Test void removeOne()
  {
    arrayList.add("A");
    assertEquals("A", arrayList.remove("A"));
  }

  @Test void removeMany()
  {
    for (int i = 0; i < 20; i++)
    {
      arrayList.add("A");
    }
    for (int i = 0; i < 10; i++)
    {
      arrayList.remove(0);
    }
    assertEquals(arrayList.size(), 10);
  }

  @Test void removeBoundsHigh()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(20));
  }

  @Test void removeBoundsLow()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(-1));
  }

  @Test void removeException()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(0));
  }

  @Test void indexOfZero()
  {
    arrayList.add(null);
    assertThrows(NullPointerException.class, () -> arrayList.indexOf(null));
  }

  @Test void indexOfOne()
  {
    arrayList.add("A");
    assertEquals(0, arrayList.indexOf("A"));
  }

  @Test void indexOfMany()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    assertEquals(1, arrayList.indexOf("B"));
  }

  @Test void indexOfBounds()
  {
    assertEquals(-1, arrayList.indexOf("A"));
  }

  @Test void indexOfException()
  {

  }

  @Test void containsZero()
  {
    assertFalse(arrayList.contains(null));
  }

  @Test void containsOneTrue()
  {
    arrayList.add("A");
    assertTrue(arrayList.contains("A"));
  }

  @Test void containsOneFalse()
  {
    arrayList.add("A");
    assertFalse(arrayList.contains("B"));
  }

  @Test void containsMany()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    assertTrue(arrayList.contains("B"));
  }

  @Test void containsBounds()
  {
    assertFalse(arrayList.contains("A"));
  }

  @Test void containsException()
  {

  }

  @Test void isEmptyZero()
  {
    assertTrue(arrayList.isEmpty());
  }

  @Test void isEmptyOne()
  {
    arrayList.add("A");
    assertFalse(arrayList.isEmpty());
  }

  @Test void isEmptyMultiple()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    assertFalse(arrayList.isEmpty());
  }

  @Test void isEmptyBounds()
  {

  }

  @Test void isEmptyException()
  {

  }

  @Test void isFullZero()
  {
    assertFalse(arrayList.isFull());
  }

  @Test void isFullOne()
  {
    arrayList.add("A");
    assertFalse(arrayList.isFull());
  }

  @Test void isFullMany()
  {
    for (int i = 0; i < 16; i++)
      arrayList.add("A");
    assertTrue(arrayList.isFull());
  }

  @Test void isFullBounds()
  {

  }

  @Test void isFullException()
  {

  }

  @Test void sizeZero()
  {
    assertEquals(arrayList.size(),0);
  }

  @Test void sizeOne()
  {
    arrayList.add("A");
    assertEquals(1,arrayList.size());
  }

  @Test void sizeMany()
  {
    for (int i=0;i<100;i++)
      arrayList.add("A");
    assertEquals(100,arrayList.size());
  }

  @Test void sizeBounds()
  {

  }

  @Test void sizeException()
  {

  }

  @Test void toStringZero()
  {
    assertEquals(arrayList.toString(),"{}");
  }

  @Test void toStringOne()
  {
    arrayList.add("A");
    assertEquals(arrayList.toString(),"{A}");
  }

  @Test void toStringMany()
  {
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    assertEquals("{A, B, C}", arrayList.toString());
  }

  @Test void toStringBounds()
  {

  }

  @Test void toStringException()
  {

  }
}
