<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="NewURL" value="/quan-tri/bai-viet/danh-sach"/>
<c:url var="newAPI" value="/api/new"/>
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">

		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang chu</a>
					</li>

					<li><a href="#">Danh sách</a></li>
					<li class="active">biểu mẫu</li>
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
									<form:input path="thumbnail" type="file" cssClass="col-xs-10 col-sm-5" id="thumbnail"  />
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
							<form:hidden path="id" id="newid"/>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
								<c:if test="${not empty model.id }">
									<button class="btn btn-info" type="button" id="btnAddOrUpdateNew" >
										<i class="ace-icon fa fa-check bigger-110"></i> Cập Nhật Bài Viết
									</button>
								</c:if>
								<c:if test="${empty model.id }">
									<button class="btn btn-info" type="button" id="btnAddOrUpdateNew" >
										<i class="ace-icon fa fa-check bigger-110" "></i> Thêm bài Viết
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
	$( "#btnAddOrUpdateNew" ).click(function(e) {
		e.preventDefault();//xóa đường dẫn cũ chỉ còn đường dẫn gốc
		
		var data={};
		var formData = $('#formSubmit').serializeArray();
		$.each(formData, function(i,v){
			data[""+v.name+""] = v.value;
		});
		var id = $('#newid').val();
		console.log(data);
		if( id == ""){
			addNew(data);
		}else{
			updateNew(data);
		} 
	});
	
	
	
	 function addNew(data){
		$.ajax({
			url: '${newAPI}',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success:function (result){
				window.location.href = "${NewURL}?page=1&limit=2";
			},
			error: function (error){
				window.location.href = "${NewURL}?page=1&limit=2";	
			}
		});
	} 
	
	 function updateNew(data){
		$.ajax({
			url: '${newAPI}',
			type: 'PUT',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success:function (result){
				window.location.href = "${NewURL}?page=1&limit=2";
			},
			error: function (error){
				window.location.href = "${NewURL}?page=1&limit=2";
			}
		});
	} 
	</script>
</body>
</html>
