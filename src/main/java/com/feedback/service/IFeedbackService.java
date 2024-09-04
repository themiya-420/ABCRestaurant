package com.feedback.service;

import java.util.ArrayList;

import com.feedback.model.feedback;

public interface IFeedbackService {
	
	public void addFeedback(feedback feedback);
	
	public ArrayList<feedback> getFeedbacks();
	
	public void deleteFeedback(String id);

}
