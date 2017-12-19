<#assign base = request.contextPath />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   

    <title>Spring Boot Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="${base}/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="${base}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="${base}/assets/css/style.css" rel="stylesheet">
    <link href="${base}/assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
    
    	#username{
    		background:url('${base}/assets/img/User.png') no-repeat 7px center;
    		background-size:18px;
    	}
    	#password{
    		background:url('${base}/assets/img/Key.png') no-repeat 7px center;
    		background-size:18px;
    	}
    	.form-controls{
    	  display: block;
		    width: 100%;
		    height: 34px;
		    padding: 6px 12px;
		    font-size: 14px;
		    line-height: 1.42857143;
		    color: #555;
		    background-color: #fff;
		    background-image: none;
		    border: 1px solid #ccc;
		    border-radius: 4px;
		    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
		    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
		    padding-left:30px;
    	}
    	  
    	
    	
    </style>	
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action="index.html">
		        <h2 class="form-login-heading"><img src='${base}/assets/img/0171124134028.png'/></h2>
		        <div class="login-wrap">
		            <input id="username" type="text" class="form-controls" placeholder="请输入用户名" autofocus>
		            <br>
		            <input id="password" type="password" class="form-controls" placeholder="请输入密码">
		            <br>
		            <div id="Prompt" style="text-align:center;color:red;">
		            </div>
		            <br>
		            <button class="btn btn-theme btn-block" onclick="login();" type="button">登录</button>
		        </div>
		      </form>	  	
	  	</div>
	  </div>

    <script src="${base}/assets/js/jquery.js"></script>
    <script src="${base}/assets/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="${base}/assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("${base}/assets/img/demo-1-bg.jpg", {speed: 500});
    </script>
	<script type="text/javascript">
		function login(){
			ajaxLogin();
		}
		$(document).keydown(function(event){
			if(event.keyCode==13){
				ajaxLogin();
			}
		})
		function ajaxLogin(){
			var u =$("#username").val();
			var p =$("#password").val();
			$("#Prompt").empty();
			$.post("${base}/enter",{"username":u,"password":p},function(res){
				if(res=="ACS_10001"){
					$("#Prompt").html("用户名错误");
				}else if(res=="ACS_10008"){
					$("#Prompt").html("用户不存在");
				}else if(res=="ACS_10002"){
					$("#Prompt").html("密码错误,请核对后登陆");
				}else if(res=="success"){
					$("#Prompt").append("<img src='${base}/assets/img/loading.jpg' style='width: 16px;'/>");
					location.href="${base}/index";
				}else{
					$("#Prompt").html("系统异常,请稍后再试");
				}
			}
			)
		}
	</script>

  </body>
</html>
