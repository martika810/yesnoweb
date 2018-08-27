$(document).ready(function(){
    console.log("jquery feedback script loaded");
    $("#feedback-panel .btn").click(function(){

        $('.question-panel').css({'display': 'block'});
        $('#feedback-panel .btn').css({'display':'none'});
        window.innerHeight = 150;
        window.innerWidth = 200;
        window.resizeTo(200,150);


    });

    $('.question-panel .close').click(function(){
        $('.question-panel').css({'display': 'none'});
        $('#feedback-panel .btn').css({'display':'block'});
    });

});