package pers.lyt.myedu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;
import pers.lyt.myedu.entity.MyImage;
import pers.lyt.myedu.entity.Student;
import pers.lyt.myedu.entity.Student_sub;
import pers.lyt.myedu.entity.Subject;
import pers.lyt.myedu.service.ImgService;
import pers.lyt.myedu.service.StudentService;
import pers.lyt.myedu.service.StudentSubService;
import pers.lyt.myedu.service.SubjectService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentAction extends ActionSupport  implements ServletRequestAware{

    private static final long serialVersionUID = 1L;

    private HttpServletRequest request;


    @Resource
    private StudentService studentService;

    @Resource
    private SubjectService subjectService;

    @Resource
    private StudentSubService studentSubService;

    @Resource
    private ImgService imgService;

    private Student student;

    private String resule1,resultA,resultB,resultC,error1,selec,newpassword,userId,userPwd,userName,rememberMe;

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getSelec() {
        return selec;
    }

    public void setSelec(String selec) {
        this.selec = selec;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public String getError1() {
        return error1;
    }

    public void setError1(String error) {
        this.error1 = error;
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

    public String getResule1() {
        return resule1;
    }

    public void setResule1(String resule1) {
        this.resule1 = resule1;
    }

    public String getResultA() {
        return resultA;
    }

    public void setResultA(String resultA) {
        this.resultA = resultA;
    }

    public String getResultB() {
        return resultB;
    }

    public void setResultB(String resultB) {
        this.resultB = resultB;
    }

    public String getResultC() {
        return resultC;
    }

    public void setResultC(String resultC) {
        this.resultC = resultC;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String stu_login() throws Exception{ ;
        HttpSession session = request.getSession();
        if(userPwd == null || userId == null || userPwd.equals("") || userId.equals("")){
            return ERROR;
        }
        System.out.println("uuuu = " + userPwd);
        student = new Student();
        student.setStu_pwd(new String(userPwd));
        student.setStu_id(new Integer(userId));
        Student currentStu = studentService.findStudentById(student.getStu_id());
        if (currentStu != null && currentStu.getStu_pwd().equals(student.getStu_pwd())){
            student = currentStu;
            MyImage myImage = new MyImage();
            myImage.setUserId(student.getStu_id());
            myImage = imgService.findImageByUserId(student.getStu_id());
            session.setAttribute("img",myImage);
            session.setAttribute("student",student);

            return "stu_login";
        }else {
            error1 = "用户名或密码错误";
            return ERROR;
        }
    }

    public String returnTo_stu() throws Exception{
        HttpSession session = request.getSession();
        student = (Student) session.getAttribute("student");
        if(student == null){
            return ERROR;
        }
        return "returnTo_stu";
    }
    public String stu_regs() throws Exception{
        HttpSession session = request.getSession();
        if(student == null){
            student = new Student();
        }
        student.setStu_pwd(new String(""+userPwd));
        student.setStu_id(new Integer(userId));
        student.setStu_name(new String(""+userName));
        student.setStu_age(0);
        student.setStu_cls(0);
        student.setStu_gra(0);
        student.setStu_sch("");
        student.setStu_sex(0);
        student.setStu_tel("");
        Student currentStu = studentService.findStudentById(student.getStu_id());
        if (currentStu == null){
            studentService.saveStudent(student);
            resule1 = "成功添加学生";
            return "stu_regs";
        }else {
            error1 = "此id已存在";
            return "stu_regs";
        }
    }

    public String stu_ppi() throws Exception{
        HttpSession session = request.getSession();
        Student currentStu = (Student) session.getAttribute("student"); //可以重复使用session
        if(currentStu == null){
            return ERROR;
        }
        currentStu = studentService.findStudentById(currentStu.getStu_id());
        student.setStu_id(currentStu.getStu_id());
        student.setStu_name(currentStu.getStu_name());
        student.setStu_pwd(currentStu.getStu_pwd());
        student.setId(currentStu.getId());
        if(currentStu != null){
            studentService.updateStudent(student);
            return "stu_ppi";
        }else{
            error1 = "提交失败";
            return ERROR;
        }
    }

    public String stu_to_ppi() throws Exception{
        HttpSession session = request.getSession();
        student = (Student) session.getAttribute("student");
        if(student == null){
            return ERROR;
        }
        session.setAttribute("student",student);
        return "stu_to_ppi";
    }

    public String ck_sub() throws Exception{
        HttpSession session = request.getSession();
        student = (Student) session.getAttribute("student");
        if(student == null){
            return ERROR;
        }else{
            List<Subject> list = subjectService.findSubjectByStudent(student);
            session.setAttribute("list",list);
            return "stu_sub";
        }
    }

    public String toAdd_sub() throws Exception{
        HttpSession session = request.getSession();
        student = (Student) session.getAttribute("student");
        if(student == null){
            return ERROR;
        }
        List<Subject> list = subjectService.findAllList();
        session.setAttribute("list",list);
        return "toAdd_sub";
    }
    public String add_sub() throws Exception{
        HttpSession session = request.getSession();
        student = (Student) session.getAttribute("student");
        if(student == null){
            return ERROR;
        }
        List<Subject> list = subjectService.findAllList();
        session.setAttribute("list",list);
        String addId[] = request.getParameterValues ("addId");
        resultA = "";
        resultB = "";
        int flag1 = 0,flag2 = 0;
        for(int i = 0;i < addId.length;i++){
            if (studentSubService.checkStudentAndSubjectById(student.getStu_id(),Integer.valueOf(addId[i]))){
                flag1 = 1;
                Subject sbj = subjectService.findSubjectById(Integer.valueOf(addId[i]));
                resultA += sbj.getSub_name() + " ";
            }else{
                flag2 = 1;
                Student_sub student_sub = new Student_sub();
                student_sub.setStu_id(student.getStu_id());
                Subject sbj = subjectService.findSubjectById(Integer.valueOf(addId[i]));
                student_sub.setSub_id(sbj.getSub_id());
                student_sub.setScore(-1);
                studentSubService.saveStudentSub(student_sub);
                resultB += sbj.getSub_name() + " ";
            }
        }
        if(flag1 == 1){
            resultA += "已经被选，无需重复选择";
        }
        if(flag2 == 1){
            resultB += "添加成功";
        }
        return "add_sub";
    }
    public String toDelete_sub() throws Exception{
        HttpSession session = request.getSession();
        student = (Student) session.getAttribute("student");
        if(student == null){
            return ERROR;
        }
        List<Subject> list = subjectService.findSubjectByStudent(student);
        session.setAttribute("list",list);
        return "toDelete_sub";
    }

    public String delete_sub() throws Exception{
        HttpSession session = request.getSession();
        student = (Student) session.getAttribute("student");
        if(student == null){
            return ERROR;
        }
        String deleteId[] = request.getParameterValues ("deleteId");
        resultC = "";
        for(int i = 0;i < deleteId.length;i++){
            Student_sub student_sub = studentSubService.findSubjectSubByStudentAndSubjectWithId(student.getStu_id(),Integer.valueOf(deleteId[i]));
            Subject sbj = subjectService.findSubjectById(student_sub.getSub_id());
            studentSubService.deleteSubjectSubject(student_sub);
            resultC += sbj.getSub_name() + " ";
        }
        if(deleteId.length != 0){
            resultC += "已经成功退选";
        }
        List<Subject> list = subjectService.findSubjectByStudent(student);
        session.setAttribute("list",list);
        return "delete_sub";
    }
    public String stu_sub_detail() throws Exception{
        HttpSession session = request.getSession();
        student = (Student) session.getAttribute("student");
        if(student == null){
            return ERROR;
        }
        Integer sub_id = Integer.valueOf(request.getParameter("detail"));
        Student_sub ssb = studentSubService.findSubjectSubByStudentAndSubjectWithId(student.getStu_id(),sub_id);
        Subject sbj = subjectService.findSubjectById(sub_id);
        session.setAttribute("ssb",ssb);
        session.setAttribute("sbj",sbj);
        return "stu_sub_detail";
    }
    public String exit() throws Exception{
        HttpSession session = request.getSession();
        session.removeAttribute("student");
        return "exit";
    }
    public String turn_back() throws Exception{
        HttpSession session = request.getSession();
        return "turn_back";
    }

    public String change_img() throws Exception{
        HttpSession session = request.getSession();
        student = (Student)session.getAttribute("student");
        session.setAttribute("student",student);
        return "change_img";
    }
}
