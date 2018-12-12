package model;

/**
 * Created by eugen on 12/12/18.
 */
public class Model {

    private String name;

    private Integer numberOfDoors;

    public Model() {
    }

    public Model(String name, Integer numberOfDoors) {
        this.name = name;
        this.numberOfDoors = numberOfDoors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }
}
