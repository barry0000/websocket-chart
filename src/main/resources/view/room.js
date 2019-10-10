window.onload=function(){
   var sockJs=new SockJS("/stomp");
   var stomp=Stomp.over(sockJs);
   stomp.connect({},function (frame) {
       stomp.subscribe("/topic/hhh/"+roomid,function (data) {
           console.log(data);
           var result=JSON.parse(data.body);
           var messgage=result.message;
           var div=document.createElement("div");
           div.innerHTML=messgage;
           document.getElementById("messageList").appendChild(div);
       });

       stomp.subscribe("/topic/newPerson/"+roomid,function (data) {
           document.getElementById("newPerson").innerHTML=data.body;
       });
   })

   document.getElementById("sendMesssage").onclick=function () {
       var message=document.getElementById("talkMessage").value;
       stomp.send("/app/rooms/talk/"+roomid,{},JSON.stringify({"message":message}));
   }
}