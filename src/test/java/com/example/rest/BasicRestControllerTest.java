package com.example.rest;

import java.util.Collection;

import com.example.domain.Stuff;
import com.example.persist.StuffPersistenceService;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.internal.util.collections.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BasicRestControllerTest {

    @Autowired
    BasicRestController basicRestController;

    @MockBean
    StuffPersistenceService stuffPersistenceService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void thatGetStuffReturnsStuff() throws Exception {

        given(stuffPersistenceService.getStuff()).willReturn(Sets.newSet(Stuff.builder()
                                                                             .firstName("Bob")
                                                                             .lastName("Example")
                                                                             .age(18)
                                                                             .build(),
                                                                         Stuff.builder()
                                                                             .firstName("Alice")
                                                                             .lastName("Example")
                                                                             .age(20)
                                                                             .build()));

        ResponseEntity<Collection<Stuff>> responseEntity = restTemplate.exchange("/",
                                                                                 HttpMethod.GET,
                                                                                 null,
                                                                                 new ParameterizedTypeReference<Collection<Stuff>>() {

                                                                                 });

        Collection<Stuff> stuffList = responseEntity.getBody();

        assertEquals(2, stuffList.size());
    }

    @Test
    public void thatAddStuffAddsStuff() throws Exception {

        Stuff george = Stuff.builder()
            .firstName("George")
            .lastName("Example")
            .age(23)
            .build();

        restTemplate.postForObject("/", george, Void.class);

        verify(stuffPersistenceService, times(1)).addStuff(eq(george));

    }

}