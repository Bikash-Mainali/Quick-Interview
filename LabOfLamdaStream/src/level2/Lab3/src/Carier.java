package LabOfLamdaStream.src.level2.Lab3.src;

import java.util.ArrayList;
import java.util.List;

public abstract class Carier implements ICarier {
    public abstract String showCostDetails(Carier carier);

    List<Carier> cariers = new ArrayList<>();

    void arrangeCariers(Carier c) {
        cariers.add(c);
    }

    void displayCost() {
        cariers.stream()
                .forEach(c -> System.out.println(c.showCostDetails(c)));

        /*
        for (Carier carier : cariers) {
            System.out.println(carier.showCostDetails(carier));
        }

         */
    }
}
