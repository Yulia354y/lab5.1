// Клас DataManager для керування списком об'єктів
import java.util.ArrayList;
import java.util.List;
class DataManager {
    private List<Reportable> dataList;

    public DataManager() {
        dataList = new ArrayList<>();
    }

    public void addData(Reportable data) {
        dataList.add(data);
    }

    public void editData(int index, Reportable newData) {
        if (index >= 0 && index < dataList.size()) {
            dataList.set(index, newData);
        } else {
            System.out.println("Неправильний індекс!");
        }
    }

    public void removeData(int index) {
        if (index >= 0 && index < dataList.size()) {
            dataList.remove(index);
        } else {
            System.out.println("Неправильний індекс!");
        }
    }

    public Reportable getData(int index) {
        if (index >= 0 && index < dataList.size()) {
            return dataList.get(index);
        } else {
            System.out.println("Неправильний індекс!");
            return null;
        }
    }

    public void displayAllReports() {
        for (Reportable data : dataList) {
            data.displayReport();
        }
    }
}