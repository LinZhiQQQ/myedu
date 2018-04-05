package pers.lyt.myedu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import pers.lyt.myedu.entity.MyImage;
import pers.lyt.myedu.service.ImgService;
import pers.lyt.myedu.service.StudentService;
import pers.lyt.myedu.service.TeacherService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
import java.io.*;

@SuppressWarnings("serial")
public class AddImgAction extends ActionSupport implements ServletRequestAware {

    @Resource
    private ImgService imgService;

    private static final long serialVersionUID = 1L;

    private HttpServletRequest request;
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

    @SuppressWarnings("unchecked")
    public String execute(){
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        String userType = (String) session.getAttribute("userType");
        if(file == null){
            System.out.println("file 为空");
            if(userType == "student"){
                return "stu_error";
            }else{
                return "tch_error";
            }
        }else{
            System.out.println("file = " + file);
            File destFile = null;
            //获得图片保存的路径
            String root = ServletActionContext.getServletContext().getRealPath("/upload");
            String indexPath = request.getContextPath();
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+indexPath+"/";

            try {
                InputStream is = new FileInputStream(file);
                destFile = new File(root,this.getFileFileName());

                FileUtils.copyFile(file, destFile);

                //把图片写入到上面设置的路径里
                OutputStream os = new FileOutputStream(destFile);
                byte[] buffer = new byte[400];
                int length  = 0 ;
                while((length = is.read(buffer))>0){
                    os.write(buffer, 0, length);
                }

                System.out.println("user id = " + userId);
                MyImage myImage= imgService.findImageByUserId((Integer)session.getAttribute("userId"));
                if(myImage == null){
                    myImage = new MyImage();
                    myImage.setUserId(userId);
                    myImage.setUrl(basePath + "upload/" + destFile.getName());
                    //把图片添加到数据库
                    imgService.saveImage(myImage);
                }else{
                    myImage.setUrl(basePath + "upload/" + destFile.getName());
                    imgService.updateImage(myImage);
                }

                is.close();
                os.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            MyImage img = imgService.findImageByUserId(userId);
            session.setAttribute("img",img);
            if(userType == "student"){
                return "stu_success";
            }else{
                return "tch_success";
            }
        }
    }

}

