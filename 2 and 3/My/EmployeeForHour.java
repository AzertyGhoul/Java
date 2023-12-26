package My;

/**
 * Этот класс представляет собой сотрудника, который оплачивается почасово.
 * Он наследует класс Employee.
 */
public class EmployeeForHour extends Employee {
    private int Bid;

    /**
     * Устанавливает почасовую ставку для сотрудника.
     *
     * @param Bid Почасовая ставка для установки
     */
    public void setBid(int Bid) {
        this.Bid = Bid;
    }

    /**
     * Возвращает почасовую ставку для сотрудника.
     *
     * @return Почасовую ставку
     */
    public int getBid() {
        return Bid;
    }

    /**
     * Конструктор по умолчанию.
     * Создает сотрудника с пустыми значениями.
     */
    public EmployeeForHour() {
        super();
        Bid = 0;
    }

    /**
     * Конструктор с параметрами.
     * Создает сотрудника с заданными значениями.
     *
     * @param fullName Полное имя сотрудника
     * @param age      Возраст сотрудника
     * @param position Должность сотрудника
     * @param Bid      Почасовая ставка сотрудника
     */
    public EmployeeForHour(String fullName, int age, String position, int Bid) {
        super(fullName, age, position);
        this.Bid = Bid;
    }

    /**
     * Возвращает строковое представление сотрудника.
     *
     * @return Строковое представление сотрудника
     */
    public String toString() {
        return "\nФИО : " + getFullName() + "\nВозраст : " + getAge() + "\nДолжность : " + getPosition() + "\nСтавка : "
                + Bid + "\n";
    }
}