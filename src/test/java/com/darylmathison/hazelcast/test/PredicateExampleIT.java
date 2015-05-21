package com.darylmathison.hazelcast.test;


import com.darylmathison.hazelcast.imap.data.Person;
import com.darylmathison.hazelcast.imap.query.PredicateExample;
import com.darylmathison.hazelcast.rule.HazelcastInstanceResource;
import com.hazelcast.core.IMap;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertFalse;

public class PredicateExampleIT {

    @ClassRule
    public static HazelcastInstanceResource hazelcastInstanceResource = new HazelcastInstanceResource();

    @Test
    public void GetEveryoneButSashaFromMap() {
        final IMap<Long, Person> map = hazelcastInstanceResource.getMap();
        final Collection<Person> persons = PredicateExample.findPerson(map);
        boolean sashaPresent = false;

        for(Person p: persons) {
            sashaPresent = p.getName().getFirst().equalsIgnoreCase("Sasha");
        }
        assertFalse(map.isEmpty());
        assertFalse(sashaPresent);

    }
}
