package com.example.model;

import com.example.entity.Teste;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Giovanni Silva
 */
@Repository
public class TesteComponent implements ApplicationListener<ContextRefreshedEvent> {
    @PersistenceContext(unitName = "foo")
    private EntityManager em;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        em.persist(new Teste());
    }
}
