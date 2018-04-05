package pers.lyt.myedu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_subject")
public class Subject {
    private Integer id,sub_id,sub_sco,tch_id;
    private String sub_name,sub_sch;

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

    @Column(name = "sub_id", length=20)
    public Integer getSub_id() {
        return sub_id;
    }
    public void setSub_id(Integer sub_id) {
        this.sub_id = sub_id;
    }

    @Column(name = "sub_sco", length=20)
    public Integer getSub_sco() {
        return sub_sco;
    }
    public void setSub_sco(Integer sub_sco) {
        this.sub_sco = sub_sco;
    }

    @Column(name = "sub_name", length=20)
    public String getSub_name() {
        return sub_name;
    }
    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    @Column(name = "sub_sch", length=20)
    public String getSub_sch() {
        return sub_sch;
    }
    public void setSub_sch(String sub_sch) {
        this.sub_sch = sub_sch;
    }

    @Column(name = "tch_id", length=20)
    public Integer getTch_id() {
        return tch_id;
    }
    public void setTch_id(Integer tch_id) {
        this.tch_id = tch_id;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", sub_id=" + sub_id +
                ", sub_sco=" + sub_sco +
                ", tch_id=" + tch_id +
                ", sub_name='" + sub_name + '\'' +
                ", sub_sch='" + sub_sch + '\'' +
                '}';
    }
}
