package com.prep.spring.data.demo.transaction;

import com.prep.spring.data.demo.AppConfig;
import com.prep.spring.data.demo.model.Users;
import com.prep.spring.data.demo.repository.UserJpaRespository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserTransactionTest {
    @Autowired
    UserJpaRespository userJpaRespository;

    @BeforeTransaction
    public void before() {

        System.out.println("SavedData......" + userJpaRespository.findAll());

    }

    @Rollback(false)
    @Transactional()
    @Test
    public void findAll() {
        Users users = new Users("Kasthuri", "Odin", 1000);
        userJpaRespository.save(users);
        Users user2 = new Users("Kasthura", "Odin", 1000);
        userJpaRespository.save(user2);
        System.out.println("data saved");
    }

    @AfterTransaction
    public void after() {

        System.out.println("Output for find all " + userJpaRespository.findAllByUserName("as"));
        Assert.assertTrue(userJpaRespository.count() == 2);

    }

    @AfterTransaction
    public void afterMe() {

        System.out.println("MeOutput for find all " + userJpaRespository.findAll());
        Assert.assertTrue(userJpaRespository.count() == 2);

    }
}
