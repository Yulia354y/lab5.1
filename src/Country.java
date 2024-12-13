public class Country {
    private String name; // Назва країни
    private String capital; // Столиця країни
    private int population; // Населення в мільйонах
    private double currencyRate; // Обмінний курс до долара США


    public Country(String name, String capital, int population, double currencyRate) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.currencyRate = currencyRate;
    }


    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }


    public void displayInfo() {
        System.out.println("Назва країни: " + name);
        System.out.println("Столиця: " + capital);
        System.out.println("Населення: " + population + " мільйонів");
        System.out.println("Обмінний курс до долара США: " + currencyRate);
    }
}

