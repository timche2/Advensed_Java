package net.dunice.advancedjavaprojectacademy.tasks.block4;

import net.dunice.advancedjavaprojectacademy.tasks.Employee;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import java.util.Comparator;

import static java.util.stream.Collectors.groupingBy;

public class Block4 implements Block4Interface{
    Comparator ComparatorBySalary =
            Comparator.comparingDouble(Employee::salary);
    Comparator ComparatorByWorkYears =
            Comparator.comparingInt(Employee::workYears);
    @Override
    public List<Employee> printAndGetListEmployees(Employee... employees) {

        var sortedEmployees = List.of(employees).stream()
                .sorted(ComparatorBySalary).toList()
                .stream().sorted(ComparatorByWorkYears).toList();
        sortedEmployees.forEach(element -> System.out.println(element));
        return sortedEmployees;
    }

    @Override
    public List<Employee> getListEmployeesGreaterHundred(List<Employee> employees) {
        return employees.stream().filter(employee -> employee.salary() > 100000).sorted(ComparatorBySalary).toList();
    }

    @Override
    public Employee getEmployeeMaxSalary(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::salary))
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public Map<String, List<Employee>> getEmployeesGroupedByName(List<Employee> employees) {

        Map<String, List<Employee>> employeesMap = employees.stream()
                .collect(groupingBy(Employee::firstName));
        return employeesMap;

    }

    @Override
    public Double getSalarySum(List<Employee> employees) {
        var value = employees.stream().collect(Collectors.summarizingDouble(Employee::salary));
        return value.getSum();
    }

    @Override
    public Double getAverageSalary(List<Employee> employees) {
        var value = employees.stream().collect(Collectors.summarizingDouble(Employee::salary));
        return value.getAverage();
    }
}
