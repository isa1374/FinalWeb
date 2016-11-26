var primerApp= angular.module("primerApp", [])
allowCrossDomain = function(req, res, next) {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE,OPTIONS');
  res.header('Access-Control-Allow-Headers', 'Content-Type, Authorization, Content-Length, X-Requested-With');
  if ('OPTIONS' === req.method) {
    res.send(200);
  } else {
    next();
  }
};
primerApp.factory('authInterceptor', function ($rootScope, $window) {
        return {
            request: function (config) {
                config.headers = config.headers || {};
                if ($window.sessionStorage.token) {
                    config.headers.Authorization = 'Bearer ' + $window.sessionStorage.token;
                }
                return config;
            }
        };
    })
    primerApp.config(function ($httpProvider) {
        $httpProvider.interceptors.push('authInterceptor');
    })
primerApp.use(allowCrossDomain);
primerApp.controller("primerAppController", function($scope,$filter,$http,$log){
    $scope.valor = 1;
    var vm = this;
    vm.authenticated = false;
    vm.user = {};
    vm.todos = [];
    $http.get('localhost:8080/divisasActivas?enabled=true').success(function(data){
        $log.debug(data);
        $scope.conversiones = data;
    });
    $scope.calcular=function(valor,original){
        $scope.conversiones.resultado=[];
        var or=[];
        or=$filter('filter')($scope.conversiones.valores,{nombre:original});
        var orVal=or[0].valor;
        angular.forEach($scope.conversiones.valores, function(item){
                if(item.convert){
                    var valorRes=Math.floor(valor/orVal*item.valor*1000)/1000;
                    $scope.conversiones.resultado.push({imagen:item.imagen,nombre:item.nombre, valor:valorRes});
                }
        });
    } 
});




