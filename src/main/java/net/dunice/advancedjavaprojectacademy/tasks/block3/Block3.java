package net.dunice.advancedjavaprojectacademy.tasks.block3;


import net.dunice.advancedjavaprojectacademy.tasks.Student;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import net.dunice.advancedjavaprojectacademy.tasks.Sex;
public class Block3 implements Block3Interface {

    @Override
    public List<Student> getAgendaList(List<Student> studentList) {
        return  studentList.stream()
                .filter( x -> x.age() >= 18 && x.age() < 27)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getJobList(List<Student> studentList) {
        return  studentList.stream()
                .filter( x -> (x.age() >= 18 && x.age() <= 60 && x.sex() == Sex.MAN) ||
                        (x.age() >= 18 && x.age() <= 55 && x.sex() == Sex.WOMAN))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getListSortByAlphabet(List<String> list) {
        return list.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getListWithNumbers(List<String> list) {
        return list.stream().map(valueList -> valueList + "_1")
                .collect(Collectors.toList());
    }

    @Override
    public int[] getArrayNumbers(List<String> list) {
        return list.stream()
                .map(valueList -> valueList.charAt(1))
                .map(c -> c - 48).mapToInt(i->i).toArray();
    }

    @Override
    public List<String> getListSortedAndDistinct(List<String> list) {
        return list.stream()
                .sorted(Comparator.naturalOrder())
                .distinct()
                .collect(Collectors.toList());
    }
}