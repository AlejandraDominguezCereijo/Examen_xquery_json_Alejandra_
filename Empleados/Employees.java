package Empleados;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Employees {
    private String firstName;
    private String lastName;
    private List<Employees> employees;

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
