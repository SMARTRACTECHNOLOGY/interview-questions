package com.example.persist;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.example.domain.Stuff;

import org.springframework.stereotype.Component;

/**
 * @author voor
 */
@Component
public class StuffPersistenceService {

    Set<Stuff> stuffList = new HashSet<>();

    /**
     * Adds stuff for persistence and later use.
     *
     * @param stuff
     */
    public void addStuff(Stuff stuff) {

        stuffList.add(stuff);
    }

    public Collection<Stuff> getStuff() {

        // Uh-oh, this is empty?
        return Collections.emptySet();
    }

}
