
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var ="NewURL" value="/admin-new"/>
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
		<form action="#" id="formSubmit" method="get">
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
							<c:if test="${not empty messageResponse}">
									<div class="alert alert-${alter}">
  										${messageResponse}
									</div>
								</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info" 
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip" 
												title='Thêm bài viết' href='#'> 
													<span>
														<i class="fa fa-plus-circle bigger-110 purple"></i>
													</span>
											</a>
											<button id="btnDelete" type="button"
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
													<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
													<td>${item.title}</td>
													<td>${item.thumbnail}</td>
													<td>${item.shortDescription}</td>
													<td>${item.content}</td>
													<td>${item.categoryId}</td>
													<td>
														<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
															title="Cập nhật bài viết" href='#'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
														</a>
													</td>
												</tr>
											
											</c:forEach>
											</tbody>
										</table>
										 <nav aria-label="Page navigation">
									        <ul class="pagination" id="pagination"></ul>
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
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: 35,
            visiblePages: 10,
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
	</script>
</body>

</html>