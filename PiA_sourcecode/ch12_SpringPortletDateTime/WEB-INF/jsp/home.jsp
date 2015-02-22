<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type='text/javascript'>
	function <portlet:namespace/>setCurrentDateTime() {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) {
				var messageText = document.getElementById("<portlet:namespace/>messageText");
				messageText.innerHTML = xhr.responseText;
			}
		};
		var url = '<portlet:resourceURL id="dateTime"/>' + "?fakeId=" + Math.random();
		xhr.open("GET", url, true);
		xhr.send();
	}
</script>

<table>
	<tr>
		<td><b><a href="#" onclick="<portlet:namespace/>setCurrentDateTime();" style="color: black;">Refresh</a></b></td>
	</tr>
</table>
<br/>
<div id="<portlet:namespace/>messageText">
</div>