package com.reserve.service;

import java.util.ArrayList;

import com.reserve.model.Reserve;

public interface IReserveService {
	
	public void addReserve(Reserve reserve);
	
	public ArrayList<Reserve> getReserves();
	
	public void deleteReserve(String id);

}
