package stringbasic.pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {

    private List<Pet> petRegistry = new ArrayList<>();

    public List<Pet> getPets() {
        return petRegistry;
    }

    private boolean areEquals(Pet pet1, Pet pet2) {
       return pet1.getRegNumber().equals(pet2.getRegNumber());
    }

    public void add(Pet pet) {
        for (Pet p : petRegistry) {
            if (areEquals(pet, p)) {
                return;
            }
        }
        petRegistry.add(pet);
    }
}
