package com.example.pkmydata.controller;

import com.example.pkmydata.dto.MydataResponseDto;
import com.example.pkmydata.service.MydataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MydataController {

    @Autowired
    private final MydataService mydataService;


    public MydataController(MydataService mydataService) {
        this.mydataService = mydataService;
    }

    @GetMapping("/api/mydata")
    public MydataResponseDto getMydata(@RequestHeader("Authorization") String token){
        String jwtToken = token.substring(7);
        return mydataService.getMydata(jwtToken);
    }
}
