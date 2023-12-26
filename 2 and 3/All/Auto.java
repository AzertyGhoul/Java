package All;

public class Auto {
    private String firm; // создаем закрытый член нашего класса с названием фирмы автомобиля
    private int maxSpeed; // закрытый член класса, содержащий максимальную скорость
    private String gosNumber;

    public void setFirm(String firma) { // открытая функция (метод класса) для задания
        firm = firma; // значения фирмы автомобиля
    }

    public void setMaxSpeed(int maxSpeed) { // открытая функция (метод класса) для задания
        this.maxSpeed = maxSpeed; // значения максимальной скорости автомобиля
    }

    public void setGosNumber(String gosNumber) {
        this.gosNumber = gosNumber;
    }

    public int getMaxSpeed() { // открытая функция (метод класса) для вывода значения
        return maxSpeed; // максимальной скорости
    }

    public String getFirm() { // открытая функция (метод класса) для вывода значения
        return firm; // заданной фирмы
    }

    public String getGosNumber() {
        return gosNumber;
    }

    public Auto() { // конструктор класса (без параметров)
        firm = "Без названия";
        maxSpeed = 0;
        gosNumber = "0OOO00000";
    }

    public Auto(String firm, int maxSpeed, String gosNumber) { // конструктор класса (с параметрами)
        this.firm = firm;
        this.maxSpeed = maxSpeed;
        this.gosNumber = gosNumber;
    }
}
