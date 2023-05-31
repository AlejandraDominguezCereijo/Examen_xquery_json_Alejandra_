package Empleados;

import Empleados.Employees;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        String filePath = "employees.json";

        try (FileReader fileReader = new FileReader(filePath)) {
            // Lee el archivo JSON completo como un objeto EmployeesData
            Employees employeesData = gson.fromJson(fileReader, Employees.class);

            // Obtiene la lista de empleados del objeto EmployeesData
            List<Employees> employees = employeesData.getEmployees();

            // Recorre la lista de empleados y muestra sus datos
            for (Employees employee : employees) {
                System.out.println("Nombre: " + employee.getFirstName());
                System.out.println("Apellido: " + employee.getLastName());
                System.out.println();
            }

            // Añade un nuevo empleado a la lista
            Employees newEmployee = new Employees();
            newEmployee.setFirstName("Sarah");
            newEmployee.setLastName("Johnson");
            employees.add(newEmployee);

            // Escribe la lista actualizada en el archivo JSON
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                gson.toJson(employeesData, fileWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
