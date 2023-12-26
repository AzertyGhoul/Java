package All;

public class Truck extends Auto {
    private String model;
    private int power;
    private Boolean trailer; // c прицепом или без

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setTrailer(Boolean b) {
        trailer = b;
    }

    public String getModel() {
        return model;

    }

    public int getPower() {
        return power;
    }

    public Boolean isTrailer() {
        return trailer;
    }

    public String toString() {
        return "\nФирма: " + getFirm() + "\n" + "Максимальная скорость: "
                + getMaxSpeed() + "\nГос номер : " + getGosNumber() + "\n" + "Модель: " + model + "\n" + "Мощность: "
                + power + "\n"
                + "Признак прицепа: "
                + trailer + "\n";
    }

    public Truck() {
        super();
        model = "";
        power = 0;
        trailer = false;
    }

    public Truck(String firma, int speed, String gosNumber, String model, int power, Boolean trailer) {
        super(firma, speed, gosNumber);
        this.model = model;
        this.power = power;
        this.trailer = trailer;
    }

}