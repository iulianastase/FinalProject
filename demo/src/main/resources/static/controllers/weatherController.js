app
    .controller('weatherController', function($scope, $location, $http,$rootScope) {
        $scope.city = '';
        $scope.response = {};
       // $scope.username = '';
        $scope.userCities = {};


        // $scope.setWeather = function(){
        //     var url = 'http://localhost:8080/user/' + $rootScope.username;
        //     console.log(url);
        //     $http({
        //         method : 'Put',
        //         url: url,
        //         data: $scope.city
        //
        //     }).then(function successCallback(response){
        //         console.log(response.data);
        //        // $scope.response = response.data;
        //         //console.log(response);
        //         //$location.path('/weather');
        //
        //     })
        // }
        // $scope.username = $rootScope.username;
        $scope.getWeather = function(){
            var url = 'http://localhost:8080/city/' + $scope.city;
            console.log(url);
            $http({
                method : 'Get',
                url: url

            }).then(function successCallback(response){
               // $scope.setWeather();
                console.log(response.data);
                $scope.response = response.data;
                console.log(response);
                //$location.path('/weather');

            })
        }

        $scope.getCities = function () {
            var url = 'http://localhost:8080/city/name/' + $scope.username;
            console.log(url);
            $http({
                method: 'GET',
                url: url
            }).then(function successCallback(response) {
                $scope.userCities = response.data;
                console.log($scope.userCities);
                //$location.path('/weather');
            })
        }
           $scope.getCities();
    }
);
