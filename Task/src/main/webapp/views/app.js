(function() {

	var app = angular.module('myApp', []);
	app.controller('RegisterCtrl',function($scope, $http) {
						var self = this;
						self.loginpage = {};
						self.Register = function() {


							HTTPService
									.postRequest({
										url : "http://localhost:8080/Task/user/signup",
										method:"POST",
										data : self.loginpage,
										headers : {
											"Content-Type" : "application/x-www-form-urlencoded; charset=utf-8"

										}
									});
						};

					})
})();
