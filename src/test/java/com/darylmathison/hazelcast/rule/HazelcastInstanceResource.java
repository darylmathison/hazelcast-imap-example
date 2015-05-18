package com.darylmathison.hazelcast.rule;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;
import org.junit.rules.ExternalResource;

/**
 * Created by Daryl on 4/27/2015.
 */
public class HazelcastInstanceResource extends ExternalResource {
    public static final String SERVICE_NAME = "Charlotte";
    HazelcastInstance instance;
    IExecutorService service;

    @Override
    protected void before() throws Throwable {
        super.before();
        instance = Hazelcast.newHazelcastInstance();
        service = instance.getExecutorService(SERVICE_NAME);
    }

    @Override
    protected void after() {
        super.after();
        service.shutdown();
        instance.shutdown();
    }

    public HazelcastInstance getInstance() {
        return instance;
    }

    public IExecutorService getService() {
        return service;
    }
}
