<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统提示</title>
<link rel="stylesheet" href="${resources }/css/common/prompt.css">
</head>
<body>
	<div class="prompt_frame">
		<div class="prompt_centerL">
			<div class="prompt_centerR">
				<div class="prompt_centerC">
					<div class="prompt_container clearfloat">
						<div class="prompt_content_success"></div>
						<div class="prompt_content_right">
							<div class="prompt_content_inside">
								您的请求已提交，系统返回如下信息：
								<div class="msgtitle">您的操作已成功！</div>
								
								<span id="_timeArea" class="prompt_content_timer">6秒后页面自动关闭</span>
							</div>
							<div class="prompt_buttons clearfloat">
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var oDiv = document.getElementById("_timeArea");
		var time = 5;
		setInterval(function(){
			oDiv.innerHTML = time + "秒后页面自动关闭";
			time --;
			if(time == 0){
				window.opener.location.reload();
				window.close()
			}
		},1000);
	</script>
</body>
</html>