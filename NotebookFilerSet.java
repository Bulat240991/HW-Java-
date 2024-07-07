import java.util.Set;
import java.util.stream.Collectors;

class NotebookFilerSet {
    private Set<Notebook> notebooks;

    public NotebookFilerSet(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }
/**
 * Mетод "filterByCriterion" выполняет фильтрацию Ноутбуков "notebookSet" на основе значений:
 * 
 * @param criterion получает значение из "criteriaNoteMap.get(criteria)", 
 *                  который отпредяет по какому параметру будет выполняться 
 *                  сортировка ноутбуков(производитель, ОС, объем памяти)
 * 
 * @param value получает данные из метода "filterValue", позвляет выбрать 
 *              конкретные характеристики параметра Ноутбука, выбранного в 
 *              методе "criteriaNoteMap.get(criteria)"
 *
 * @return возвращает новое множество Ноутбуков, которые удовлетворяют условиям фильтрации
 */

    public Set<Notebook> filterByCriterion(String criterion, String value) {
        return notebooks.stream().filter(notebook -> {
            switch (criterion) {
                case "Производитель":
                    return notebook.getBrand().equalsIgnoreCase(value);
                case "Цвет":
                    return notebook.getColor().equalsIgnoreCase(value);
                case "Операционная система":
                    return notebook.getOs().equalsIgnoreCase(value);
                case "ОЗУ":
                    return notebook.getRam() == Integer.parseInt(value);
                case "Объем ЖД":
                    return notebook.getHardDisk() == Integer.parseInt(value);
                default:
                    return false;
            }
        }).collect(Collectors.toSet());
    }
}