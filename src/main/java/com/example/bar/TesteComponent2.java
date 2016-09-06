package com.example.bar;

import com.example.entity.Teste;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Giovanni Silva
 */
@Repository
public class TesteComponent2 implements ApplicationListener<ContextRefreshedEvent> {

    @PersistenceContext(unitName = "bar")
    private EntityManager barEm;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        barEm.persist(new Teste());
        List<Teste> resultList = barEm.createQuery("select t from Teste t").getResultList();
        System.out.println("Listando Bar");
        for(Teste t : resultList){
            System.out.println(t);
        }
    }
}
