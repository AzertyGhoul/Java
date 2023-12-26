package All;

import java.util.ArrayList;

public class GarageCar {
    private ArrayList<Auto> masCar = new ArrayList<Auto>();// массив с машинами

    public void addCar(Auto car) {// метод для добавления машины в гараж
        masCar.add(car);
    }

    public void deleteCar(Auto car) {
        masCar.remove(car);
    }

    public Boolean findCar(Auto car) { // для выяснения – есть ли машина m в гараже
        return masCar.contains(car);
    }

    public GarageCar() {
    }

    public GarageCar(ArrayList<Auto> arrayOfCars) {// конструктор для внесения существующего списка машин
        masCar = arrayOfCars;
    }

    public void printGarage() { // для вывода на экран списка машин в гараже
        System.out.println("В гараже: ");
        for (Auto a : masCar) { //
            System.out.println("\t" + a.toString());
        }
    }

}
