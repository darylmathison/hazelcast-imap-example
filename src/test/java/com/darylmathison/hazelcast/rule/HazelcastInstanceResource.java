package com.darylmathison.hazelcast.rule;

import com.darylmathison.hazelcast.imap.data.Person;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.junit.rules.ExternalResource;

import java.util.ResourceBundle;

/**
 * Created by Daryl on 4/27/2015.
 */
public class HazelcastInstanceResource extends ExternalResource {

    private HazelcastInstance instance;
    private IMap<Long, Person> map;
    private final ResourceBundle settings = ResourceBundle.getBundle("test");

    @Override
    protected void before() throws Throwable {
        super.before();

        instance = Hazelcast.newHazelcastInstance();
        MapConfig config = instance.getConfig().getMapConfig(settings.getString("map.name"));
        MapStoreConfig mapStoreConfig = new MapStoreConfig();
        mapStoreConfig.setEnabled(true);
        mapStoreConfig.setClassName("com.darylmathison.hazelcast.imap.store.PersonStore");
        config.setMapStoreConfig(mapStoreConfig);
        map = instance.getMap(settings.getString("map.name"));
    }

    @Override
    protected void after() {
        super.after();
        instance.shutdown();
    }

    public HazelcastInstance getInstance() {
        return instance;
    }

    public IMap<Long, Person> getMap() {
        return map;
    }
}
