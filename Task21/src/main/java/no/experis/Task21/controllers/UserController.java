package no.experis.Task21.controllers;

import no.experis.Task21.jpa.user;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@RestController
public class UserController {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");

    @RequestMapping("/users")
    @ResponseBody
    public List<String> usersFind() {
        return getNames();
    }

    @GetMapping("/user/{ID}")
    public user userGet(@PathVariable int ID) {
        List<user> userList2= getUsers();
        System.out.println("Trying to find person: " + ID);
        //userList2 = getUsers();
        user returnUser = null;
        for (user u : userList2) {
            if (u.getId()==(ID)) {
                System.out.println(" --- USER FOUND --- ");


                returnUser = u;
            }
        }
        if (returnUser == null) {
            System.out.println(" --- USER WAS NOT FOUND --- ");
        }
        return returnUser;
    }

    public static List<user> getUsers() {

        List<user> userList = null;

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            userList = manager.createQuery("SELECT s FROM user s", user.class).getResultList();


            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
        finally {
            manager.close();
        }
        return userList;
    }

    public static List<String> getNames() {

        List<String> usernameList = null;

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            usernameList = manager.createQuery("SELECT username FROM user s").getResultList();


            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
        finally {
            manager.close();
        }
        return usernameList;
    }
}
