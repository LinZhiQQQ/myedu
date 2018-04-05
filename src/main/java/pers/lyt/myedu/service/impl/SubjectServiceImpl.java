package pers.lyt.myedu.service.impl;

import org.springframework.stereotype.Service;
import pers.lyt.myedu.dao.BaseDao;
import pers.lyt.myedu.entity.Student;
import pers.lyt.myedu.entity.Student_sub;
import pers.lyt.myedu.entity.Subject;
import pers.lyt.myedu.entity.Teacher;
import pers.lyt.myedu.service.StudentSubService;
import pers.lyt.myedu.service.SubjectService;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private BaseDao<Subject> baseDao;

    @Resource
    private StudentSubService studentSubService;
    @Override
    public void saveSubject(Subject subject) {
        baseDao.save(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        baseDao.update(subject);
    }

    @Override
    public void deleteSubject(Subject subject) {
        baseDao.delete(subject);
    }

    @Override
    public List<Subject> findAllList() {
        return baseDao.find("from Subject");
    }


    @Override
    public List<Subject> findSubjectByTeacher(Teacher teacher) {
        List<Subject> list = baseDao.find("from Subject s where s.tch_id=?", new Object[]{teacher.getTch_id()});
        return list;
    }

    @Override
    public List<Subject> findSubjectByStudent(Student student) {
        List<Student_sub> ls = studentSubService.findSubjectByStudent(student);
        List<Subject> list = new ArrayList<Subject>();
        for(int i = 0 ; i < ls.size() ; i++) {
            Student_sub obj = ls.get(i);
            Subject sub = findSubjectById(obj.getSub_id());
            list.add(sub);
        }
        return list;
    }


    @Override
    public Subject findSubjectById(int sub_id) {
        return (Subject) baseDao.get("from Subject s where s.sub_id=?", new Object[]{sub_id});
    }

    @Override
    public int searchId() {
        Subject subject = baseDao.get("from Subject where sub_id=(select max(sub_id) from Subject)", new Object[]{});
//        System.out.println(subject);
        return subject.getSub_id() + 1;
    }


}
