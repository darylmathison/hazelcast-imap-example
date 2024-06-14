package com.darylmathison.hazelcast.imap.store;

import com.darylmathison.hazelcast.imap.data.Person;
import com.hazelcast.map.MapStore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Daryl on 5/19/2015.
 */
public class PersonStore implements MapStore<Long, Person> {

    private final Map<Long, Person> personMap;

    public PersonStore() {
        personMap = new HashMap<>();
        personMap.put(1L, new Person("Daryl", "Mathison"));
        personMap.put(2L, new Person("Sadie", "Mathison"));
        personMap.put(3L, new Person("Sasha", "Mathison"));
        personMap.put(4L, new Person("Kinsey", "Mathison"));
    }

    public Person load(Long aLong) {
        return personMap.get(aLong);
    }

    public Map<Long, Person> loadAll(Collection<Long> collection) {
        Map<Long, Person> sendOffMap = new HashMap<>();
        for(Long key: collection) {
            sendOffMap.put(key, personMap.get(key));
        }
        return sendOffMap;
    }

    public Set<Long> loadAllKeys() {
        return personMap.keySet();
    }

    public void store(Long aLong, Person person) {

    }

    public void storeAll(Map<Long, Person> map) {

    }

    public void delete(Long aLong) {

    }

    public void deleteAll(Collection<Long> collection) {

    }
}
