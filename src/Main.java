import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataManager manager = new DataManager();

        try {
            Economy economy = new Economy();
            economy.input();
            manager.addData(economy);

            Geography geography = new Geography();
            geography.input();
            manager.addData(geography);

            Population population = new Population();
            population.input();
            manager.addData(population);

            System.out.println("Звіти:");
            manager.displayAllReports();
        } catch (Exception e) {
            System.out.println("Несподівана помилка: " + e.getMessage());
        }

        System.out.println("Програма завершена.");
    }
}
