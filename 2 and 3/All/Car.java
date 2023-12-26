package All;

public class Car extends Auto {
    private String model;
    private int numDoors;
    private Boolean fullTime; // полный привод

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public void setFullTime(Boolean fullTime) {
        this.fullTime = fullTime;
    }

    public String getModel() {
        return model;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public Boolean isFullTime() {
        return fullTime;
    }

    public String toString() {
        return "\nФирма : " + getFirm() + "\nМаксимальная скорость : " + getMaxSpeed() + "\nГос номер : "
                + getGosNumber() + "\nМодель : " + model + "\nКоличество дверей :" + numDoors + "\nПолный привод : "
                + fullTime + "\n";
    }

    public Car() {
        super();// вызываем конструктор класса-родителя без параметров (см. класс Auto)
        model = ""; // добавляем инициализацию новых членов
        numDoors = 4;
        fullTime = false;
    }

    public Car(String firma, int speed, String gosNumber, String model, int numDoors, Boolean fullTime) {
        super(firma, speed, gosNumber);// вызываем конструктор класса-родителя с параметрами (см. класс Auto)
        this.model = model; // добавляем инициализацию новых членов
        this.numDoors = numDoors;
        this.fullTime = fullTime;
    }
}
