package All;

public class testGarage {
    public static void main(String[] args) {
        GarageCar myGarage = new GarageCar(); // создаем новый гараж

        Car myCar1 = new Car("Ford", 200, "A446MO186", "Mustang", 2, false); // создаем легковую машину
        myGarage.addCar(myCar1); // добавляем ее в гараж

        myGarage.addCar(new Car("LADA", 140, "Т158УХ086", "Kalina", 4, false));// добавляем еще одну машину
        Truck myTruck = new Truck("Dove", 160, "P123ZX193", "DTS", 700, true);// создаем грузовик
        myGarage.addCar(myTruck); // добавляем его в гараж

        myGarage.printGarage(); // выводи на экран содержимое гаража
        myGarage.deleteCar(myCar1);
        myGarage.printGarage();
    }
}
