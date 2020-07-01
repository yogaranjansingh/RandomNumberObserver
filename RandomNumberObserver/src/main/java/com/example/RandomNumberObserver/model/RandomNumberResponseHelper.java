package com.example.RandomNumberObserver.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Component
public class RandomNumberResponseHelper {
	
	@Autowired
	CumulatedData data;
	
	public RandomNumberResponse getCumulatedData(int delta)
    {
    	List<ArrayList<Integer>> cumumlatedNumbers = new ArrayList<ArrayList<Integer>>();
		int sum = 0;
		int count = data.getCummulated().size()*5; 
		
    	for(Entry<Long, List<Integer>> entry : data.getCummulated().entrySet() )
    	{
    		Calendar calendar = Calendar.getInstance();
    		calendar.setTime(new Date());
    		calendar.add(Calendar.MINUTE, -delta);
    		long deltaTime = calendar.getTimeInMillis();
    		
    		if(entry.getKey() > deltaTime)
    		{
    			List<Integer> randomNumbers = entry.getValue();
    			cumumlatedNumbers.add((ArrayList<Integer>) randomNumbers);
    			
    			log.info(randomNumbers.toString());
    			
    			for(int randomNumber : randomNumbers)
    			{
    				sum = sum + randomNumber;
    			}
    		}
    	}
    	
    	
    	RandomNumberResponse randomNumberResponse = new RandomNumberResponse();
    	randomNumberResponse.setCumulation(cumumlatedNumbers);
    	randomNumberResponse.setMessage("Aggregation of Numbers emitted in last " + delta + " minutes : " +"\n" + "  1)Sum = "+sum+ "\n" + " 2) Average = " +sum/count);
    	return randomNumberResponse;
    }

}
