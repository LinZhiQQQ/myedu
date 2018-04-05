package pers.lyt.myedu.service.impl;

import org.springframework.stereotype.Service;
import pers.lyt.myedu.dao.BaseDao;
import pers.lyt.myedu.entity.Student;
import pers.lyt.myedu.entity.Student_sub;
import pers.lyt.myedu.entity.Subject;
import pers.lyt.myedu.service.StudentSubService;

import javax.annotation.Resource;
import java.util.List;

@Service("studentSubService")
public class StudentSubServiceImpl implements StudentSubService {
    @Resource
    private BaseDao<Student_sub> baseDao;

    @Resource
    private BaseDao<Subject> baseDao2;
    @Override
    public void saveStudentSub(Student_sub student_sub) {
        baseDao.save(student_sub);
    }

    @Override
    public void updateStudentSub(Student_sub student_sub) {
        baseDao.update(student_sub);
    }

    @Override
    public List<Student_sub> findSubjectByStudent(Student student) {
        List<Student_sub> list = baseDao.find("from Student_sub s where s.stu_id = ?", new Object[]{student.getStu_id()});
        return list;
    }

    @Override
    public boolean checkStudentAndSubjectById(int stu_id, int sub_id) {
        Student_sub student_sub = findSubjectSubByStudentAndSubjectWithId(stu_id,sub_id);
        if(student_sub != null){
            return true;
        }
        return false;
    }

    @Override
    public Student_sub findSubjectSubByStudentAndSubjectWithId(int stu_id, int sub_id) {
        return baseDao.get("from Student_sub s where s.stu_id = ? and s.sub_id = ?", new Object[]{stu_id,sub_id});
    }

    @Override
    public void deleteSubjectSubject(Student_sub student_sub) {
        baseDao.delete(student_sub);
    }

    @Override
    public List<Student_sub> findSubjectById(int sub_id) {
        return  baseDao.find("from Student_sub s where s.sub_id = ?",new Object[]{sub_id});
    }
}
