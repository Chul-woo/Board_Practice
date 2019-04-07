<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../layout/header.jsp"%>

<div class="panel-body">
	<div class="row">
		<div class="col-lg-12">
			<h4>이용약관</h4>
			<div class="panel-body" style="border: 1px solid #ccc">
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
					lacus adipiscing, posuere lectus et, fringilla augue. Lorem ipsum
					dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
					incididunt ut labore et dolore magna aliqua.</p>
			</div>
			</br>
			<h4>개인정보</h4>
			<div class="panel-body" style="border: 1px solid #ccc">
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
					lacus adipiscing, posuere lectus et, fringilla augue. Lorem ipsum
					dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
					incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<br />
			<form>
				<div class="form-group">
					<label class="checkbox-inline"> <input type="checkbox"
						name="agree" id="agree" value="true">동의합니다.
					</label>
				</div>
				<a id="nextStep" class="btn btn-default">다음 단계</a>
			</form>
		</div>
	</div>
	
	<script>
		$('#nextStep').on('click', function(event){
			
			var check = $('input[name="agree"]').is(":checked");
			if(!check){
				alert("약관에 동의해주세요.");
				return;
			}else{
				self.location="/register/step2";
			}
		});
	</script>

</div>