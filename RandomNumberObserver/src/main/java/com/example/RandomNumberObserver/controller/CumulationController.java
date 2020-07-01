package com.example.RandomNumberObserver.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RandomNumberObserver.model.CumulatedData;
import com.example.RandomNumberObserver.model.RandomNumberResponse;
import com.example.RandomNumberObserver.model.RandomNumberResponseHelper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CumulationController {
	
	@Autowired
	CumulatedData data;
	
	@Autowired
	RandomNumberResponseHelper responseHelper;
	
    @GetMapping("/getCumulation")
    public ResponseEntity getCumulation(@RequestParam int delta) {
    
    	RandomNumberResponse response = responseHelper.getCumulatedData(delta);
		return new ResponseEntity(response, HttpStatus.OK);
    }
    
    @GetMapping("/getOverallCumulation")
    public ResponseEntity getCumulation() {
    	RandomNumberResponse responseFiveMinutes = responseHelper.getCumulatedData(5);
    	RandomNumberResponse responseFifteenMinutes = responseHelper.getCumulatedData(15);
    	RandomNumberResponse responseThirtyMinutes = responseHelper.getCumulatedData(30);
    	List<RandomNumberResponse> cumulatedData = new ArrayList<RandomNumberResponse>();
    	cumulatedData.add(responseFiveMinutes);
    	cumulatedData.add(responseFifteenMinutes);
    	cumulatedData.add(responseThirtyMinutes);
    	return new ResponseEntity(cumulatedData, HttpStatus.OK);
    }
    
   

}
