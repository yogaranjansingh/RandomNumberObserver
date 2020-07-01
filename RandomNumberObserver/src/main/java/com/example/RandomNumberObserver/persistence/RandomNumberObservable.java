package com.example.RandomNumberObserver.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.RandomNumberObserver.model.CumulatedData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RandomNumberObservable extends Observable {
	
	@Autowired
	CumulatedData cumulatedData;
	
	@Autowired
	RandomNumberObserver numberObserver;

	@PostConstruct
	void init()
	{
		this.addObserver(numberObserver);
	}
	
	private Random random = new Random();
	private List<Integer> randomNumbers;
	
	int getRandomNumber()
	{
		int rand = random.nextInt(100);
		return rand;
	}
	
	public void emit()
	{
		randomNumbers = new ArrayList<Integer>();
		for(int i=0;i<5;i++)
		randomNumbers.add(getRandomNumber());
		setChanged();
		notifyObservers(randomNumbers);
		cumulatedData.getCummulated().put(Calendar.getInstance().getTimeInMillis(), randomNumbers);
	
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException ie) {
			log.error(ie.getMessage());
		}
	}

}
