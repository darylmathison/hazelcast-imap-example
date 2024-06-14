package com.darylmathison.hazelcast.test;

import com.darylmathison.hazelcast.imap.data.Person;
import com.darylmathison.hazelcast.imap.processor.EntryProcessorExample;
import com.darylmathison.hazelcast.rule.HazelcastInstanceResource;
import com.hazelcast.map.IMap;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Daryl on 5/21/2015.
 */
public class EntryProcessorExampleIT {
    @ClassRule
    public static HazelcastInstanceResource hazelcastInstanceResource = new HazelcastInstanceResource();

    @Test
    public void getSadieFromMap() {
        IMap<Long, Person> map = hazelcastInstanceResource.getMap();
        map.loadAll(true);
        EntryProcessorExample entryProcessorExample = new EntryProcessorExample();
        Map<Long, Person> results = map.executeOnEntries(entryProcessorExample);

        assertEquals(1, results.size());
        boolean sadieFound = false;
        for(Map.Entry<Long, Person> entry: results.entrySet()) {
            sadieFound = (entry.getValue() != null);
        }
        assertTrue(sadieFound);
    }
}
