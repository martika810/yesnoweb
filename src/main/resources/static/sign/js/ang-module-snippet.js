console.log("Loaded angular snippet module");
var snippetApp = angular.module('snippetApp',[]);
snippetApp.controller('snippetController',function($scope,$http){

    $scope.populateSnippetPanel = function(){
        $http.get('http://localhost:8087/snippet/listall')
            .then(function(response){
               $scope.snippetList = response.data;
            });
    };

    $scope.displayHtmlSnippet = function(snippetId){
        $http.get('http://localhost:8087/snippet/html/'+snippetId)
            .then(function(response){
               $scope.selectedHtmlSnippet = response.data;
            });
        jQuery('#displayHtmlModal').addClass('show');
    }
    $scope.cleanupSnippetPanel = function(){
        jQuery('#snippetPanel').find('.snippetList').remove();
    }

    $scope.deleteSnippet = function(snippetId){
        $http.delete('http://localhost:8087/snippet/' + snippetId)
            .then(function(){
                console.log('Deleted!');
                $scope.cleanupSnippetPanel();
                $scope.populateSnippetPanel();
                jQuery('.breadcrumbs #add-snippet').removeAttr("disabled");
        });

    }
    $scope.createListenerAddSnippet = function(){
            jQuery('.breadcrumbs #add-snippet').click(function(){
                $http.get('http://localhost:8087/sign/new_snippet.html')
                     .then(function(response){
                               $scope.addHtmlPiece = response.data;
                               jQuery('#snippetPanel').prepend($scope.addHtmlPiece);
                               jQuery('.breadcrumbs #add-snippet').attr("disabled", "disabled");
                               jQuery('#confirm-add-snippet').click(function(){
                                   var newSnippet = {};
                                   newSnippet.note = jQuery('#new-snippet-note').val();
                                   newSnippet.data = jQuery('#new-snippet-question').val();
                                   newSnippet.group = 'default';
                                   $http.post('http://localhost:8087/snippet/create',newSnippet)
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
