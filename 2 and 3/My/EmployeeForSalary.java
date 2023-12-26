package My;

/**
 * Этот класс представляет собой сотрудника, который получает фиксированную
 * зарплату.
 * Он наследует класс Employee.
 */
public class EmployeeForSalary extends Employee {
    private int salary;

    /**
     * Устанавливает зарплату для сотрудника.
     *
     * @param salary Зарплата для установки
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Возвращает зарплату сотрудника.
     *
     * @return зарплата
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Конструктор по умолчанию.
     * Создает сотрудника с пустыми значениями.
     */
    public EmployeeForSalary() {
        super();
        salary = 0;
    }

    /**
     * Конструктор с параметрами.
     * Создает сотрудника с заданными значениями.
     *
     * @param fullName Полное имя сотрудника
     * @param age      Возраст сотрудника
     * @param position Должность сотрудника
     * @param salary   Зарплата сотрудника
     */
    public EmployeeForSalary(String fullName, int age, String position, int salary) {
        super(fullName, age, position);
        this.salary = salary;
    }

    /**
     * Возвращает строковое представление сотрудника.
     *
     * @return Строковое представление сотрудника
     */
    public String toString() {
        return "\nФИО : " + getFullName() + "\nВозраст : " + getAge() + "\nДолжность : " + getPosition() + "\nОклад : "
                + salary + "\n";
    }
}
