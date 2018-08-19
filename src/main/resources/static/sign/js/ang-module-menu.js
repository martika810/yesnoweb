console.log("Loaded angular menu module");
var menuApp = angular.module('menuApp',[]);
menuApp.controller('menuController',function($scope,$http,$location){

    var hostUrl = $location.protocol() + '://'+ $location.host() +':'+  $location.port();

    $scope.displayContributeForm = function(){
        $http.get(hostUrl+'/sign/contribute_form.html')
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
        var config = {headers:  {"token" : "testing"}};
        $http.get(hostUrl+'/snippet/group/listall',config)
            .then(function(response){
                $scope.groupList = response.data;
            });
    }

    $scope.populateGroupMenu();

});
