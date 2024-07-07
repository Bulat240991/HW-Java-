/*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.

-Создать множество ноутбуков.
-Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
-Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
-Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */

//import java.util.HashSet;
import java.util.Objects;
//import java.util.Set;

/**
 * Notebook
 */
public class Notebook {
    // Производитель (brand)
    // Цвет (color)
    // Операционная система (OS)
    // Объем ОЗУ (RAM)
    // Объем ПЗУ (hard disk)
    private String brand;
    private String color;
    private String os;
    private int ram;
    private int hardDisk;

    public Notebook(String brand, String color, String os, int ram, int hardDisk) {
        this.brand = brand;
        this.color = color;
        this.os = os;
        this.ram = ram;
        this.hardDisk = hardDisk;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setOs(String os){
        this.os = os;
    }

    public void setRam(int ram){
        this.ram = ram;
    }

    public void setHardDisk(int hardDisk){
        this.hardDisk = hardDisk;
    }

    // Метод для вывода информации о ноутбуке
    @Override
    public String toString() {
        String result = "Notebook:" + '\n' +
                "Производитель: " + brand + '\n' +
                "Цвет: " + color + '\n' +
                "Операционная система: " + os + '\n' +
                "Объем ОЗУ: " + ram + '\n' +
                "Объем ПЗУ: " + hardDisk + '\n';
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false; 

        Notebook notebook = (Notebook) obj;
        return brand.equals(notebook.brand) 
            && color.equals(notebook.color)
            && os.equals(notebook.os)
            && ram == notebook.ram
            && hardDisk == notebook.hardDisk;
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, os, ram, hardDisk);
    }


}