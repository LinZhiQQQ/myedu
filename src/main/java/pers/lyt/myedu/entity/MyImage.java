package pers.lyt.myedu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_img")
public class MyImage {
    private Integer id,userId;
    private String url;
    @Id
    @GenericGenerator(name = "generator", strategy = "native")
    @GeneratedValue(generator = "generator")

    @Column(name = "id", length=20)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "userId", length=20)
    public Integer getUserId(){return userId;};
    public void setUserId(Integer userId){this.userId = userId;}

    @Column(name = "url", length=255)
    public String getUrl(){return url;}
    public void setUrl(String url){this.url = url;}

    @Override
    public String toString() {
        return "MyImage{" +
                "id=" + id +
                ", userId=" + userId +
                ", url='" + url + '\'' +
                '}';
    }
}
