package utilities;

import org.checkerframework.checker.units.qual.A;

public class AnimalShelter {
    Cat frontCat;
    Cat rearCat;
    Dog frontDog;
    Dog rearDog;

    public static String getRandomName() {
        String[] names = new String[]{
                "Max",
                "Sparky",
                "Sam",
                "Lil Fluff",
                "Frodo",
                "Poppy",
                "Bella",
                "Alfie",
                "Molly",
                "Ginger",
                "Rosie",
                "Teddy",
                "Pumba",
                "Lola",
                "Tilly",
                "Coco",
                "Daisy",
        };
        int random = (int) Math.floor(Math.random() * names.length);
        return names[random];
    }

    public void enqueue(String animal) {
        if (animal.toLowerCase().equals("cat")) {
            Cat newCat = new Cat(getRandomName());
            if (rearCat != null) {
                this.rearCat.next = newCat;
            }
            this.rearCat = newCat;
            if (this.frontCat == null) {
                this.frontCat = newCat;
            }
        }
        if (animal.toLowerCase().equals("dog")) {
            Dog newDog = new Dog(getRandomName());
            if (rearDog != null) {
                this.rearDog.next = newDog;
            }
            this.rearDog = newDog;
            if (this.frontDog == null) {
                this.frontDog = newDog;
            }
        }
    }

    public String dequeue(String pref) throws NullPointerException {
        if (pref.toLowerCase().equals("cat")) {
            if (frontCat == null) {
                throw new NullPointerException("There are no cats available.");
            }
            Cat tempCat = frontCat;
            frontCat = frontCat.next;
            return tempCat.name;
        } else if (pref.toLowerCase().equals("dog")) {
            if (frontDog == null) {
                throw new NullPointerException("There are no dogs available.");
            }
            Dog tempDog = frontDog;
            frontDog = frontDog.next;
            return tempDog.name;
        } else return null;
    }

}
