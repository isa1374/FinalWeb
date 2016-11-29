'use strict';

/**
 * @ngdoc overview
 * @name cultura
 * @description
 * # cultura
 *
 * Main module of the application.
 */

var cultura = angular.module('cultura',[]);


var model = [];
cultura.controller('culturaController', function($scope, $http, $interval) {

 $scope.acces_token = "";
 $scope.actividades = [];

 $http.post('http://localhost:8080/api/login', {
 username: "user",
 password: "pass"
 }).then(function (response) {
 $scope.access_token=response.data.access_token;
 var req = {
 method: 'GET',
 url: 'http://localhost:8080/actividad',
 headers: {
 'Authorization': "Bearer "+$scope.access_token
 }
 }
 $http(req).then(function(res){
 var data=res.data;
 $scope.actividades=data;
 });
 });

 $interval(function(){

     var req = {
     method: 'GET',
     url: 'http://localhost:8080/actividad',
     headers: {
     'Authorization': "Bearer "+$scope.access_token
     }
 }

 $http(req).then(function(res){
 $scope.actividades=res.data;
 });

 },1000)
});