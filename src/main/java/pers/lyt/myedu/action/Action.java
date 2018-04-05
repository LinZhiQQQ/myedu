package pers.lyt.myedu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import pers.lyt.myedu.service.StudentService;
import pers.lyt.myedu.service.TeacherService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Action extends ActionSupport implements ServletRequestAware {
    private static final long serialVersionUID = 1L;

    private HttpServletRequest request;
    private HttpSession session;
    private String userName,userPwd,selec;

    @Resource
    private StudentService studentService;

    @Resource
    private TeacherService teacherService;


    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String to_regs() throws Exception{
        return "to_regs";
    }
    public String to_login() throws Exception{
        return "to_login";
    }
    public String tuUpload() throws Exception{
        return "tuUpload";
    }
}
