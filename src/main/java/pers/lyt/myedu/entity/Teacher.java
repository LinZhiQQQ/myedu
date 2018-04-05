package pers.lyt.myedu.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_teacher")
public class Teacher{
    private String tch_name,tch_tel,tch_sch,tch_pwd;
    private  Integer id,tch_id,tch_age,tch_sex;
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

    @Column(name = "tch_name", length=20)
    public String getTch_name() {
        return tch_name;
    }

    public void setTch_name(String tch_name) {
        this.tch_name = tch_name;
    }

    @Column(name = "tch_tel", length=20)
    public String getTch_tel() {
        return tch_tel;
    }

    public void setTch_tel(String tch_tel) {
        this.tch_tel = tch_tel;
    }

    @Column(name = "tch_sch", length=20)
    public String getTch_sch() {
        return tch_sch;
    }

    public void setTch_sch(String tch_sch) {
        this.tch_sch = tch_sch;
    }

    @Column(name = "tch_pwd", length=20)
    public String getTch_pwd() {
        return tch_pwd;
    }

    public void setTch_pwd(String tch_pwd) {
        this.tch_pwd = tch_pwd;
    }

    @Column(name = "tch_id", length=20)
    public Integer getTch_id() {
        return tch_id;
    }

    public void setTch_id(Integer tch_id) {
        this.tch_id = tch_id;
    }

    @Column(name = "tch_age", length=20)
    public Integer getTch_age() {
        return tch_age;
    }

    public void setTch_age(Integer tch_age) {
        this.tch_age = tch_age;
    }

    @Column(name = "tch_sex", length=20)
    public Integer getTch_sex() {
        return tch_sex;
    }

    public void setTch_sex(Integer tch_sex) {
        this.tch_sex = tch_sex;
    }
}
