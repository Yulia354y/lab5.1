// Клас Population, що реалізує Reportable для звітів про населення
// Оновлення класу Population для використання виключення
class Population extends DataInput implements Reportable {
    private int totalPopulation; // Загальна кількість населення
    private int urbanPopulation; // Кількість міського населення
    private double area;         // Площа країни

    @Override
    public void input() {
        System.out.print("Введіть загальну кількість населення: ");
        this.totalPopulation = scanner.nextInt();
        System.out.print("Введіть кількість міського населення: ");
        this.urbanPopulation = scanner.nextInt();
        System.out.print("Введіть площу країни (кв. км): ");
        this.area = scanner.nextDouble();

        try {
            validateData();
        } catch (CustomException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private void validateData() throws CustomException {
        if (totalPopulation < 0 || urbanPopulation < 0 || area <= 0) {
            throw new CustomException("Дані про населення або площу мають бути додатними.");
        }
        if (urbanPopulation > totalPopulation) {
            throw new CustomException("Кількість міського населення не може перевищувати загальну кількість населення.");
        }
    }

    public double calculateDensity() {
        return totalPopulation / area;
    }

    public void updatePopulation() {
        System.out.print("Введіть кількість народжених: ");
        int born = scanner.nextInt();
        System.out.print("Введіть кількість померлих: ");
        int died = scanner.nextInt();

        try {
            if (born < 0 || died < 0) {
                throw new CustomException("Кількість народжених або померлих не може бути від'ємною.");
            }
            totalPopulation += born - died;
            System.out.println("Оновлена кількість населення: " + totalPopulation);
        } catch (CustomException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
    @Override
    public void displayReport() {
        System.out.println("Загальна кількість населення: " + totalPopulation);
        System.out.println("Кількість міського населення: " + urbanPopulation);
        System.out.println("Густота населення: " + calculateDensity() + " осіб/кв. км");
    }
}