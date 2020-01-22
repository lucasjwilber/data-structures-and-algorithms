package utilities;

public class Dog {
    Dog next;
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

    String name = names[random];
}
