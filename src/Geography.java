import java.util.Scanner;
public class Geography extends DataInput implements Reportable {
    private double totalArea;  // Загальна площа
    private double landArea;   // Площа суші

    @Override
    public void input() {
        System.out.print("Введіть загальну площу країни (кв. км): ");
        this.totalArea = scanner.nextDouble();
        System.out.print("Введіть площу суші країни (кв. км): ");
        this.landArea = scanner.nextDouble();
    }

    public double calculateLandPercentage() {
        return (landArea / totalArea) * 100;
    }

    public double calculateWaterToLandRatio() {
        double waterArea = totalArea - landArea;
        return waterArea / landArea;
    }

    @Override
    public void displayReport() {
        System.out.println("Відсоток суші: " + calculateLandPercentage() + "%");
        System.out.println("Відношення води до суші: " + calculateWaterToLandRatio());
    }

    public void input(Scanner scanner) {
    }
}