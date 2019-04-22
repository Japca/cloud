package net.japca.dbsevice.controller;

import net.japca.dbsevice.properties.DbServiceProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jakub krhovják on 4/6/19.
 */

@RestController
public class ApiController {

    @Autowired
    private DbServiceProperties properties;


    @GetMapping("/")
    public String getJobKey() {
        return  properties.getJobKey();
    }
}
