package com.darylmathison.hazelcast.imap.processor;

import com.darylmathison.hazelcast.imap.data.Person;
import com.hazelcast.map.AbstractEntryProcessor;

import java.util.Map;

/**
 *
 * @author Daryl
 */
public class EntryProcessorExample extends AbstractEntryProcessor<Long, Person> {

    public Object process(Map.Entry<Long, Person> entry) {
        System.out.println(entry.getValue().getName().getFirst());
        if(entry.getValue().getName().getFirst().equalsIgnoreCase("Sadie")) {
            System.out.println("found Sadie");
            return entry.getValue();
        }
        return null;
    }
}
