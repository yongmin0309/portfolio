<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>

<section>
<div class="container">
	<p class="title">예약하기</p>
	<form action="/cosInsert" method="post" name="frm">
			<table width="700px" >
				<tr>
					<td>예약코드(자동발생)</td>
					<td><input type = "number" value="${re_code}"  name="re_code" id="re_code" readonly="readonly"></td>
				</tr>
				
				
				<tr>
					<td>전화번호</td>
					<td><input type="text" id="re_phone" name="re_phone"></td>
				</tr>
				
				<tr>
					<td>예약날짜</td>
					<td><input type="date" id="re_date" name="re_date"></td>
				</tr>
												
				<tr>
					<td>예약시간</td>
					<td><input type="text" id="re_time" name="re_time"></td>
				</tr>
				
				<tr>
					<td>인원</td>
					<td><input type="number" id="re_person" name="re_person" onchange="p()"></td>
				</tr>
				
				<tr>
				<td>코스요리</td>
					<td><select id="cos_code" name="cos_code" onchange="p()">
						<option value="0">코스선택</option>
						
						<option value="lunch-A">lunch-A(160000원)</option>
		
						<option value="lunch-B">lunch-B(170000원)</option>
		
						<option value="dinner-A">dinner-A(170000원)</option>
						
						<option value="dinner-B">dinner-B(180000원)</option>
					</select></td>						
				</tr>
				
				
				<tr>
					<td>가격</td>
					<td><input type="text" name="cos_price" id="cos_price"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="추가" onclick="return checkForm()">
					<input type="button" value="목록" onclick="location.href ='/cosList'">
				</tr>
				
			</table>	
	</form>
</div>
</section>
<script>
	function checkForm() {
		if(document.frm.re_code.value == ""){
			alert('예약번호가 입력되지 않았습니다!');
			document.frm.re_code.focus();
			return false;
		}
		if(document.frm.re_phone.value.trim() == ""){
			alert('전화번호 입력되지 않았습니다!');
			document.frm.re_phone.focus();
			return false;
		}
		if(document.frm.re_date.value.trim() == ""){
			alert('예약날짜가 입력되지 않았습니다!');
			document.frm.re_date.focus();
			return false;
		}
		if(document.frm.re_time.value.trim() == ""){
			alert('예약시간이 입력되지 않았습니다!');
			document.frm.re_time.focus();
			return false;
		}
		if(document.frm.re_person.value.trim() == ""){
			alert('소속사 입력되지 않았습니다!');
			document.frm.re_person.focus();
			return false;
		}
		if(document.frm.cos_code.value.trim() == ""){
			alert('코스코드가 입력되지 않았습니다!');
			document.frm.cos_code.focus();
			return false;
		}
		return true;
	}
	function p() {
		if(document.frm.cos_code.value =="lunch-A"){
			per=Number(document.frm.re_person.value);
			
			document.frm.cos_price.value= 160000 * per+"원";
			
		} else if(document.frm.cos_code.value =="lunch-B") {
			per=Number(document.frm.re_person.value);
			
			document.frm.cos_price.value= 170000 * per+"원";
			
		} else if(document.frm.cos_code.value =="dinner-B") {
			per=Number(document.frm.re_person.value);
			
			document.frm.cos_price.value= 170000 * per+"원";
			
		} else if(document.frm.cos_code.value =="dinner-B") {
			per=Number(document.frm.re_person.value);
			
			document.frm.cos_price.value= 180000 * per+"원";
		}
		
		
		
	}
</script>

<jsp:include page ="master/footer.jsp"/>