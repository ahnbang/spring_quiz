package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookingBO;
import com.quiz.lesson06.model.Booking;

@RequestMapping("/lesson06")
@Controller
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	/**
	 * 1) 예약 목록 화면
	 * @return
	 */
	@RequestMapping("/booking_list_view")
	public String bookingListView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "booking/bookingList";
	}
	
	// AJAX의 호출 => ResponseBody
	@ResponseBody
	@DeleteMapping("/delete_booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// 삭제 db
		int deleteCount = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (deleteCount > 0) {
			result.put("code", 100);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "삭제할 예약 내역이 없습니다.");
		}
		
		return result;
	}
	
	/**
	 * 2) 예약하기 화면
	 * @return
	 */
	@RequestMapping("/add_booking_view")
	public String addBookingView() {
		return "booking/addBooking";
	}
	
	// AJAX의 호출
	@ResponseBody
	@PostMapping("/add_booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		int addCount = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		if (addCount > 0) {
			result.put("code", 100);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "데이터를 입력하는데 실패했습니다.");
		}
		
		return result;
	}
	
	/**
	 * 3) 예약 조회 화면
	 * @return
	 */
	@RequestMapping("/main_view")
	public String mainView() {
		return "booking/main";
	}
	
	// AJAX의 요청
	@ResponseBody
	@PostMapping("/search_booking")
	public Map<String, Object> searchBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.getLatestBooking(name, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		if (booking != null) {
			result.put("code", 100); // 데이터 있음
			result.put("booking", booking);
		} else {
			result.put("code", 400); // 데이터 없음
		}
		
		return result;
	}
}







