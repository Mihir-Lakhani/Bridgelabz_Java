package Java_Collections.Map;

import java.util.*;

// Map 5: group Employee objects into Map<Department, List<Employee>>.
public class GroupEmployeesByDepartment {

    enum Department { HR, IT }

    static class Employee {
        final String name;
        final Department department;
        Employee(String name, Department department) {
            this.name = name;
            this.department = department;
        }
        @Override
        public String toString() { return name; }
    }

    static Map<Department, List<Employee>> group(List<Employee> employees) {
        Map<Department, List<Employee>> result = new LinkedHashMap<>();
        for (Employee employee : employees) {
            result.computeIfAbsent(employee.department, key -> new ArrayList<>()).add(employee);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT), new Employee("Carol", Department.HR));
        group(employees).forEach((department, people) -> System.out.println(department + ": " + people));
    }
}
