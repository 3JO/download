<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			DOWNLOAD BOARD <small>Modify</small>
		</h1>

	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="box box-primary">
					<div class="box-header">
						<h3 class="box-title">MODIFY PAGE</h3>
					</div>
					<!-- /.box-header -->

					<form role="form" action="modifyPage" method="post">
					
						<input type='hidden' name='page' value="${cri.page}">
						<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
						
						<div class="box-body">
							<div class="form-group">
								<label for="exampleInputEmail1">BNO</label> <input type="text"
									name='bno' class="form-control" value="${dboardVO.bno}"
									readonly="readonly">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Title</label> <input type="text"
									name='title' class="form-control" value="${dboardVO.title}">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Content</label>
								<textarea class="form-control" name="content" rows="3">${dboardVO.content}</textarea>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Writer</label> <input
									type="text" name="writer" class="form-control"
									value="${dboardVO.writer}" readonly="readonly">
							</div>
						</div>
						<!-- /.box-body -->

						<div class="box-footer">
							<button type="submit" class="btn btn-primary">Save</button>
							<button type="submit" class="btn btn-warning">Cancel</button>
						</div>
					</form>
					
					<script>
					$(document).ready(function() {

						var formObj = $("form[role='form']");

						console.log(formObj);

						$(".btn-warning").on("click", function() {
							self.location = "/dboard/listPage?page=${cri.page}&perPageNum=&{cri.perPageNum}";
						});

						$(".btn-primary").on("click", function() {
							formObj.submit();
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

<%@include file="../include/footer.jsp"%>
