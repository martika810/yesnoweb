console.log("Loaded angular snippet module");
var snippetApp = angular.module('snippetApp',[]);
snippetApp.factory('actionTypeFactory', ['$resource', '$location', function($resource, $location){
  return $resource($location.protocol() + '://'+ $location.host() +':'+  $location.port()  +'82/somelocation')
}]);
snippetApp.controller('snippetController',function($scope,$http,$location){

    var hostUrl = $location.protocol() + '://'+ $location.host() +':'+  $location.port();
    $scope.populateSnippetPanel = function(){
        var config = {headers:  {
            "token" : "testing"
        }};
        $http.get(hostUrl+'/snippet/listall',config)
            .then(function(response){
               $scope.snippetList = response.data;
            });
    };

    $scope.selectSnippet = function(selectedSnippet){
        $scope.selectedSnippet = selectedSnippet;
    }

    $scope.saveNoteSnippet = function(event){
        if(event.which == 13){
             $scope.selectedSnippet.note = jQuery(event.currentTarget).val()
             var config = {headers:  {"token" : "testing"}};
             $http.put(hostUrl +'/snippet/'+$scope.selectedSnippet.id,$scope.selectedSnippet,config)
                .then(function(response){
                    $scope.cleanupSnippetPanel();
                    $scope.populateSnippetPanel();
                    jQuery('.breadcrumbs #add-snippet').removeAttr("disabled");
                    console.log('new snippet send');
                });
        }
    }

    $scope.saveDataSnippet = function(event){
            if(event.which == 13){
                 $scope.selectedSnippet.data = jQuery(event.currentTarget).val()
                 var config = {headers:  {"token" : "testing"}};
                 $http.put(hostUrl +'/snippet/'+$scope.selectedSnippet.id,$scope.selectedSnippet,config)
                    .then(function(response){
                        $scope.cleanupSnippetPanel();
                        $scope.populateSnippetPanel();
                        jQuery('.breadcrumbs #add-snippet').removeAttr("disabled");
                        console.log('new snippet send');
                    });
                 }
            }


    $scope.displayHtmlSnippet = function(snippetId){
        var config = {headers:  {
                "token" : "testing"
            }};
        $http.get(hostUrl+'/snippet/html/'+snippetId,config)
            .then(function(response){
               $scope.selectedHtmlSnippet = response.data;
            });
        jQuery('#displayHtmlModal').addClass('show');
    }
    $scope.cleanupSnippetPanel = function(){
        jQuery('#snippetPanel').find('.snippetList').remove();
    }

    $scope.deleteSnippet = function(snippetId){
        var config = {headers:  {"token" : "testing"}};
        $http.delete(hostUrl+'/snippet/' + snippetId,config)
            .then(function(){
                console.log('Deleted!');
                $scope.cleanupSnippetPanel();
                $scope.populateSnippetPanel();
                jQuery('.breadcrumbs #add-snippet').removeAttr("disabled");
        });

    }
    $scope.createListenerAddSnippet = function(){
            jQuery('.breadcrumbs #add-snippet').click(function(){
                $http.get(hostUrl+'/sign/new_snippet.html')
                     .then(function(response){
                               $scope.addHtmlPiece = response.data;
                               jQuery('#snippetPanel').prepend($scope.addHtmlPiece);
                               jQuery('.breadcrumbs #add-snippet').attr("disabled", "disabled");
                               jQuery('#confirm-add-snippet').click(function(){
                                   var newSnippet = {};
                                   newSnippet.note = jQuery('#new-snippet-note').val();
                                   newSnippet.data = jQuery('#new-snippet-question').val();
                                   newSnippet.group = 'default';
                                   var config = {headers:  {"token" : "testing"}};
                                   $http.post(hostUrl +'/snippet/create',newSnippet,config)
                                        .then(function(response){
                                            $scope.cleanupSnippetPanel();
                                            $scope.populateSnippetPanel();
                                            jQuery('.breadcrumbs #add-snippet').removeAttr("disabled");
                                            console.log('new snippet send');
                                        });
                                   });
                     });

            });
        }

    $scope.populateSnippetPanel();
    $scope.createListenerAddSnippet();
    $scope.activeModal = function(){
        // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
        $('.modal').modal();
    }


});

angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("snippetPanel"), ['snippetApp']);
});
