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

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">

					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">BNO</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width: 40px">VIEWCNT</th>
						</tr>


						<c:forEach items="${list}" var="boardVO">

							<tr>
								<td>${boardVO.bno}</td>
								<td><a href='/read/${boardVO.bno}'>${boardVO.title}</a></td>
								<td>${boardVO.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${boardVO.regdate}" /></td>
								<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
							</tr>

						</c:forEach>

					</table>

				</div>
				<!-- /.box-body -->
				<a class="btn suggest" id="toRegist" href="/regist" >등록</a>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
// 	function toRegist(){
// 		$.ajax({
// 			url:"/regist",
// 			method:"GET",
// 			success: function(data){
// 				console.log("성공");
// 			}
// 		});
// 	}

	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

<%-- <%@include file="../include/footer.jsp"%> --%>
