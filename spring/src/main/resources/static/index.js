angular.module('app', []).controller('indexController', function ($scope, $http, $localStorage) {
    const contextPath = 'http://localhost:8189/student';


    $scope.showStudents = function () {
        $http.get(contextPath + '/api/v1/students')
            .then(function (response) {
                $scope.Students = response.data;
            });
    };

    /*$scope.submitCreateNewProduct = function () {
        $http.post(contextPath + '/api/v1/products', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.showProductPage();
            });
    };*/

    $scope.deleteStudentById = function (studentID) {
        $http.delete(contextPath + '/api/v1/students/' + studentID).then(function (response) {
            $scope.showStudents();
        });
    };


    $scope.showStudents();
});