<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

	<div class="box-body">

		<div class="form-group">
			<label for="exampleInputEmail1">BNO</label> <input type="text"
				name='bno' id = 'bno' class="form-control" value="${board.bno}"
				readonly="readonly">
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">Title</label> <input type="text"
				name='title' id = 'title' class="form-control" value="${board.title}">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" name="content" id='content' rows="3">${board.content}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label> <input
				type="text" name="writer" class="form-control"
				value="${board.writer}" id = 'writer' readonly disable>
		</div>
	</div>
	<!-- /.box-body -->
</form>


<div class="box-footer">
	<button type="submit" class="btn btn-primary">수정</button>
	<button type="submit" class="btn btn-warning">취소</button>
</div>

<script>
	$(document).ready(function() {

// 		var formObj = $("form[role='form']");

// 		console.log(formObj);

		$(".btn-warning").on("click", function() {
// 			self.location = "/board?page=${cri.page}"
// 					+"&perPageNum=${cri.perPageNum}"
// 					+"&searchType=${cri.searchType}"
// 					+"&keyword=${cri.keyword}"
// 					;
			self.location = "/read?page=${cri.page}"
				+"&perPageNum=${cri.perPageNum}"
				+"&bno=${board.bno}"
				;
		});

		$(".btn-primary").on("click", function() {
			$.ajax({
				type: 'POST',
				url: '/board/update',
				datType: 'JSON',
				data : JSON.stringify({
					bno : $('#bno').val(),
					content : $('#content').val(),
					title : $('#title').val(),
					writer : $('#writer').val()
				}),
				headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
				success : function(data, status){
// 					if(data.result == 'success'){
// 						alert("수정되었습니다.");
// 					}else{
// 						alert("나중에 다시 시도해 주세요");
// 					}

					alert("수정되었습니다.");
					self.location = "/read?page=${cri.page}"
						+"&perPageNum=${cri.perPageNum}"
						+"&bno=${board.bno}"
						;
				},
				error : function(data, status){
					console.log("data: " + data);
					console.log("status: " + status);
				}
			});
		});

	});
</script>




			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%-- <%@include file="../include/footer.jsp"%> --%>
