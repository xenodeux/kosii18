<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>
<H1>네이놈!!!</H1>
<form:form commandName="tableVO" method="get">
<form:input path="columnNm1"/>
<form:input path="pageIndex"/>
<input type="submit" value="검색">
<input type="reset" value="취소">

<label for="pageUnit">pageUnit</label>
<form:select path="pageUnit">
	<form:option value="5">5</form:option>
	<form:option value="10">10</form:option>
	<form:option value="20">20</form:option>
</form:select>

<label for="pageSize">pageSize</label>
<form:select path="pageSize">
	<form:option value="2">2</form:option>
	<form:option value="3">3</form:option>
	<form:option value="4">4</form:option>
	<form:option value="5">5</form:option>
	<form:option value="10">10</form:option>
	<form:option value="20">20</form:option>
</form:select>


<%-- <form method="post">
<input type="text" name="columnNm1" value="${tableVO.columnNm1}">
<input type="submit" value="검색">
<input type="reset" value="취소"> --%>

<a href="${pageContext.request.contextPath}/table/insertTableForm.do">등록</a>

<table border = "1">
<c:forEach items="${results}" var="item">

<tr>
	<td><a href="${pageContext.request.contextPath}/table/insertTableForm.do?multi=update&tableId=${item.tableId}&pageIndex=${tableVO.pageIndex}&pageUnit=${tableVO.pageUnit}&pageSize=${tableVO.pageSize}">${item.tableId}</a></td>	
	<td><a href="insertTableForm.do?multi=update&tableId=${item.tableId}">${item.tableId}</a></td>
	<td><a href="deleteTable.do?tableId=${item.tableId}" onclick="return btnDelete(this);">삭제</a></td>
	<td><a href="rollbackTable.do?tableId=${item.tableId}" onclick="return btnRollback(this);">삭제복구</a></td>
	<td><a href="delete2Table.do?tableId=${item.tableId}" onclick="return btnDelete(this);"> 트루삭제</a></td>
</tr>
</c:forEach>
</table>
<div align="center">
	<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_noticeList" />
</div>

</form:form>
<!-- </form> -->

<script type="text/javascript">
function btnDelete(_this){
	console.log('_this', _this);
	console.log('_this.href', _this.href);
	if(confirm('삭제하시겠습니까?')){
		return true;
	} else {		
		return false;
	}
}

function btnRollback(_this){
	console.log('_this', _this);
	console.log('_this.href', _this.href);
	if(confirm('복구하시겠습니까?')){
		return true;
	} else {		
		return false;
	}
}

function fn_egov_select_noticeList(pageIndex){
	document.querySelector('#pageIndex').value = pageIndex;
	document.querySelector('#tableVO').submit();
}
</script>
</body>
</html>