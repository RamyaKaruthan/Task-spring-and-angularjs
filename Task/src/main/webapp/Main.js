(function() {
	var app = angular.module("myApp", [ 'ngRoute' ]);
	app.config(function($routeProvider) {
		routeProvider.when('/login', {
			controller : 'LoginCtrl',
			templateUrl : 'WEB-INF/views/Login.html'
		}).when('/Register', {
			controller : 'RegisterCtrl',
			templateUrl : 'webapp/views/Register.html'
		}).otherwise({
			redirectTo : '/login'
		});
	
	});
}
)();