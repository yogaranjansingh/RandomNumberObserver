package com.example.RandomNumberObserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.RandomNumberObserver.persistence.RandomNumberObservable;
import com.example.RandomNumberObserver.persistence.RandomNumberObserver;

@SpringBootApplication
@EnableScheduling
public class RandomNumberObserverApplication {

	@Autowired
	RandomNumberObservable numberObservable;
	
	@Autowired
	RandomNumberObserver numberObserver;
	 
	
	public static void main(String[] args) {
		SpringApplication.run(RandomNumberObserverApplication.class, args);
	}
	
	@Scheduled(fixedDelay = 1000)
	void emitEverySecond()
	{
		numberObservable.emit();
	}

}
