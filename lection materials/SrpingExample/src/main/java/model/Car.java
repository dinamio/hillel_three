package model;

/**
 * Created by eugen on 12/12/18.
 */
public class Car {

    private String number;

    private Model model;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", model=" + model +
                '}';
    }
}
