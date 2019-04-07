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
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">

					<input type='hidden' name='bno' id="bno" value="${board.bno}">
					<input type='hidden' name='page' value="${cri.page}"> <input
						type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">

				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label> <input type="text"
							id="title" name='title' class="form-control"
							value="${board.title}" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3"
							id="content" readonly="readonly" style="resize: none;">${board.content }</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label> <input type="text"
							name="writer" class="form-control" value="${board.writer}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<c:if test="${login.id eq board.writer }">
						<a id="modify" class="btn btn-warning"
							href="/update/?bno=${board.bno}">수정</a>
						<a id="remove" class="btn btn-danger">삭제</a>
					</c:if>
					<a id="list" class="btn btn-primary"
						href="/board/?page=${cri.page}&perPageNum=${cri.perPageNum}">목록으로</a>
				</div>
				<input type=hidden id="grpCd" value="${board.grp_cd}" />
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->
		<script>
			$("#remove").on("click", function() {
				$.ajax({
					type : "POST",
					url : "/board/delete",
					dataType : "JSON",
					data : JSON.stringify({
						bno : $("#bno").val()
					}),
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					success : function(data, status) {
						alert("삭제되었습니다.");
						self.location = "/board";
					},
					error : function(data, status) {

					}
				});
			});
		</script>

		<c:if test="${login.id ne null }">
			<div class="col-md-12">
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputPassword1">Comment</label>
						<textarea class="form-control" name="comment" rows="3"
							id="comment" style="resize: none;"></textarea>
					</div>
					<div class="box-footer">
						<a id="registComment" class="btn btn-danger">등록</a>
					</div>
				</div>
				<script>
					$('#registComment').on('click', function() {
						$.ajax({
							type : "POST",
							url : "/board/comment",
							dataType : "JSON",
							data : JSON.stringify({
								content : $("#comment").val(),
								grpCd : $("#grpCd").val()
							}),
							headers : {
								'Accept' : 'application/json',
								'Content-Type' : 'application/json'
							},
							success : function(data, status) {
								//alert("삭제되었습니다.");
								window.location.reload();
							},
							error : function(data, status) {

							}
						});
					});
				</script>
			</div>
		</c:if>
		<div class="col-md-12">
			<table style="width: 100%">
				<tr>
					<th>WRITER</th>
					<th style="width: 45%">CONTENT</th>
					<th style="width: auto">REGDATE</th>
				</tr>
				<c:forEach items="${comment}" var="comment">
					<tr>
						<td>${comment.writer}</td>
						<td>${comment.content}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${comment.regdate}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%-- <%@include file="../include/footer.jsp"%> --%>
