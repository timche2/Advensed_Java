package net.dunice.advancedjavaprojectacademy.tasks.block3;

import net.dunice.advancedjavaprojectacademy.tasks.Student;

import java.util.ArrayList;
import java.util.List;
import net.dunice.advancedjavaprojectacademy.tasks.Sex;

public class Block3 implements Block3Interface{

    @Override
    public List<Student> getAgendaList(List<Student> studentList) {
        ArrayList<Student> outStudentList = new ArrayList<Student>();
        for (var student : studentList){
            if(student.age() >= 18 && student.age() < 27 && student.sex() == Sex.MAN){
                outStudentList.add(student);
            }
        }
        return outStudentList;
    }

    @Override
    public List<Student> getJobList(List<Student> studentList) {
        ArrayList<Student> outStudentList = new ArrayList<Student>();
        for (var student : studentList){
            if((student.age() >= 18 && student.age() < 60 && student.sex() == Sex.MAN) ||
                    (student.age() >= 18 && student.age() < 55 && student.sex() == Sex.WOMAN)){
                outStudentList.add(student);
            }
        }
        return outStudentList;
    }

    @Override
    public List<String> getListSortByAlphabet(List<String> list) {
        return List.of();
    }

    @Override
    public List<String> getListWithNumbers(List<String> list) {
        return List.of();
    }

    @Override
    public int[] getArrayNumbers(List<String> list) {
        return new int[0];
    }

    @Override
    public List<String> getListSortedAndDistinct(List<String> list) {
        return List.of();
    }
}
