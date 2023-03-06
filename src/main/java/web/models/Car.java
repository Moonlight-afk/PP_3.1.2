package web.models;

public class Car {
    private int id;
    private String model;
    private String number;

    public Car(int id, String model, String number) {
        this.id = id;
        this.model = model;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
