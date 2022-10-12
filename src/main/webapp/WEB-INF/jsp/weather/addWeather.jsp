<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<%-- datepicker --%>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<link rel="stylesheet" type="text/css" href="/css/lesson05/style.css">
</head>
<body>
	<div id="wrap">
		<div class="contents d-flex">
			<%-- menu --%>
			<nav class="col-2">
				<%-- 상단 로고 --%>
				<div class="logo d-flex justify-content-center mt-3">
					<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Emblem_of_the_Government_of_the_Republic_of_Korea.svg/800px-Emblem_of_the_Government_of_the_Republic_of_Korea.svg.png" width="25"> 
					<span class="text-white font-weight-bold ml-2">기상청</span>
				</div>
				
				<ul class="nav flex-column mt-4">
					<li class="nav-item">
						<a href="/lesson05/weather_history_view" class="nav-link menu-font">날씨</a>
					</li>
					<li class="nav-item">
						<a href="/lesson05/add_weather_view" class="nav-link menu-font">날씨입력</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link menu-font">테마날씨</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link menu-font">관측 기후</a>
					</li>
				</ul>
			</nav>
			
			<%-- history --%>
			<section class="col-10 mt-3 ml-5">
				<h2>날씨 입력</h2>
				<form method="post" action="/lesson05/add_weather">
					<div class="d-flex justify-content-around">
						<div class="form-group">
							<label for="date">날짜</label>
							<input type="text" class="form-control" id="date" name="date">
						</div>
						<div class="form-group">
							<label for="weather">날씨</label>
							<select name="weather" id="weather" class="form-control">
								<option>맑음</option>
								<option>구름조금</option>
								<option>흐림</option>
								<option>비</option>
							</select>
						</div>
						<div class="form-group">
							<label for="microDust">미세먼지</label>
							<select id="microDust" name="microDust" class="form-control">
								<option>맑음</option>
								<option>구름조금</option>
								<option>흐림</option>
								<option>비</option>
							</select>
						</div>
					</div>
					
					<div class="d-flex justify-content-around">
						<div class="form-group">
							<label for="temperatures">기온</label>
							<div class="input-group">
								<input type="text" class="form-control" id="temperatures" name="temperatures">
								<div class="input-group-append">
									<span class="input-group-text">℃</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="precipitation">강수량</label>
							<div class="input-group">
								<input type="text" class="form-control" id="precipitation" name="precipitation">
								<div class="input-group-append">
									<span class="input-group-text">mm</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="windSpeed">풍속</label>
							<div class="input-group">
								<input type="text" class="form-control" id="windSpeed" name="windSpeed">
								<div class="input-group-append">
									<span class="input-group-text">km/h</span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="d-flex justify-content-end">
						<input type="submit" class="btn btn-success" value="저장">
					</div>
				</form>
			</section>
		</div>
		<footer>
			<div class="footer-logo ml-4 mt-3">
				<img class="foot-logo-image"
					src="https://www.weather.go.kr/w/resources/image/foot_logo.png"
					width="120">
			</div>
			<div class="copyright ml-4">
				<small class="text-secondary"> (07062) 서울시 동작구 여의대방로16길 61 <br>
					Copyright@2020 KMA. All Rights RESERVED.
				</small>
			</div>
		</footer>
	</div>
	
<script>
	$(document).ready(function() {
		$('#date').datepicker({
			dateFormat:'yy-mm-dd'
			, changeYear: true
			, changeMonth: true
		});
	});
</script>
</body>
</html>







