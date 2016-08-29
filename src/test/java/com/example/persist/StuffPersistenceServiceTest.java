package com.example.persist;

import com.example.domain.Stuff;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author voor
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StuffPersistenceServiceTest {

    @Autowired
    StuffPersistenceService stuffPersistenceService;

    @Test
    public void thatAddStuffWorksOnce() throws Exception {

        stuffPersistenceService.addStuff(Stuff.builder()
                                             .firstName("Bob")
                                             .lastName("Example")
                                             .age(18)
                                             .build());

        assertEquals(1,
                     stuffPersistenceService.getStuff()
                         .size());

    }

    @Test
    public void thatGetStuffReturnsStuff() throws Exception {

        fail();
    }

}