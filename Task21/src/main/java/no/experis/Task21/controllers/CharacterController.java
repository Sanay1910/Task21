package no.experis.Task21.controllers;

import no.experis.Task21.jpa.characters;
import no.experis.Task21.jpa.classes;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CharacterController {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");


    @RequestMapping("/character")
    @ResponseBody
    public List<characters> charactersFind() {
        return getCharacters();
    }

    @GetMapping("/character/{ID}")
    public characters characterGet(@PathVariable int ID) {
        List<characters> charactersList2 = getCharacters();
        System.out.println("Trying to find character: " + ID);
        //userList2 = getUsers();
        characters returnCharacter = null;
        for (characters ch : charactersList2) {
            if (ch.getId() == (ID)) {
                System.out.println(" --- CHARACTER FOUND --- ");

                returnCharacter = ch;
            }
        }
        if (returnCharacter == null) {
            System.out.println(" --- CHARACTER WAS NOT FOUND --- ");
        }
        return returnCharacter;
    }

    public static List<characters> getCharacters() {
        List<characters> charList = null;

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            charList = manager.createQuery("SELECT s FROM characters s", characters.class).getResultList();


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            manager.close();
        }
        return charList;
    }


}
