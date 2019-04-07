<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../layout/header.jsp"%>

<div class="panel-body">
	<div class="row">
		<div class="col-lg-6">
			<form>
				<div class="form-group input-group">
					<span class="input-group-addon"><i class="fa fa-check"></i></span>
					<input type="text" id = 'uid' class="form-control" placeholder="ID" style="width:85%"/>
					<a id="checkId" class="btn btn-default" style="width:14%">확인</a>
				</div>
				<div class="form-group input-group">
					<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
					<input type="email" id= 'email' class="form-control" placeholder="Email"/>

				</div>
				<div class="form-group input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span>
					<input type="text" id='name' class="form-control" placeholder="Name"/>
				</div>
				<div class="form-group input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span>
					<input type="password" id='pw' class="form-control" placeholder="Password"/>
				</div>
				<div class="form-group input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span>
					<input type="password" id='cpw' class="form-control" placeholder="Password Check" />
				</div>
				<a type="regist" id="regist" class="btn btn-default">가입하기</a>
				<a type="cancel" id="cancel" class="btn btn-default">취소하기</a>
			</form>
		</div>
	</div>
</div>

<script>
	
	var result = '';

	$('#checkId').on('click', function(){
		if($('#uid').val() == null || $('#uid').val()==''){
			alert("아이디를 입력해주세요.");
			return;
		}
		$.ajax({
			type:'POST',
			url: '/checkId',
			dataType: 'JSON',
			data: JSON.stringify({id : $('#uid').val() }),
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
			success: function(data, status){
				if(data.result == 'success'){
					if(data.check == 'Y'){
						alert("사용할 수 있는 아이디입니다.");
						$('#uid').prop('readonly', true);
						result = true;
					}else{
						alert("사용할 수 없는 아이디입니다.");
						result = false;
					}
				}
			},
			error: function(data, status){
				alert("다시 시도해주세요.");
				result = false;
			}
			
		});	
	});

	var validation = function(){
		var id = $('#uid').val();
		var email = $('#email').val();
		var name = $('#name').val();
		var pw = $('#pw').val();
		var cpw = $('#cpw').val();
		
		if(id == null || id == ''){
			alert('아이디를 입력해주세요.');
			$('#id').focus();
			return;
		}
		
		if(email == null || email == ''){
			alert('이메일을 입력해주세요.');
			$('#email').focus();
			return;
		}
		
		if(name == null || name == ''){
			alert('이름을 입력해주세요.');
			$('#name').focus();
			return;
		}
		
		if(pw == null || pw == ''){
			alert('비밀번호를 입력해주세요.');
			$('#pw').focus();
			return;
		}
		
		if(cpw == null || cpw == ''){
			alert('비밀번호를 확인해주세요.');
			$('#cpw').focus();
			return;
		}
		
		if(pw != cpw){
			alert('비밀번호를 다시 확인해주세요');
			return;
		}
		
		if(!result){
			alert('중복확인을 해주세요');
			return;
		}
		
	}

	$('#regist').on('click', function(){
		validation();
		$.ajax({
			type:'POST',
			url:'/register/insert',
			dataType:'JSON',
			data: JSON.stringify({
				id: $('#uid').val(),
				name: $('#name').val(),
				email: $('#email').val(),
				password: $('#pw').val() 
			}),
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
			success: function(data, status){
				if(data.result == "success"){
					alert("회원가입이 완료되었습니다.");
					self.location = "/login";
				}else{
					alert("나중에 다시 시도해주세요.");
				}
			},
			error: function(data, status){
				alert("나중에 다시 시도해주세요.");
			}
		});
	});
	$('#cancel').on('click', function(){
		self.location = "/"
	});
</script>


</div>