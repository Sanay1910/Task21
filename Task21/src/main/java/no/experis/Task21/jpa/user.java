package no.experis.Task21.jpa;

import no.experis.Task21.controllers.CharacterController;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "user")
public class user implements Serializable{

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public ArrayList<characters> getCharacterList() {
        ArrayList<characters> characterList = new ArrayList<>();
        for (characters ch : CharacterController.getCharacters()) {
            if(getId()==ch.getUserId())
                characterList.add(ch);
        }
        return characterList;
    }

    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

}
