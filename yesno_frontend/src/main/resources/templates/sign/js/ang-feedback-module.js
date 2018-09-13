console.log("Loaded widget module");
var widgetApp = angular.module('widgetApp',[]);
widgetApp.controller('widgetController',function($scope,$http,$location){
    var hostUrl = $location.protocol() + '://'+ $location.host() +':'+  $location.port();
    $scope.senderRenderConfirmation = function(){
        var sourceUrl = $location.host;
        var widgetId = document.getElementById('widgetPanel').getAttribute('data-widget-id');
        var config = {headers:  {"Content-Type" : 'application/json'}};
        $http.put(hostUrl+'/snippet/confirm/'+widgetId,JSON.stringify(sourceUrl),config)
            .then(function(response){
                console.log('confirmation sent successfully');
            });

    }

    $scope.sendFeedbackResponse = function(){
        var widgetId = document.getElementById('widgetPanel').getAttribute('data-widget-id');
        var feedbackValue = $(".question-panel form option:checked").val();
        var config = {headers:  {"Content-Type" : 'application/json'}};
        $http.put(hostUrl+'/snippet/vote/'+widgetId,JSON.stringify(feedbackValue),config)
            .then(function(response){
                        console.log('confirmation sent successfully');
                    });
    }

    $scope.senderRenderConfirmation();
});

angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("widgetPanel"), ['widgetApp']);
});


//angular.element(document).ready(function() {
//	angular.bootstrap(document.getElementById("widgetPanel"), ['widgetApp']);
//});
//$(document).ready(function(){
//    console.log("jquery feedback script loaded");
//    $("#feedback-panel .btn").click(function(){
//
//        $('.question-panel').css({'display': 'block'});
//        $('#feedback-panel .btn').css({'display':'none'});
//        window.innerHeight = 150;
//        window.innerWidth = 200;
//        window.resizeTo(200,150);
//
//
//    });
//
//    $('.question-panel .close').click(function(){
//        $('.question-panel').css({'display': 'none'});
//        $('#feedback-panel .btn').css({'display':'block'});
//    });
//
//});