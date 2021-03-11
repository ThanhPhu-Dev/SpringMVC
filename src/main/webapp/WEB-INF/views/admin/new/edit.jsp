<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>

<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">

		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>

					<li><a href="#">Forms</a></li>
					<li class="active">Form Elements</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<form:form class="form-horizontal" role="form" id='formSubmit' modelAttribute="model">
							<div class="form-group">
								<label for="categoryCode" class="col-sm-3 control-label no-padding-right">Thể Loại:</label>
								<div class="col-sm-9">
									<%-- <select class="form-control" id="categoryCode" name="categoryCode">
										<option value="">chọn thể loại</option>
										<c:forEach var="item" items="${catogories}">
											<option value="${item.code}">${item.name}</option>
										</c:forEach>
									</select> --%>
									
									<!-- path tương đương với name và value, maping tới modelAttribute 
									vd path="categoryCode" thì sau biên dịch là model.categoryCode-->
									
									<form:select path="categoryCode" id="categoryCode">
										<form:option value="" label="chọn thể loại"  />
										<form:options items="${catogories}" itemValue="code" itemLabel="name" />
									</form:select>
								</div> 
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Tên Bài Viết </label>
								<div class="col-sm-9">
									<%-- <input type="text" placeholder="Tên Bài Viết" class="col-xs-10 col-sm-5" id="title" name="title" value="${model.title}"/> --%>
									
									<form:input path="title" cssClass="col-xs-10 col-sm-5" id="title" placeholder="Tên Bài Viết"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Ảnh Đại diện </label>
								<div class="col-sm-9">
									<!-- <input type="file" class="col-xs-10 col-sm-5" id="thumbnail" name="thumbnail" /> -->
									<form:input path="thumbnail" cssClass="col-xs-10 col-sm-5" id="thumbnail"  />
								</div>
							</div>
							<div class="form-group">
								<label for="shortDescription" class="col-sm-3 control-label no-padding-right">Mô Tả ngắn:</label>
								<div class="col-sm-9">
									<%-- <textarea class="form-control" rows="5" cols="10" id="shortDescription" name="shortDescription" value="${model.shortDescription}"></textarea> --%>
									<form:textarea path="shortDescription" cssClass="form-control" rows="5" cols="10" id="shortDescription"/>
								</div>
							</div>
							<div class="form-group">
								<label for="content" class="col-sm-3 control-label no-padding-right">Nội Dung:</label>
								<div class="col-sm-9">
									<%-- <textarea class="form-control" rows="5" cols="10" id="content" name="content" value="${model.content}"></textarea> --%>
									<form:textarea path="content" cssClass="form-control"  rows="5" cols="10" id="content"/>
								</div>
							</div>
							
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
								<c:if test="${not empty model.id }">
									<button class="btn btn-info" type="button">
										<i class="ace-icon fa fa-check bigger-110" id="btnAddOrUpdateNew"></i> Cập Nhật Bài Viết
									</button>
								</c:if>
								<c:if test="${not empty model.id }">
									<button class="btn btn-info" type="button">
										<i class="ace-icon fa fa-check bigger-110" id="btnAddOrUpdateNew"></i> Thêm bài Viết
									</button>
								</c:if>
									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
									</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	$("#btnAddOrUpdateNew").click(function(e){
		e.preventDefault();
		var data={};
		data = ${'formSubmit'}.serialzeArray();
	});
	</script>
</body>
</html>
