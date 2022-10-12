package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson01Quiz03Controller {
	
	// 요청 URL : http://localhost:8080/lesson01/quiz03/1
	@RequestMapping("/lesson01/quiz03/1")
	public String quiz03_1() {
		return "lesson01/quiz03";  // view 경로
	}
	
}
