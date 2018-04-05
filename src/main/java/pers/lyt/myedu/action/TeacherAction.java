package pers.lyt.myedu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;
import pers.lyt.myedu.entity.MyImage;
import pers.lyt.myedu.entity.Student_sub;
import pers.lyt.myedu.entity.Subject;
import pers.lyt.myedu.entity.Teacher;
import pers.lyt.myedu.service.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

@Controller
public class TeacherAction extends ActionSupport implements ServletRequestAware {
    private static final long serialVersionUID = 1L;

    private HttpServletRequest request;
    private String userName,userPwd,userId,selec,error1,resule1,resultD,stu_id,sub_id,newScore,rememberMe;
    private Teacher teacher = new Teacher();
    private Subject subject = new Subject();

    @Resource
    private TeacherService teacherService;

    @Resource
    private SubjectService subjectService;

    @Resource
    private StudentSubService studentSubService;

    @Resource
    private StudentService studentService;

    @Resource
    private ImgService imgService;

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSelec() {
        return selec;
    }

    public void setSelec(String selec) {
        this.selec = selec;
    }

    public String getError1() {
        return error1;
    }

    public void setError1(String error1) {
        this.error1 = error1;
    }

    public String getResule1() {
        return resule1;
    }

    public void setResule1(String resule1) {
        this.resule1 = resule1;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getResultD() {
        return resultD;
    }

    public void setResultD(String resultD) {
        this.resultD = resultD;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getNewScore() {
        return newScore;
    }

    public void setNewScore(String newScore) {
        this.newScore = newScore;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String tch_login() throws Exception{
        HttpSession session = request.getSession();
        teacher.setTch_pwd(new String(""+userPwd));
        teacher.setTch_id(new Integer(userId));
        Teacher currentTch = teacherService.findTeacherByIdAndPassword(teacher);
        if (currentTch != null){
            teacher = currentTch;

            Cookie cookie = new Cookie("userId",null);
            cookie.setMaxAge(0);
            ServletActionContext.getResponse().addCookie(cookie);

            cookie = new Cookie("userPwd",null);
            cookie.setMaxAge(0);
            ServletActionContext.getResponse().addCookie(cookie);
            MyImage myImage = new MyImage();
            myImage.setUserId(teacher.getTch_id());
            myImage = imgService.findImageByUserId(teacher.getTch_id());
            session.setAttribute("img",myImage);
            session.setAttribute("teacher",teacher);

            if(rememberMe != null){
                cookie = new Cookie("userId",userId);
                cookie.setMaxAge(60*60*24*30);
                ServletActionContext.getResponse().addCookie(cookie);

                cookie = new Cookie("userPwd",userPwd);
                cookie.setMaxAge(60*60*24*30);
                ServletActionContext.getResponse().addCookie(cookie);

                cookie = new Cookie("userType","teacher");
                cookie.setMaxAge(60*60*24*30);
                ServletActionContext.getResponse().addCookie(cookie);

                System.out.println("成功设置cookies");
            }
            return "tch_login";
        }else {
            error1 = "用户名或密码错误";
            return ERROR;
        }
    }

    public String returnTo_tch() throws Exception{
        HttpSession session = request.getSession();
        teacher = (Teacher) session.getAttribute("teacher");
        if(teacher == null){
            return ERROR;
        }
        return "returnTo_tch";
    }
    public String tch_regs() throws Exception{
        HttpSession session = request.getSession();
        teacher.setTch_pwd(new String(""+userPwd));
        teacher.setTch_id(new Integer(new Integer(userId)));
        teacher.setTch_name(new String(""+userName));
        teacher.setTch_age(0);
        teacher.setTch_sch("");
        teacher.setTch_sex(0);
        teacher.setTch_tel("");
        Teacher currentTch = teacherService.findTeacherById(teacher.getTch_id());
        if (currentTch == null){
            teacherService.saveTeacher(teacher);
            resule1 = "成功添加教师";
            return "tch_regs";
        }else {
            error1 = "此id已存在";
            return "tch_regs";
        }
    }
    public String tch_ppi() throws Exception{
        HttpSession session = request.getSession();
        Teacher currentTch = (Teacher) session.getAttribute("teacher");
        if(currentTch == null){
            return ERROR;
        }
        teacher.setTch_id(currentTch.getTch_id());
        teacher.setTch_name(currentTch.getTch_name());
        teacher.setTch_pwd(currentTch.getTch_pwd());
        teacher.setId(currentTch.getId());
        if(currentTch != null){
            teacherService.updateTeacher(teacher);
            return "tch_ppi";
        }else{
            System.out.println("提交失败");
            error1 = "提交失败";
            return ERROR;
        }
    }
    public String tch_to_ppi() throws Exception{
        HttpSession session = request.getSession();
        teacher = (Teacher) session.getAttribute("teacher");
        if(teacher == null){
            return ERROR;
        }
        return "tch_to_ppi";
    }
    public String tch_sub() throws Exception{
        HttpSession session = request.getSession();
        teacher = (Teacher) session.getAttribute("teacher");
        if(teacher == null){
            return ERROR;
        }
        List<Subject> list = subjectService.findSubjectByTeacher(teacher);
        session.setAttribute("list",list);
        return "tch_sub";
    }
    public String toCreate_sub() throws Exception{
        HttpSession session = request.getSession();
        teacher = (Teacher) session.getAttribute("teacher");
        if(teacher == null){
            return ERROR;
        }
        return "toCreate_sub";
    }
    public String create_sub() throws Exception{
        HttpSession session = request.getSession();
        teacher = (Teacher) session.getAttribute("teacher");
        if(teacher == null){
            return ERROR;
        }
        subject.setSub_sch(teacher.getTch_sch());
        subject.setTch_id(teacher.getTch_id());
        subject.setSub_id(subjectService.searchId());
        System.out.println(subject);
        subjectService.saveSubject(subject);
        List<Subject> list = subjectService.findSubjectByTeacher(teacher);
        session.setAttribute("list",list);
        return "create_sub";
    }
    public String toCancel_sub() throws Exception{
        HttpSession session = request.getSession();
        teacher = (Teacher) session.getAttribute("teacher");
        if(teacher == null){
            return ERROR;
        }
        List<Subject> list = subjectService.findSubjectByTeacher(teacher);
        session.setAttribute("list",list);
        return "toCancel_sub";
    }

    public String cancel_sub() throws  Exception{
        HttpSession session = request.getSession();
        teacher = (Teacher) session.getAttribute("teacher");
        if(teacher == null){
            return ERROR;
        }
        String cancelId[] = request.getParameterValues ("cancelId");
        resultD = "";
        for(int i = 0;i < cancelId.length;i++){
            Subject sbj = subjectService.findSubjectById(Integer.valueOf(cancelId[i]));
            resultD += sbj.getSub_name() + " ";
            List cancelList = studentSubService.findSubjectById(sbj.getSub_id());
            for(int j = 0;j < cancelList.size();j++){
                Student_sub student_sub = (Student_sub) cancelList.get(j);
                studentSubService.deleteSubjectSubject(student_sub);
            }
            subjectService.deleteSubject(sbj);
        }
        if(cancelId.length == 0){
            resultD = "未选择取消课程";
        }else{
            resultD += "课程已经成功取消";
        }
        List<Subject> list = subjectService.findSubjectByTeacher(teacher);
        session.setAttribute("list",list);
        return "cancel_sub";
    }
    public String tch_sub_detail () throws Exception{
        HttpSession session = request.getSession();
        teacher = (Teacher) session.getAttribute("teacher");
        if(teacher == null){
            return ERROR;
        }
        sub_id = (request.getParameter("detail"));
        List<Student_sub> ssblist = studentSubService.findSubjectById(Integer.valueOf(sub_id));
        String name[] = new String[ssblist.size()];
        for(int i = 0;i < ssblist.size();i++){
            name[i] = new String(studentService.findStudentById(ssblist.get(i).getStu_id()).getStu_name());
        }
        Subject sbj = subjectService.findSubjectById(Integer.valueOf(sub_id));
        session.setAttribute("ssblist",ssblist);
        session.setAttribute("sbj",sbj);
        session.setAttribute("name",name);
        return "tch_sub_detail";
    }
    public String changeScore() throws Exception{
        HttpSession session = request.getSession();
        teacher = (Teacher)session.getAttribute("teacher");
        if(teacher == null){
            return ERROR;
        }
        String score = (request.getParameter("newScore"));
        Student_sub ssb = studentSubService.findSubjectSubByStudentAndSubjectWithId(Integer.valueOf(stu_id),Integer.valueOf(sub_id));
        ssb.setScore(Integer.valueOf(newScore));
        studentSubService.updateStudentSub(ssb);
        List<Student_sub> ssblist = studentSubService.findSubjectById(Integer.valueOf(sub_id));
        session.setAttribute("ssblist",ssblist);
        session.setAttribute("teacher",teacher);
        return "changeScore";
    }
    public String exit() throws Exception{
        HttpSession session = request.getSession();
        session.removeAttribute("teacher");
        return "exit";
    }
    public String turn_back() throws Exception{
        HttpSession session = request.getSession();
        return "turn_back";
    }

    public String change_img() throws Exception{
        HttpSession session = request.getSession();
        teacher = (Teacher) session.getAttribute("teacher");
        session.setAttribute("teacher",teacher);
        return "change_img";
    }
}
