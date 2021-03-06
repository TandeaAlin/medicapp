package com.medicapp.service;

import java.util.Date;
import java.util.List;

import com.medicapp.data.access.WorkScheduleDAO;
import com.medicapp.data.access.WorkScheduleDAOImpl;
import com.medicapp.data.model.WorkSchedule;

public class WorkScheduleService {

	private static WorkScheduleDAO w = new WorkScheduleDAOImpl();

	public static void addWorkSchedule(WorkSchedule schedule, int idstaff) {
		w.addSchedule(schedule.getWorkday(), schedule.getStartHour(), schedule.getEndHour(), idstaff);
	}
	
	public static List<WorkSchedule> getEntireSchedule(int idstaff){
		return w.getEntireSchedule(idstaff);
	}
	
	@SuppressWarnings("deprecation")
	public static WorkSchedule getScheduleDay(int idstaff ,int day , int month , int year){
		Date date = new Date();
		date.setDate(day);
		date.setMonth(month-1);
		date.setYear(year  - 1900);
		System.out.println(date);
		int weekday = date.getDay();
		return w.getSpecificDaySchedule(idstaff, weekday);
	}
	
	public static WorkSchedule getSchedule(int idworkschedule){
		return w.getSchedule(idworkschedule);
	}
	
	public static void updateWorkSchedule( WorkSchedule work){
		w.updateSchedule(work.getIdWorkSchedule(), work.getWorkday(), work.getStartHour(), work.getEndHour());
	}
}
