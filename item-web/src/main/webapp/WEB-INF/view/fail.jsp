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
		<div class="promt_headerL">
			<div class="promt_headerR">
				<div class="promt_headerC clearfloat">
				</div>
			</div>
		</div>
		<div class="prompt_centerL">
			<div class="prompt_centerR">
				<div class="prompt_centerC">
					<div class="prompt_container clearfloat">
						<div>
							<div class="prompt_content_error clearfloat">
							</div>
							<div class="prompt_content_right">
								<div class="prompt_content_inside clearfloat" style="margin-top: 15px;margin-bottom: 0px">
									<span class="prompt_title">
										您的请求已提交，系统返回如下信息：
										<span class="prompt_message">
											<div class="errortitle">操作失败！${message }</div>
										</span>
									</span>
									<span class="prompt_message">
										
									</span>
								</div>
								<div class="prompt_buttons clearfloat">
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="promt_footerL">
			<div class="promt_footerR">
				<div class="promt_footerC clearfloat">
				</div>
			</div>
		</div>
	</div>
</body>
</html>