
import controller.Manager;
import reponsitory.List;

public class Main {
    public static void main(String[] args) {
        String title ="MENU";
        String []mc = {"Add worker", "Increase salary for worker"," Decrease for worker", " Show adjusted salary worker information","exit"};
        Manager  m = new Manager(title, mc);
        m.run();
    }
}
