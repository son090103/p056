
package model;


public class History extends Worker implements Comparable<History>{
    public String status;
    public String date;

    public History() {
    }

    public History(String status, String date, String ID, String name, int age, int salary, String worklocation) {
        super(ID, name, age, salary, worklocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return  "status: " + status + ", date: " + date;
    }

    @Override
    public int compareTo(History o) {
        return this.getID().compareTo(o.getID());
    }
}
