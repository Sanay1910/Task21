package no.experis.Task21;

import no.experis.Task21.jpa.characters;
import no.experis.Task21.jpa.user;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@RestController
public class AddStuff {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");

    @PostMapping("/user")
    public user createUser(@RequestBody user u) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();


            u.setUsername(u.getUsername());
            u.setPassword(u.getPassword());

            manager.persist(u);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return u;
    }

    @PostMapping("/character")
    public characters createCharacter(@RequestBody characters ch) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();


            ch.setName(ch.getName());
            ch.setLevel(ch.getLevel());
            ch.setClassId(ch.getClassId());
            ch.setUserId(ch.getUserId());

            manager.persist(ch);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return ch;
    }

}
