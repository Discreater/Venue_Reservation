/**
 * @author Darren_Daniel_Day
 */
function add0IfSingle(num){
    var result=""+num;
    if(num>=0&&num<=9){
        result="0"+num;
    }
    return result;
}
function convertDate(date){
    var year = date.getFullYear();
    var month = date.getMonth();
    var day = date.getDate();
    var hour=date.getHours();
    var minute=date.getMinutes();
    var currentdate = year + "-" + add0IfSingle(month+1) + "-" + add0IfSingle(day) + " " + add0IfSingle(hour) + ":" + add0IfSingle(minute) ;
    return currentdate;
}
function convertTime(time){
	return time.substring(0,10)+" "+time.substring(11,16);
}
$(document).ready(function(){
	alert("请填写必要信息！");
	$("#submit").click(function judgeDate(){
		var nowDate=new Date();
		var startTime=$("#start_time").val();
        var endTime=$("#end_time").val();
        startTime=convertTime(startTime);
        endTime=convertTime(endTime);
        var nowTime=convertDate(nowDate);
        alert("loading dates:" + nowDate);
        alert("loading times:" + nowTime + " --- " + startTime + " --- " + endTime);
       if(nowTime>=startTime){
           alert("现在是："+nowTime+"，已经超过了指定的预约起始时间！");
           history.back();
       }else if(startTime>=endTime){
            alert("预约起始时间 必须大于 预约截止时间！");
            history.back();
        }
	});
});