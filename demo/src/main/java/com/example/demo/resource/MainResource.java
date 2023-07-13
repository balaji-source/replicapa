package com.example.demo.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainResource {

    private static final Logger log = LogManager.getLogger(MainResource.class);

    private static List<String> dataList = new LinkedList<>();

    @GetMapping("/live")
    public String getLiveness() {
        log.debug("/live api called. Logging at debug");
        log.info("/live api called. Logging at info");
        log.warn("/live api called. Logging at warn");
        return "{\"Status\":\"UP\"}";
    }

    @PostMapping("/add")
    public boolean addData(String data) {
        log.debug("/add api called. adding data: " + data);
        dataList.add(data);
        log.debug("/add api done. added data: " + data);
        return true;
    }

    @GetMapping("/data")
    public List<String> getData() {
        log.debug("/data api called. returning data: " + dataList);
        if (dataList.size() / 20 > 1) {
            log.warn("/data api called. size crossing limit: " + dataList.size());
            log.error("/data api called.size crossing limit: " + dataList.size());
        }
        return dataList;
    }

}
