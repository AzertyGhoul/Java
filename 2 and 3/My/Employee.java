package My;

/**
 * Этот класс представляет работника
 */

public class Employee {

    /** Поле для хранения ФИО работника */
    private String fullName;

    /** Поле для хранения возраста работник */
    private int age;

    /** Поле для хранения должности работника */
    private String position;

    /**
     * Устанавливает значение поля {@link Employee#fullName}
     * 
     * @param fullName - ФИО работника
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Устанавливает значение поля {@link Employee#age}
     * 
     * @param age - Возраст работника
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Устанавливает значение поля {@link Employee#position}
     * 
     * @param position - Должность работника
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Возвращает значения поля {@link Employee#fullName}
     * 
     * @return строка с ФИО работника
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Возвращает значения поля {@link Employee#age}
     * 
     * @return целое значение возраста работника
     */
    public int getAge() {
        return age;
    }

    /**
     * Возвращает значения поля {@link Employee#position}
     * 
     * @return строка с должностью работника
     */
    public String getPosition() {
        return position;
    }

    /**
     * Создает работника с пустыми значениями
     */
    public Employee() {
        fullName = "Нет данных";
        age = 0;
        position = "Нет данных";
    }

    /**
     * Создает работника с заданными значениями
     * 
     * @param fullName - Фио работника
     * @param age      - Возраст работника
     * @param position - Должность работника
     */
    public Employee(String fullName, int age, String position) {
        this.fullName = fullName;
        this.age = age;
        this.position = position;
    }

}