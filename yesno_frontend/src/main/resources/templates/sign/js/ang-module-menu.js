console.log("Loaded angular menu module");
var menuApp = angular.module('menuApp',["ngCookies"]);
menuApp.controller('menuController',function($scope,$http,$location,$cookies){

    var hostUrl = $location.protocol() + '://'+ $location.host() +':'+  $location.port();
    if($cookies.get("access_token")){
        console.log("there is access token");
        $http.defaults.headers.common.Authorization= 'Bearer ' + $cookies.get("access_token");
        $scope.isLoggedIn = true;
    }else{
        //obtainAccessToken($scope.refreshData);
        console.log("there is noooo access token");
        $scope.isLoggedIn = false;
        window.location.href = "../login";
    }
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
        //var config = {headers:  {"Authorization" : 'Bearer '+ $cookies.get("access_token")}};
        $http.get(hostUrl+'/snippet/group/listall')
            .then(function(response){
                $scope.groupList = response.data;
            });
    }

    $scope.populateGroupMenu();

});
