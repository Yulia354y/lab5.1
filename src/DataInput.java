// Абстрактний клас для введення та виведення загальних даних
import java.util.Scanner;
abstract class DataInput {
    protected Scanner scanner = new Scanner(System.in);
    public abstract void input();
}