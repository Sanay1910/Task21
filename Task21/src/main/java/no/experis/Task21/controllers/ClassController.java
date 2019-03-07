package no.experis.Task21.controllers;

import no.experis.Task21.jpa.classes;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@RestController
public class ClassController {

    @RequestMapping("/class")
    @ResponseBody
    public List<classes> classFind() {
        return getClasses();
    }

    @GetMapping("/class/{name}")
    public classes classesGet(@PathVariable String name) {
        List<classes> classesList2= getClasses();
        System.out.println("Trying to find character: " + name);
        //userList2 = getUsers();
        classes returnClass = null;
        for (classes cl : classesList2) {
            if (cl.getName().equalsIgnoreCase(name)) {
                System.out.println(" --- CLASS FOUND --- ");
                returnClass = cl;
            }
        }
        if (returnClass == null) {
            System.out.println(" --- CLASS WAS NOT FOUND --- ");
        }
        return returnClass;

    }


    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");


    public static List<classes> getClasses() {
        List<classes> classList = null;

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            classList = manager.createQuery("SELECT s FROM classes s", classes.class).getResultList();


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
        return classList;
    }

}
