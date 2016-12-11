<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body style="background-color: beige;">
	<div
		style="font-family: 'museo700', sans-serif; font-size: 30px; font-weight: 400; color: #fa6900; padding: 1px; background-color:khaki; text-align: center;">
		<h1>${headerMsg}</h1>
	</div>
	<div
		style="font-family: 'museo700', sans-serif; font-size: 10px; font-weight: 400; color: brown;">
		<h1>Please enter the detail of your ride</h1>
	</div>
	<form action="/springMVC/submitFareForm.html" method="post" style="background-color: beige;">
		<p>
			Distance : <input type="text" name="rideDistance"
				style="margin-left: 71px;" />
		</p>
		<p>
			Waiting Time : <input type="text" name="waitingTime"
				style="margin-left: 38px;" />
		</p>
		<p>
			number of suitcases : <input type="text" name="nbSuit" />
		</p>
		<p>
			Night Supplement : <input type="checkbox" name="nightSup"
				style="margin-left: 15px;" />
		</p>
		<p>
			Regular client : <input type="checkbox" name="regClient"
				style="margin-left: 40px;" />
		</p>

		<div
			style="font-family: 'museo700', sans-serif; font-size: 10px; font-weight: 400; color: brown;">
			<h1>Please enter the detail of your journey</h1>
		</div>

		<p>
			Number of nights : <input type="text" name="nbOfNights"
				style="margin-left: 3px;" />
		</p>
		<p>
			Hotel Rank : <select name="hotelRank" style="margin-left: 43px;">
				<option value="1">1 star</option>
				<option value="2">2 stars</option>
				<option value="3">3 stars</option>
				<option value="4">4 stars</option>
				<option value="5">5 stars</option>
			</select>
		</p>
		<p>
			Breakfast : <input type="checkbox" name="breakfast"
				style="margin-left: 58px;" />
		</p>
		<p>
			Discount code : <input type="text" name="discountCode"
				style="margin-left: 20px;" />
		</p>

		<input type="submit" value="submit">
	</form>
	<div style="height: 20%; width: 100%; background-color: khaki"></div>
<body>
</html>