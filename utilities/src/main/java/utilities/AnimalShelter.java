package utilities;

@SuppressWarnings("unchecked")
public class AnimalShelter<T> {
    Cat frontCat;
    Cat rearCat;
    Dog frontDog;
    Dog rearDog;

    public void enqueue(Cat cat) {
        if (rearCat != null) {
            this.rearCat.next = cat;
        }
        this.rearCat = cat;
        if (this.frontCat == null) {
            this.frontCat = cat;
        }
    }
    public void enqueue(Dog dog) {
        if (rearDog != null) {
            this.rearDog.next = dog;
        }
        this.rearDog = dog;
        if (this.frontDog == null) {
            this.frontDog = dog;
        }
    }

    public T dequeue(String pref) throws NullPointerException {
        if (pref.toLowerCase().equals("cat")) {
            if (frontCat == null) {
                throw new NullPointerException("There are no cats available.");
            }
            Cat tempCat = frontCat;
            frontCat = frontCat.next;
            return (T) tempCat;
        } else if (pref.toLowerCase().equals("dog")) {
            if (frontDog == null) {
                throw new NullPointerException("There are no dogs available.");
            }
            Dog tempDog = frontDog;
            frontDog = frontDog.next;
            return (T) tempDog;
        } else return null;
    }
}