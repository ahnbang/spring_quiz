package com.quiz.lesson05;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson05.bo.WeatherHistoryBO;
import com.quiz.lesson05.model.WeatherHistory;

@RequestMapping("/lesson05")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;

	/**
	 * 히스토리 목록 화면
	 * @return
	 */
	@RequestMapping("/weather_history_view")
	public String weatherHistoryView(Model model) {
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistory();
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		return "weather/weatherHistory";
	}
	
	/**
	 * 날씨 추가 화면
	 * @return
	 */
	@RequestMapping("/add_weather_view")
	public String addWeatherView() {
		return "weather/addWeather";
	}
	
	@PostMapping("/add_weather")
	public String addWeather(
			//@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date
			@RequestParam("date") String date,
			@RequestParam("weather") String weather, 
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		return "redirect:/lesson05/weather_history_view";
	}
}





