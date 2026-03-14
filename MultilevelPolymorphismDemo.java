class Employee {
    protected String name;

    Employee(String name) {
        this.name = name;
    }

    void calculateSalary() {
        System.out.println("Base employee salary calculation");
    }

    void showRole() {
        System.out.println(name + " is an Employee");
    }
}

class Developer extends Employee {
    protected int bonus;

    Developer(String name, int bonus) {
        super(name);
        this.bonus = bonus;
    }

    @Override
    void calculateSalary() {
        System.out.println(name + "'s salary = 50000 + bonus " + bonus);
    }

    @Override
    void showRole() {
        System.out.println(name + " is a Developer");
    }
}

class SeniorDeveloper extends Developer {
    private int stockOptions;

    SeniorDeveloper(String name, int bonus, int stockOptions) {
        super(name, bonus);
        this.stockOptions = stockOptions;
    }

    @Override
    void calculateSalary() {
        int total = 50000 + bonus + stockOptions;
        System.out.println(name + "'s salary = 50000 + " + bonus + " + " + stockOptions + " = " + total);
    }

    @Override
    void showRole() {
        System.out.println(name + " is a Senior Developer");
    }
}

public class MultilevelPolymorphismDemo {
    public static void main(String[] args) {
        Employee e1 = new Developer("Rahul", 10000);
        Employee e2 = new SeniorDeveloper("Sahil", 15000, 20000);

        e1.showRole();
        e1.calculateSalary();

        System.out.println();

        e2.showRole();
        e2.calculateSalary();
    }
}
