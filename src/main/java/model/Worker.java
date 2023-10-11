
package model;


public class Worker {
    public String ID;
    public String name;
    public int age;
    public int salary;
    public String worklocation;

    public Worker() {
    }

    public Worker(String ID, String name, int age, int salary, String worklocation) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.worklocation = worklocation;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorklocation() {
        return worklocation;
    }

    public void setWorklocation(String worklocation) {
        this.worklocation = worklocation;
    }

    @Override
    public String toString() {
        return   "ID: " + ID + ", name: " + name + ", age:" + age + ", salary:" + salary + ", worklocation:" + worklocation + '}';
    }
    
}
