package familytree;

import ui.*;
import graph.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Family family = initializeFamily();
        UserInterface UI = new UserInterface(new ConsoleIO(), family);
        UI.start();
    }

    public static Family initializeFamily() {
        Family family = new Family();

        Person mari = new Person("Mari");
        Person ales = new Person("Ales");
        Person marija = new Person("Marija");
        Person joze = new Person("Joze");

        family.addPerson(mari);
        family.addPerson(ales);
        family.addPerson(marija);
        family.addRelation(mari, ales);
        family.addParentChild(marija, ales);
        family.addPerson(joze);
        family.addRelation(marija, joze);
        family.addParentChild(joze, ales);

        return family;
    }
}