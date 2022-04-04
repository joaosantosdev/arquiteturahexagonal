package br.com.ourmind.personmicroservice.commons;


import java.util.UUID;

public class UUIDUtil {
    private static String instanceId;

    public static final String getInstanceId(){
        if(instanceId == null){
            instanceId = UUID.randomUUID().toString();
        }
        return instanceId;
    }
}
