console.log("Loaded angular snippet editor module");
var snippetEditorApp = angular.module('snippetEditorApp',[]);
snippetEditorApp.factory('actionTypeFactory', ['$resource', '$location', function($resource, $location){
  return $resource($location.protocol() + '://'+ $location.host() +':'+  $location.port()  +'82/somelocation')
}]);
snippetEditorApp.controller('snippetEditorController',function($scope,$http,$location){
    $scope.hideSnippetEditor = function(){
        jQuery('.sliding-section').slideUp();
        jQuery('#snippetPanel').slideDown();
    }

});

angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("snippetEditorPanel"), ['snippetEditorApp']);
});