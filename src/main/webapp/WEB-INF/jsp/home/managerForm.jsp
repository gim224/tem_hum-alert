
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<!-- Html -->
<html lang="kr">
<!-- Head -->
<head>

</head>

<body>






	<div>


		<table style="text-align: center">
			<thead>
				<th>이름</th>
				<th>아이디</th>
				<th>이메일</th>
				<th colspan="1">사용가능여부</th>
				<th></th>
				<th>삭제</th>

			</thead>
			<c:forEach items="${users}" var="list">
				<tbody>
					<td>${list.fullName}</td>
					<td>${list.username}</td>
					<td>${list.email}</td>
					<td>${list.isEnabled}</td>
					<td><c:if test="${list.isEnabled==true}">
							<!-- 				<input type="button" value="disabled?"> -->
						</c:if> <c:if test="${list.isEnabled!=true}">
							<a href="<c:url value="/admin/user/update/${list.id }/enabled"/>"><input
								type="button" value="enabled?"></a>
						</c:if></td>





					<td><a href="<c:url value="/admin/user/del/${list.id }"/>"><input
							type="button" class="" value="delete"></a></td>
			</c:forEach>

			</tbody>
		</table>
	</div>

	

	<a href="<c:url value="/home"/>"><input type="button" value="back"></a>



</body>