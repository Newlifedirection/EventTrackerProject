window.addEventListener('load', function(evt) {
	init();
})

function init() {
	document.getElementById('seeAll').addEventListener('click',
			function(event) {
				event.preventDefault();
				getAllRides();
			});
	document.getElementById('updateRide').addEventListener('submit',
			function(event) {
				event.preventDefault();
				trackerForm.updateRide();
			});
	document.getElementById('addRide').addEventListener('submit',
			function(event) {
				event.preventDefault();
				trackerForm.addRide();
			});
	document.getElementById('showOne').addEventListener('click',
			function(event) {
				event.preventDefault();
				getOneRide();
			});
	document.getElementById('delete').addEventListener('click',
			function(event) {
				event.preventDefault();
				deleteRide();
			});
};

function getAllRides() {
	var xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/rides', true);
	xhr.onreadystatechange = function() {

		if (xhr.status < 400 && xhr.readyState === 4) {
			var allRides = JSON.parse(xhr.responseText);

			displayAllRides(allRides);
		}

		if (xhr.readyState === 4 && xhr.status >= 400) {
			let errDiv = document.getElelementById("user-feedback");
			errDiv.textContent = "Ride not found"
		}
	};
	xhr.send(null);
}

function displayAllRides(rides) {

	var ridesDiv = document.getElementById('ridesData');

	// let ridesDiv.textContent = '';
	let table = document.createElement('table');
	ridesDiv.appendChild(table);

	rides.forEach(function(ride, index) {
		console.log(ride);
		let tr = document.createElement('tr');
		let rideName = document.createElement('td');
		rideName.textContent = ride.name;
		tr.appendChild(rideName);

		let rideDate = document.createElement('td');
		rideDate.textContent = ride.date;
		tr.appendChild(rideDate);

		let rideLocation = document.createElement('td');
		rideLocation.textContent = ride.location;
		tr.appendChild(rideLocation);

		let rideLength = document.createElement('td');
		rideLength.textContent = ride.length;
		tr.appendChild(rideLength);

		let rideDetails = document.createElement('td');
		rideDetails.textContent = ride.details;
		tr.appendChild(rideDetails);

		table.appendChild(tr);
		tr.addEventListener('click', function(evt) {
			console.log(ride.id);
			getRide(ride.id);
		});
	})
}

function getOneRide() {
	let rideId = document.getElementById("id").value;
	var xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/rides/' + rideId, true);
	xhr.onreadystatechange = function() {
		console.log('ReadyState: ' + xhr.readyState);
		console.log('Status' + xhr.status);
		if (xhr.status < 400 && xhr.readyState === 4) {
			var oneRide = JSON.parse(xhr.responseText);
			console.log(oneRide);

			displayOneRide(oneRide);
		}

		if (xhr.readyState === 4 && xhr.status >= 400) {
			let errDiv = document.getElelementById("rideData");
			err.textContent = "Ride not found"
		}
	};
	xhr.send(null);
}

function displayOneRide(ride) {
	var ridesDiv = document.getElementById('ridesData');
	ridesDiv.textContent = '';

	var rides = document.getElementById('ridesData');
	var header = document.createElement('h1');
	var ul = document.createElement('ul');
	var rideName = document.createElement('header');
	var rideDate = document.createElement('li');
	var rideLocation = document.createElement('li');
	var rideLength = document.createElement('li');
	var rideDetails = document.createElement('li');
	var blockquote = document.createElement('blockquote');
	header.textContent = ride.name;
	rides.appendChild(header);
	ul.appendChild(rideName);
	rideDate.textContent = ride.date;
	rides.appendChild(ul);
	ul.appendChild(rideDate);
	rideLocation.textContent = ride.location;
	rides.appendChild(ul);
	ul.appendChild(rideLocation);
	rideLength.textContent = ride.length;
	rides.appendChild(ul);
	ul.appendChild(rideLength);
	rideDetails.textContent = ride.details;
	rides.appendChild(ul);
	ul.appendChild(rideDetails);

	let rideId = ride.id;
}

function deleteRide() {
	var xhr = new XMLHttpRequest();
	let rideId = document.getElementById("id").value;
	xhr.open('DELETE', 'api/rides/' + rideId, true);
	xhr.onreadystatechange = function() {
		console.log('ReadyState: ' + xhr.readyState);
		console.log('Status' + xhr.status);
		if (xhr.status < 400 && xhr.readyState === 4) {
			var oneRide = JSON.parse(xhr.responseText);
			console.log(oneRide);

		}

		if (xhr.readyState === 4 && xhr.status >= 400) {
			let errDiv = document.getElelementById("rideData");
			err.textContent = "Ride not found"
		}
	};
	xhr.send(null);
}

function updateRide() {
	// console.log("Listener added");
	var xhr = new XMLHttpRequest();
	let rideId = document.getElementById("id").value;
	xhr.open('POST', 'api/rides/', +rideId, true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) { // Ok or Created
				var data = JSON.parse(xhr.responseText);
				console.log(data);
				getAllRides(data.id);
			} else {
				console.log("POST request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};
	let rideObject = {
		name : document.trackerForm.name.value,
		date : document.trackerForm.date.value,
		location : document.trackerForm.location.value,
		length : document.trackerForm.length.value,
		details : document.trackerForm.details.value

	};
	var rideObjectJSON = JSON.stringify(rideObject);
	console.log(rideObject);
	console.log(rideObjectJSON);
	xhr.send(rideObjectJSON);
}

function addRide(e) {
	// console.log("Listener added");
	var xhr = new XMLHttpRequest();
	// let rideId = document.getElementById("addRide").value;
	xhr.open('POST', 'api/rides/', true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) { // Ok or Created
				var data = JSON.parse(xhr.responseText);
				console.log(data);
				getAllRides(data.id);
			} else {
				console.log("POST request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};

	// var rides = document.getElementById('ridesData');
	var header = document.createElement('h1');
	var ul = document.createElement('ul');
	var rideName = document.createElement('header');
	var rideDate = document.createElement('li');
	var rideLocation = document.createElement('li');
	var rideLength = document.createElement('li');
	var rideDetails = document.createElement('li');
	var blockquote = document.createElement('blockquote');
	header.textContent = ride.name;
	rides.appendChild(header);
	ul.appendChild(rideName);
	rideDate.textContent = ride.date;
	rides.appendChild(ul);
	ul.appendChild(rideDate);
	rideLocation.textContent = ride.location;
	rides.appendChild(ul);
	ul.appendChild(rideLocation);
	rideLength.textContent = ride.length;
	rides.appendChild(ul);
	ul.appendChild(rideLength);
	rideDetails.textContent = ride.details;
	rides.appendChild(ul);
	ul.appendChild(rideDetails);

	let rideId = ride.id;
	let rideObject = {
		name : document.trackerForm.name.value,
		date : document.trackerForm.date.value,
		location : document.trackerForm.location.value,
		length : document.trackerForm.length.value,
		details : document.trackerForm.details.value

	};
	// var rideObjectJSON = JSON.stringify(rideObject);
	// console.log(rideObject);
	// console.log(rideObjectJSON);
	// xhr.send(rideObjectJSON);
}
