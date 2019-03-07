package no.experis.Task21.jpa;

import no.experis.Task21.controllers.ClassController;
import org.springframework.data.annotation.Transient;

import javax.naming.ldap.Control;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "characters")
public class characters {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Transient
    public ArrayList<classes> getClasses() {
        ArrayList<classes> classes = new ArrayList<>();
        for (classes cl : ClassController.getClasses()) {
            if((getClassId()) == cl.getId())

                classes.add(cl);
        }
        return classes;
    }

    @Override
    public String toString() {
        return "characters{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", classId=" + classId +
                ", userId=" + userId +
                '}';
    }

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "level", unique = false)
    private int level;

    @Column(name = "classId", unique = false)
    private int classId;

    @Column(name = "userId", unique = true)
    private int userId;
}
