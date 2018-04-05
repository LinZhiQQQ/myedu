package pers.lyt.myedu.service;

import pers.lyt.myedu.entity.Student;
import pers.lyt.myedu.entity.Subject;
import pers.lyt.myedu.entity.Teacher;

import java.util.List;

public interface SubjectService {

    public void saveSubject(Subject subject);

    public void updateSubject(Subject subject);

    public void deleteSubject(Subject subject);

    public List<Subject> findAllList();

    public List<Subject> findSubjectByTeacher(Teacher teacher);

    public List<Subject> findSubjectByStudent(Student student);

    public Subject findSubjectById(int sub_id);

    public int searchId();
}
