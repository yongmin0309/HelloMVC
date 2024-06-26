<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/views/common/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="path" value="${pageContext.request.contextPath }"/> 
<section id=enroll-container>
        <h2>회원 가입 정보 입력</h2>
        <form action="${pageContext.request.contextPath }/member/enrollend.do" method="post" >
        <table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" placeholder="4글자이상" name="userId" id="userId_" >
					<input id="idduplicatebtn" type="button" value="중복확인" >
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="password" id="password_" ><br>
				</td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td>	
					<input type="password" id="password_2" ><br>
				</td>
			</tr>  
			<tr>
				<th>이름</th>
				<td>	
				<input type="text"  name="userName" id="userName" ><br>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>	
				<input type="number" name="age" id="age" required><br>
				</td>
			</tr> 
			<tr>
				<th>이메일</th>
				<td>	
					<input type="email" placeholder="abc@xyz.com" name="email" id="email"><br>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>	
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" required><br>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>	
					<input type="text" placeholder="" name="address" id="address"><br>
				</td>
			</tr>
			<tr>
				<th>성별 </th>
				<td>
					<input type="radio" name="gender" id="gender0" value="M">
					<label for="gender0">남</label>
					<input type="radio" name="gender" id="gender1" value="F">
					<label for="gender1">여</label>
				</td>
			</tr>
			<tr>
				<th>취미 </th>
				<td>
					<input type="checkbox" name="hobby" id="hobby0" value="음악듣기"><label for="hobby0">음악듣기</label>
					<input type="checkbox" name="hobby" id="hobby1" value="노래부르기"><label for="hobby1">노래부르기</label>
					<input type="checkbox" name="hobby" id="hobby2" value="게임"><label for="hobby2">게임</label><br />
					<input type="checkbox" name="hobby" id="hobby3" value="악기치기"><label for="hobby3">악기치기</label>
					<input type="checkbox" name="hobby" id="hobby4" value="숙면"><label for="hobby4">숙면</label><br />
				</td>
			</tr>
		</table>
		<input type="submit" value="가입" >
		<input type="reset" value="취소">
        </form>
    </section>
    <script>
    	const $idbtn=document.getElementById("idduplicatebtn");
    	$idbtn.addEventListener("click",e=>{
    			const $userId = document.getElementById("userId_");
    			
    			open("${pageContext.request.contextPath}/member/idduplicate.do?userId="+$userId.value
    					,"_blank","width=300,height=300");
    	});
    		
    	
    	
    </script>
<jsp:include page="/views/common/footer.jsp"/>