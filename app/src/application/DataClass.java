package application;

import java.util.ArrayList;
import java.util.List;

public class DataClass {
    private List<Person> importList;
    private List<Person> exportList;

    public DataClass() {
        importList = new ArrayList<Person>();
        importList.add(new Person("Sami", "BenAli", "sami@exemple.com","25802987"));
        importList.add(new Person("Alia", "BenSalah", "alia@exemple.com","75842369"));
        importList.add(new Person("Ali", "BenSalah", "ali@exemple.com","95897125"));
        
        exportList = new ArrayList<Person>(); // initialisation de exportList
    }

    public List<Person> getImportList() {
        return importList;
    }

    public List<Person> getExportList() {
        return exportList;
    }

    public void setExportList(List<Person> exportList) {
        this.exportList.addAll(exportList);
        for (Person p : this.exportList)
            System.out.println(p);
    }
}
