<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../layout/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">Login</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="uid">아이디: </label> <input type="text"
								name='uid' class="form-control" id="uid" placeholder="Enter Your ID">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content</label>
							<input type="password" class="form-control" name="upw"
								 id="upw" placeholder="Enter Your Password"></input>
						</div>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<a id="login" class="btn btn-primary">로그인</a>
						<a id="regist" class="btn btn-primary" href='/register/step1'>회원가입</a>
					</div>
				</form>
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
<script>
	$('#login').on('click', function(){
		if($('#uid').val() == null || $('#uid').val() == ''){
			alert('아이디를 입력해주세요.');
			$('#uid').focus();
			return;
		}
		
		if($('#upw').val() == null || $('#upw').val() == ''){
			alert('비밀번호를 입력해주세요.');
			$('#upw').focus();
			return;
		}
		
		$.ajax({
			type:'POST',
			url: '/loginProcess',
			dataType: 'JSON',
			data: JSON.stringify({
				id : $('#uid').val(),
				password: $('#upw').val()
			}),
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
		    success: function(data, status){
		    	if(data.result == 'success'){
		    		self.location = '/';	
		    	}else{
		    		alert("아이디 또는 비밀번호가 틀렸습니다.");
			    	return;
		    	}
		    },
		    error: function(data, status){
		    	alert("나중에 다시시도해주세요");
		    	return;
		    }
		});
		
	});
</script>
</div>