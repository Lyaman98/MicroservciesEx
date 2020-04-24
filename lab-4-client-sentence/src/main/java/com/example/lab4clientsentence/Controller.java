package com.example.lab4clientsentence;


import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/sentence")
    public @ResponseBody String getSentence() {
        return
                getWord("lib-4-subject") + " "
                        + getWord("lib-4-adjective") + " ";
    }

    private String getWord(String service){

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(service);


        if (serviceInstanceList != null && serviceInstanceList.size() > 0){
            URI uri = serviceInstanceList.get(0).getUri();

            if (uri != null){
                return (new RestTemplate().getForObject(uri,String.class));
            }
        }
        return null;

    }
}
