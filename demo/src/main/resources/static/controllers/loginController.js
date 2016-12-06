app
    .controller('loginController',function($scope, $location, $http,$rootScope){
        console.log("login controller");
    $scope.ok = function(){
        $http({
            method : 'POST',
            url: '/loginPage',
            data:{
                username: $scope.username,
                password: $scope.password,
            }
        }).then(function successCallback(response){
            console.log(response.data);
            if(response.data){
                $location.path('/weather');
                console.log("weather");
                $rootScope.username = $scope.username;
            }
            console.log(response);
        })
    }
}
);