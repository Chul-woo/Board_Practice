<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>
<script type="text/javascript" src="../resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script>
$(function(){
    //전역변수
//     var obj = [];              
//     //스마트에디터 프레임생성
//     nhn.husky.EZCreator.createInIFrame({
//         oAppRef: obj,
//         elPlaceHolder: "content",
//         sSkinURI: "../resources/smarteditor/SmartEditor2Skin.html",
//         htParams : {
//             // 툴바 사용 여부
//             bUseToolbar : true,            
//             // 입력창 크기 조절바 사용 여부
//             bUseVerticalResizer : true,    
//             // 모드 탭(Editor | HTML | TEXT) 사용 여부
//             bUseModeChanger : true,
//         }
//     });
    //전송버튼
    $("#regist").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
//         obj.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
        //폼 submit
        $.ajax({
			type: 'POST',
			url:'/board/regist',
			dataType: "JSON",
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
			data: JSON.stringify({
				title: $('#title').val(),
				content: $('#content').val(),
				writer: $('#writer').val()
			}),
			success: function(data){
				if(data.result == 'success'){
					alert("등록되었습니다.");
					self.location = "/board";
				}
			}
		});
    });
});
</script>


<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">REGISTER BOARD</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Title</label> <input type="text"
								name='title' class="form-control" id="title" placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Writer</label> <input type="text"
								name="writer" id="writer" class="form-control" value = "${login.id }" placeholder="Enter Writer" readonly disabled>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content</label>
							<textarea class="form-control" name="content" rows="3"
								 id="content" placeholder="Enter ..."></textarea>
						</div>
					</div>
				</form>
				<div class="box-footer">
						<a id="regist" class="btn btn-primary">등록</a>
					</div>
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
