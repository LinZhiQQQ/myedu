package pers.lyt.myedu.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_student")
public class Student {
    private Integer id,stu_id,stu_age,stu_sex,stu_gra,stu_cls;
    private String stu_name,stu_pwd,stu_tel,stu_sch;

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

    @Column(name = "stu_id", length=20)
    public Integer getStu_id() {
        return stu_id;
    }
    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    @Column(name = "stu_name", length = 20)
    public String getStu_name() {
        return stu_name;
    }
    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    @Column(name = "stu_pwd", length = 20)
    public String getStu_pwd() {
        return stu_pwd;
    }
    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

    @Column(name = "stu_age", length=20)
    public Integer getStu_age() {
        return stu_age;
    }
    public void setStu_age(Integer stu_age) {
        this.stu_age = stu_age;
    }

    @Column(name = "stu_sex", length=20)
    public Integer getStu_sex() {
        return stu_sex;
    }
    public void setStu_sex(Integer stu_sex) {
        this.stu_sex = stu_sex;
    }

    @Column(name = "stu_tel", length=20)
    public String getStu_tel() {
        return stu_tel;
    }
    public void setStu_tel(String stu_tel) {
        this.stu_tel = stu_tel;
    }

    @Column(name = "stu_gra", length=20)
    public Integer getStu_gra() {
        return stu_gra;
    }
    public void setStu_gra(Integer stu_gra) {
        this.stu_gra = stu_gra;
    }

    @Column(name = "stu_cls", length=20)
    public Integer getStu_cls() {
        return stu_cls;
    }
    public void setStu_cls(Integer stu_cls) {
        this.stu_cls = stu_cls;
    }

    @Column(name = "stu_sch", length=20)
    public String getStu_sch() {
        return stu_sch;
    }
    public void setStu_sch(String stu_sch) {
        this.stu_sch = stu_sch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stu_id=" + stu_id +
                ", stu_age=" + stu_age +
                ", stu_sex=" + stu_sex +
                ", stu_gra=" + stu_gra +
                ", stu_cls=" + stu_cls +
                ", stu_name='" + stu_name + '\'' +
                ", stu_pwd='" + stu_pwd + '\'' +
                ", stu_tel='" + stu_tel + '\'' +
                ", stu_sch='" + stu_sch + '\'' +
                '}';
    }
}
