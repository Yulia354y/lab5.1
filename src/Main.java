
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Створюємо три об'єкти країн
        Country ukraine = new Country("Україна", "Київ", 41, 40.93);
        Country germany = new Country("Німеччина", "Берлін", 83, 0.94);
        Country japan = new Country("Японія", "Токіо", 125, 145.67);

        // Масив країн для доступу до них
        Country[] countries = {ukraine, germany, japan};

        // Меню для взаємодії
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--- Меню ---");
            System.out.println("1. Вивести інформацію про країну");
            System.out.println("2. Порівняти населення двох країн");
            System.out.println("3. Конвертувати валюту");
            System.out.println("4. Розрахунок інформації");
            System.out.println("5. Вийти");
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> selectAndDisplayCountry(countries, scanner);
                case 2 -> compareSelectedCountries(countries, scanner);
                case 3 -> convertCurrency(countries, scanner);
                case 4 -> runDataManager(scanner);
                case 5 -> {
                    System.out.println("Вихід із програми.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    // Метод для вибору країни і виведення інформації
    private static void selectAndDisplayCountry(Country[] countries, Scanner scanner) {
        System.out.println("Доступні країни:");
        for (int i = 0; i < countries.length; i++) {
            System.out.println((i + 1) + ". " + countries[i].getName());
        }
        System.out.print("Введіть номер країни: ");
        int countryChoice = scanner.nextInt();
        if (countryChoice >= 1 && countryChoice <= countries.length) {
            countries[countryChoice - 1].displayInfo();
        } else {
            System.out.println("Невірний вибір.");
        }
    }

    // Метод для порівняння двох країн
    private static void compareSelectedCountries(Country[] countries, Scanner scanner) {
        System.out.println("Оберіть першу країну для порівняння:");
        for (int i = 0; i < countries.length; i++) {
            System.out.println((i + 1) + ". " + countries[i].getName());
        }
        System.out.print("Введіть номер першої країни: ");
        int firstCountry = scanner.nextInt();

        System.out.println("Оберіть другу країну для порівняння:");
        for (int i = 0; i < countries.length; i++) {
            System.out.println((i + 1) + ". " + countries[i].getName());
        }
        System.out.print("Введіть номер другої країни: ");
        int secondCountry = scanner.nextInt();
        if (firstCountry >= 1 && firstCountry <= countries.length &&
                secondCountry >= 1 && secondCountry <= countries.length) {
            compareCountries(countries[firstCountry - 1], countries[secondCountry - 1]);
        } else {
            System.out.println("Невірний вибір.");
        }
    }

    // Метод для порівняння двох країн
    private static void compareCountries(Country country1, Country country2) {
        System.out.println("Порівняння країн:");
        System.out.println(country1.getName() + " має населення " + country1.getPopulation() + " мільйонів.");
        System.out.println(country2.getName() + " має населення " + country2.getPopulation() + " мільйонів.");
        if (country1.getPopulation() > country2.getPopulation()) {
            System.out.println(country1.getName() + " має більше населення, ніж " + country2.getName() + ".");
        } else if (country1.getPopulation() < country2.getPopulation()) {
            System.out.println(country2.getName() + " має більше населення, ніж " + country1.getName() + ".");
        } else {
            System.out.println("Обидві країни мають однакове населення.");
        }
    }

    // Метод для конвертації валюти
    private static void convertCurrency(Country[] countries, Scanner scanner) {
        System.out.println("Доступні країни для конвертації валюти:");
        for (int i = 0; i < countries.length; i++) {
            System.out.println((i + 1) + ". " + countries[i].getName());
        }
        System.out.print("Оберіть країну: ");
        int countryChoice = scanner.nextInt();
        if (countryChoice >= 1 && countryChoice <= countries.length) {
            Country selectedCountry = countries[countryChoice - 1];
            System.out.print("Введіть суму в місцевій валюті (" + selectedCountry.getName() + "): ");
            double amountInLocalCurrency = scanner.nextDouble();
            double amountInUSD = amountInLocalCurrency / selectedCountry.getCurrencyRate();
            System.out.printf("Сума в доларах США: %.2f USD", amountInUSD);
        } else {
            System.out.println("Невірний вибір.");
        }
    }

    // Метод для запуску DataManager
    private static void runDataManager(Scanner scanner) {
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
    }
}

