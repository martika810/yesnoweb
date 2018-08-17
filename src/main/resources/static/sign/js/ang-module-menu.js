console.log("Loaded angular menu module");
var menuApp = angular.module('menuApp',[]);
menuApp.controller('menuController',function($scope,$http){

    $scope.displayContributeForm = function(){
        $http.get('http://localhost:8087/sign/contribute_form.html')
            .then(function(response){
                $scope.addHtmlPiece = response.data;
                $scope.cleanupSnippetPanel();
                jQuery('#snippetPanel').prepend($scope.addHtmlPiece);
            });
    }

    $scope.cleanupSnippetPanel = function(){
        jQuery('#snippetPanel').empty();
    }
    $scope.populateGroupMenu = function(){
        $http.get('http://localhost:8087/snippet/group/listall')
            .then(function(response){
                $scope.groupList = response.data;
            });
    }

    $scope.populateGroupMenu();

});
