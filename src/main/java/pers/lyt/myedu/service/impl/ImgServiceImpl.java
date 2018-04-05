package pers.lyt.myedu.service.impl;

import org.springframework.stereotype.Service;
import pers.lyt.myedu.dao.BaseDao;
import pers.lyt.myedu.entity.MyImage;
import pers.lyt.myedu.service.ImgService;

import javax.annotation.Resource;
import java.util.List;

@Service("imgService")
public class ImgServiceImpl implements ImgService {

    @Resource
    private BaseDao<MyImage> baseDao;

    @Override
    public void saveImage(MyImage myImage) {
        baseDao.save(myImage);
    }

    @Override
    public void updateImage(MyImage myImage) {
        baseDao.update(myImage);
    }

    @Override
    public MyImage findImageById(int id) {
        return baseDao.get("from MyImage m where m.id=?", new Object[]{id});
    }

    @Override
    public void deleteImage(MyImage myImage) {
        baseDao.delete(myImage);
    }

    @Override
    public List<MyImage> findAllList() {
        return baseDao.find("from MyImage");
    }


    @Override
    public MyImage findImageByUserId(Integer id) {
        return baseDao.get("from MyImage m where m.userId=?",new Object[]{id});
    }


}
