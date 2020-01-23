package utilities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalShelterTest {
    AnimalShelter as;
    @Before public void setUp() {
        as = new AnimalShelter();
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        as.enqueue(cat1);
        as.enqueue(dog1);
        as.enqueue(cat2);
        as.enqueue(cat3);
        as.enqueue(dog2);
        as.enqueue(dog3);
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
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        as.enqueue(cat1);
        as.enqueue(cat2);
        as.enqueue(cat3);

        assertNotNull(as.frontCat.next.next);
        assertNull(as.frontCat.next.next.next);
    }
    @Test public void AS_canEnqueueDogs() {
        AnimalShelter as = new AnimalShelter();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        as.enqueue(dog1);
        as.enqueue(dog2);
        as.enqueue(dog3);

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
        as = new AnimalShelter();
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        as.enqueue(cat1);
        as.enqueue(dog1);
        as.enqueue(cat2);
        as.enqueue(cat3);
        as.enqueue(dog2);
        as.enqueue(dog3);

        assertEquals(cat1, as.dequeue("cat"));
        assertEquals(dog1, as.dequeue("dog"));
        assertEquals(cat2, as.dequeue("cat"));
        assertEquals(dog2, as.dequeue("dog"));
        assertEquals(cat3, as.dequeue("cat"));
        assertEquals(dog3, as.dequeue("dog"));
    }
}
