package pers.lyt.myedu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import pers.lyt.myedu.entity.MyImage;
import pers.lyt.myedu.service.ImgService;
import pers.lyt.myedu.service.StudentService;
import pers.lyt.myedu.service.TeacherService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

public aspect AllImg extends ActionSupport implements ServletRequestAware {

    @Resource
    private ImgService imgService;

    @Resource
    private StudentService studentService;

    @Resource
    private TeacherService teacherService;

    private static final long serialVersionUID = 1L;

    private HttpServletRequest request;
    private HttpSession session;
    private String  detailed;
    // 封装上传文件域的属性
    private File file;
    // 封装上传文件类型的属性
    private String fileFileName;
    // 封装上传文件名的属性
    private String fileContentType;

    public ImgService getImgService() {
        return imgService;
    }

    public void setImgService(ImgService imgService) {
        this.imgService = imgService;
    }


    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String showAll () throws Exception{
        HttpSession session = request.getSession();
        MyImage img = imgService.findImageById(10);
        System.out.println(" ----- "  + img);
        session.setAttribute("img",img);
        return "showAll";
    }
}
