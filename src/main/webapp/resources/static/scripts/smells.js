function Smells($scope, $http) {
    $http.get('http://localhost:8080/smells.json')
        .success(function (data) {
            console.log(data);
            $scope.smells = data;
        });
}