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
<%-- 								<td><a href='/read/${boardVO.bno}'>${boardVO.title}</a></td> --%>
								<td><a href='/read/${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${boardVO.bno}'>${boardVO.title}</a></td>
								<td>${boardVO.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${boardVO.regdate}" /></td>
								<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
							</tr>

						</c:forEach>

					</table>

				</div>
				<!-- /.box-body -->
<!-- 				<div class="box-footer"> -->
<!-- 					<a class="btn btn-primary" id="toRegist" href="/regist">등록</a> -->
<!-- 				</div> -->
				<!-- /.box-footer-->
			</div>
			<div class="box-footer">
				<div class="text-center">	
					<ul class="pagination">
						<c:if test = "${pageMaker.prev }">
							<li><a href="/${pageMaker.makeSearch(pageMaker.startPage - 1) }">이전</a></li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
								<li><a href = "/${pageMaker.makeSearch(idx) }">${idx }</a>
							</li>
						</c:forEach>
						<c:if test = "${pageMaker.next}">
							<li><a href="/${pageMaker.makeSearch(pageMaker.endPage + 1) }">다음</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div class="box-footer">
				<div class="form-group col-sm-2">
					<select class="form-control" name="searchType" id="searchType">
						<option value = "n" <c:out value="${searchCriteria.searchType == null ? 'selected':'' }"/>>선택</option>
						<option value = "t" <c:out value="${searchCriteria.searchType eq 't' ? 'selected':'' }"/>>제목</option>
						<option value = "c" <c:out value="${searchCriteria.searchType eq 'c' ? 'selected':'' }"/>>내용</option>
						<option value = "w" <c:out value="${searchCriteria.searchType eq 'w' ? 'selected':'' }"/>>작성자</option>
						<option value = "tc" <c:out value="${searchCriteria.searchType eq 'tc' ? 'selected':'' }"/>>제목+내용</option>
						<option value = "cw" <c:out value="${searchCriteria.searchType eq 'cw' ? 'selected':'' }"/>>내용+작성자</option>
						<option value = "tcw" <c:out value="${searchCriteria.searchType eq 'tcw' ? 'selected':'' }"/>>제목+내용+작성자</option>
					</select>
				</div>
				<div class="form-group col-sm-10">
					<div class="input-group">
						<input type="text" class="form-control" name="keyword" id="keywordInput" value="${seachCriteria.keyword }" placeholder="검색어">
						<span class="input-group-btn">
							<button type="button" class="btn btn-primary btn-flat" id="searchBtn">
								<i class="fa fa-search"></i>검색
							</button>
						</span>
					</div>
					<div class="pull-right">
						<button class="btn btn-success btn-flat" id="writeBtn">
							<i class="fa fa-pencil"></i>글쓰기
						</button>
					</div>
				</div>
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
	
	$(document).ready(function(){
		$("#searchBtn").on('click', function(event){
			self.location = 
				"/board/search/list${pageMaker.makeQuery(1)}"
				+"&searchType=" + $("select option:selected").val()
				+"&keyword=" +encodeURIComponent($("#keywordInput").val())
				;
		});
		$("#writeBtn").on('click', function(event){
			self.location = "/regist";
		});
	});
	
</script>

<%-- <%@include file="../include/footer.jsp"%> --%>
