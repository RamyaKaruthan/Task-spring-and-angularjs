(function() {

	var app = angular.module('myApp', []);
	app.controller('LoginCtrl',function($scope, $http) {
						var self = this;
						self.loginpage = {};
						self.Login = function() {


							HTTPService
									.postRequest({
										url : "http://localhost:8080/Task/user/login",
										method:"POST",
										data : self.loginpage,
										headers : {
											"Content-Type" : "application/x-www-form-urlencoded; charset=utf-8"

										}
									});
						};

					})
})();
