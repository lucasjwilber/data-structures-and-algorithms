package utilities;

import org.checkerframework.checker.units.qual.A;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalShelterTest {
    AnimalShelter as;
    @Before public void setUp() {
        as = new AnimalShelter();
        as.enqueue("cat");
        as.enqueue("dog");
        as.enqueue("cat");
        as.enqueue("cat");
        as.enqueue("dog");
        as.enqueue("dog");
    }

    @Test public void AS_testConstructor() {
        AnimalShelter as = new AnimalShelter();
        assertNull(as.frontCat);
        assertNull(as.rearCat);
        assertNull(as.frontDog);
        assertNull(as.rearDog);
    }

    @Test public void AS_canEnqueueCats() {
        AnimalShelter as = new AnimalShelter();
        as.enqueue("cat");
        as.enqueue("cat");
        as.enqueue("cat");

        assertNotNull(as.frontCat.next.next);
        assertNull(as.frontCat.next.next.next);
    }
    @Test public void AS_canEnqueueDogs() {
        AnimalShelter as = new AnimalShelter();
        as.enqueue("dog");
        as.enqueue("dog");
        as.enqueue("dog");

        assertNotNull(as.frontDog.next.next);
        assertNull(as.frontDog.next.next.next);
    }
    @Test public void AS_canDequeueCats() {
        assertNotNull(as.dequeue("cat"));
    }
    @Test public void AS_canDequeueDogs() {
        assertNotNull(as.dequeue("dog"));
    }
    @Test(expected = NullPointerException.class) public void AS_cantDequeueEmptyQueue() {
        AnimalShelter as = new AnimalShelter();
        as.dequeue("cat");
    }
    @Test public void AS_dequeueArgNotDogOrCatReturnsNull() {
        assertNull(as.dequeue("alligator"));
    }
    @Test public void AS_dequeueIsFIFO() {
        AnimalShelter as = new AnimalShelter();
        as.enqueue("cat");
        String firstCatName = as.frontCat.name;
        as.enqueue("dog");
        String firstDogName = as.frontDog.name;
        as.enqueue("cat");
        as.enqueue("cat");
        as.enqueue("dog");
        as.enqueue("cat");
    }
}
