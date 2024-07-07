
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NotebookMain {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("Lenovo", "White", "Windows 11", 16, 512);
        Notebook notebook2 = new Notebook("Acer", "Black", "Windows 10", 8, 256);
        Notebook notebook3 = new Notebook("HP", "Silver", "Windows 11", 8, 256);
        Notebook notebook4 = new Notebook("Dell", "Black", "Windows 10", 16, 512);
        Notebook notebook5 = new Notebook("Asus", "Silver", "Linux", 8, 256);

        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5));
        // for (Notebook notebook : notebooks) {
        // System.out.println(notebook);

        NotebookFilerSet notebookSet = new NotebookFilerSet(notebooks);

        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> criteriaNoteMap = new HashMap<>();
        criteriaNoteMap.put(1, "Производитель");
        criteriaNoteMap.put(2, "Цвет");
        criteriaNoteMap.put(3, "Операционная система");
        criteriaNoteMap.put(4, "ОЗУ");
        criteriaNoteMap.put(5, "Объем ЖД");
        criteriaNoteMap.put(6, "Показать весь список ноутбуков");

        Map<Integer, String> criteriaBrandMap = new HashMap<>();
        criteriaBrandMap.put(1, "Lenovo");
        criteriaBrandMap.put(2, "Acer");
        criteriaBrandMap.put(3, "HP");
        criteriaBrandMap.put(4, "Dell");
        criteriaBrandMap.put(5, "Asus");

        Map<Integer, String> criteriaColorMap = new HashMap<>();
        criteriaColorMap.put(1, "White");
        criteriaColorMap.put(2, "Black");
        criteriaColorMap.put(3, "Silver");

        Map<Integer, String> criteriaOsMap = new HashMap<>();
        criteriaOsMap.put(1, "Windows 11");
        criteriaOsMap.put(2, "Windows 10");
        criteriaOsMap.put(3, "Linux");

        Map<Integer, String> criteriaRamMap = new HashMap<>();
        criteriaRamMap.put(1, "8");
        criteriaRamMap.put(2, "16");

        Map<Integer, String> criteriaHardDiskMap = new HashMap<>();
        criteriaHardDiskMap.put(1, "256");
        criteriaHardDiskMap.put(2, "512");

        
        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            criteriaNoteMap.forEach((k, v) -> System.out.println(k + " - " + v));
            System.out.println("0 - Завершить ввод критериев");
            int criteria = scanner.nextInt();
            scanner.nextLine();
            if (criteria == 0) {
                break;
                }

            String filterValue = null;
            switch (criteria) {
                case 1:
                    System.out.println("Введите цифру, соответствующую интересующему вас производителю:");
                    criteriaBrandMap.forEach((k, v) -> System.out.println(k + " - " + v));
                    int brandChoice = scanner.nextInt();
                    scanner.nextLine();
                    filterValue = criteriaBrandMap.get(brandChoice);
                    break;
                case 2:
                    System.out.println("Введите цифру, соответствующую интересующему вас цвету:");
                    criteriaColorMap.forEach((k, v) -> System.out.println(k + " - " + v));
                    int colorChoice = scanner.nextInt();
                    scanner.nextLine();
                    filterValue = criteriaColorMap.get(colorChoice);
                    break;
                case 3:
                    System.out.println("Введите цифру, соответствующую интересующей вас операционной системе:");
                    criteriaOsMap.forEach((k, v) -> System.out.println(k + " - " + v));
                    int osChoice = scanner.nextInt();
                    scanner.nextLine();
                    filterValue = criteriaOsMap.get(osChoice);
                    break;
                case 4:
                    System.out.println("Выберите объем Оперативной памяти:");
                    criteriaRamMap.forEach((k, v) -> System.out.println(k + "-" + v));
                    int ramCoise = scanner.nextInt();
                    scanner.nextLine();
                    filterValue = criteriaRamMap.get(ramCoise);
                    break;
                case 5:
                    System.out.println("Выберите объем ЖД:");
                    criteriaHardDiskMap.forEach((k, v) -> System.out.println(k + "-" + v));
                    int hardDiskChoice = scanner.nextInt();
                    scanner.nextLine();
                    filterValue = criteriaHardDiskMap.get(hardDiskChoice);
                    break;
                case 6:
                    for (Notebook notebook : notebooks) {
                    System.out.println(notebook);
                    }
                    break;
                default:
                    System.out.println("Неверный критерий. Попробуйте снова.");
            }


            if (filterValue != null) {
                Set<Notebook> filteredNotebooks = notebookSet.filterByCriterion(criteriaNoteMap.get(criteria), filterValue);
                System.out.println("Ноутбуки, отвечающие условиям фильтра:");
                filteredNotebooks.forEach(System.out::println);
            }
        }
        scanner.close();
    }
}