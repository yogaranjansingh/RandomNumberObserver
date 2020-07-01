package com.example.RandomNumberObserver.persistence;

import java.util.Observable;
import java.util.Observer;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RandomNumberObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		log.info("3 random numbers emitted " + arg.toString());
	}
	
}
