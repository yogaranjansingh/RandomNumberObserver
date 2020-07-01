package com.example.RandomNumberObserver.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RandomNumberResponse {
	
	List<ArrayList<Integer>> cumulation;
	String message;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RandomNumberResponse [cumulation=").append(System.getProperty("line.separator")); 
		sb.append(cumulation).append(System.getProperty("line.separator"));
		sb.append(", message = ").append(System.getProperty("line.separator")); 
		sb.append(message);
		return sb.toString();
	}
}
