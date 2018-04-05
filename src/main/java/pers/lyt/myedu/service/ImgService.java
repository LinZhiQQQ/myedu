package pers.lyt.myedu.service;

import pers.lyt.myedu.entity.MyImage;

import java.util.List;

public interface ImgService {

    public void saveImage(MyImage myImage);

    public void updateImage(MyImage myImage);

    public MyImage findImageById(int id);

    public void deleteImage(MyImage myImage);

    public List<MyImage> findAllList();


    public MyImage findImageByUserId(Integer id);

}
