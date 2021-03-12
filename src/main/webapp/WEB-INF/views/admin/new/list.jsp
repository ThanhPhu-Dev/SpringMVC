
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var ="NewURL" value="/admin-new"/>
<c:url var="createNewURL" value="/quan-tri/bai-viet/chinh-sua"/>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài viết</title>
</head>

<body>
	<div class="main-content">
		<form action="<c:url value="/quan-tri/bai-viet/danh-sach" />" id="formSubmit" method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty message}">
								<div class="alert alert-${alter}">
								  <strong>${message}</strong> 
								</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info" 
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip" 
												title='Thêm bài viết' href='${createNewURL}'> 
													<span>
														<i class="fa fa-plus-circle bigger-110 purple"></i>
													</span>
											</a>
											<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa bài viết'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th><input type="checkbox" id="checkAll"></th>
													<th scope="col">Tên Bài Viết</th>
													<th scope="col">hình Ảnh</th>
													<th scope="col">Mô Tả Ngắn</th>
													<th scope="col">Nội Dung</th>
													<th scope="col">Mã Danh Mục</th>
													<th scope="col">Thao Tác</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var = "item" items= "${model.listResult}">
												<tr>
												<c:url var="updateNewURL" value="/quan-tri/bai-viet/chinh-sua">
													<c:param name="id" value="${item.id}"></c:param>
												</c:url>
													<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
													<td>${item.title}</td>
													<td>${item.thumbnail}</td>
													<td>${item.shortDescription}</td>
													<td>${item.content}</td>
													<td>${item.categoryId}</td>
													<td>
														<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
															title="Cập nhật bài viết" href='${updateNewURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
														</a>
													</td>
												</tr>
											
											</c:forEach>
											</tbody>
										</table>
										 <nav aria-label="Page navigation">
									        <ul class="pagination" id="pagination"></ul>
									        <input type="hidden" value="" id="page" name="page"/>
											<input type="hidden" value="" id="limit" name="limit"/>
									    </nav>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	<script>
	$(function () {
		var totalPage = ${model.totalPage}
		var currentPage = ${model.page}
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
            	if (currentPage != page) {
            		$('#limit').val(2);
					$('#page').val(page);
					$('#formSubmit').submit();
				}
            }
        });
    });
	
	function warningBeforeDelete(){
		swal({
			  title: "Xác Nhận Xóa",
			  text: "Bạn có chắc muốn xóa",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonClass: "btn-success",
			  cancelButtonClass: "btn-danger",
			  confirmButtonText: "Xác Nhận",
			  cancelButtonText: "Hủy Bỏ",
			}).then(function(isConfirm) {
			  if (isConfirm) {
			    console.log("ok sweetalter");
			  }
			});
	}
	</script>
</body>

</html>