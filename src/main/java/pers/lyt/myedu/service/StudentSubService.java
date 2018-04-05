package pers.lyt.myedu.service;
import pers.lyt.myedu.entity.Student;
import pers.lyt.myedu.entity.Student_sub;
import pers.lyt.myedu.entity.Subject;

import java.util.List;

public interface StudentSubService {
    public void saveStudentSub(Student_sub student_sub);

    public void updateStudentSub(Student_sub student_sub);

    public List<Student_sub> findSubjectByStudent(Student student);

    public boolean checkStudentAndSubjectById(int stu_id, int sub_id);

    public Student_sub findSubjectSubByStudentAndSubjectWithId(int stu_id, int sub_id);

    public void deleteSubjectSubject(Student_sub student_sub);

    public List<Student_sub> findSubjectById(int sub_id);
}
