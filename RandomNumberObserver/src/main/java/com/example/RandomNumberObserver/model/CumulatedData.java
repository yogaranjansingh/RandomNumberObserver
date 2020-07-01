package com.example.RandomNumberObserver.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class CumulatedData {
	
	public Map<Long, List<Integer>> cummulated = new HashMap<Long, List<Integer>>();
	
}
