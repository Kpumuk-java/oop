angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/student';


    $scope.showStudents = function () {
        $http.get(contextPath + '/api/v1/students')
            .then(function (response) {
                $scope.Students = response.data;
            });
    };

    $scope.submitCreateNewStudent = function () {
        $http.post(contextPath + '/api/v1/students', $scope.newStudent)
            .then(function (response) {
                $scope.newStudent = null;
                $scope.showStudents();
            });
    };

    $scope.deleteStudentById = function (studentID) {
        $http.delete(contextPath + '/api/v1/students/' + studentID).then(function (response) {
            $scope.showStudents();
        });
    };


    $scope.showStudents();
});