<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:url value="/view/admin/static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Product Management</title>
<!-- BOOTSTRAP STYLES-->
<link href="${url}/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="${url}/css/font-awesome.css" rel="stylesheet" />
<!-- MORRIS CHART STYLES-->

<!-- CUSTOM STYLES-->
<link href="${url}/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<!-- TABLE STYLES-->
<link href="${url}/js/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<div id="wrapper">

		<jsp:include page="/view/admin/view/nav-bar.jsp"></jsp:include>

		<!-- /. NAV TOP  -->
		<jsp:include page="/view/admin/view/slide-bar.jsp"></jsp:include>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>All Category</h2>
						<h5>You can management categories in here</h5>
					</div>

					<div class="row">
						<div class="col-md-4">
							<a class="btn btn-primary"
								href="<c:url value='/admin/category/add'/>" role="button"
								style="margin-left: 18px">+ Add</a> <a class="btn btn-primary"
								href="<c:url value='/admin/category/add'/>" role="button"
								style="margin-left: 3px"> <span><i
									class="fa fa-print bigger-110 grey"></i> <span class="hidden">Print</span></span>Print
							</a>


						</div>
					</div>
					<!-- /. ROW  -->
					<hr />

					<div class="row">
						<div class="col-md-12">
							<!-- Advanced Tables -->
							<div class="panel panel-default">
								<div class="panel-heading">Advanced Tables</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
											id="dataTables-example">
											<thead>
												<tr>
													<th>Category</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${cateList}" var="cate">
													<tr class="odd gradeX">
														<td>${cate.name }</td>
														<td><a
															href="<c:url value='/admin/category/edit?id=${cate.id }'/>"
															class="center">Edit</a> | <a
															href="<c:url value='/admin/category/delete?id=${cate.id }'/>"
															class="center">Delete</a></td>
													</tr>
												</c:forEach>


											</tbody>
										</table>
									</div>

								</div>
							</div>
							<!--End Advanced Tables -->
						</div>
					</div>

				</div>

			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
		<!-- /. WRAPPER  -->
		<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
		<!-- JQUERY SCRIPTS -->
		<script src="${url}/js/jquery-1.10.2.js"></script>
		<!-- BOOTSTRAP SCRIPTS -->
		<script src="${url}/js/bootstrap.min.js"></script>
		<!-- METISMENU SCRIPTS -->
		<script src="${url}/js/jquery.metisMenu.js"></script>
		<!-- DATA TABLE SCRIPTS -->
		<script src="${url}/js/dataTables/jquery.dataTables.js"></script>
		<script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
		<script>
			$(document).ready(function() {
				$('#dataTables-example').dataTable();
			});
		</script>
		<!-- CUSTOM SCRIPTS -->
		<script src="${url}/js/custom.js"></script>
</body>
</html>