package Requests;

public class AddAnimalRequest extends Request {
    private String animalName;

    public AddAnimalRequest(String animalName) {
        this.animalName = animalName;
    }
}
