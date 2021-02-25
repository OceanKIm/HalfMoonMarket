<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<link rel="stylesheet" href="/res/css/main/header.css?ver=12">
<tiles:importAttribute name="menuList"/>
<header>
	
	<div class="mainlogodiv">
		<div class="mainlogodiv2">
			<div class="mainlogo a-img">
				<a href="/main/home">
					<img class="mainlogo" alt="" src="/res/img/mainLogo.png">
				</a>
			</div>
			
			<div class="main-form">
				<div class="select">
					<form class="form-select" action="" method="">
						<input class="main-form-input" placeholder="상품명 검색" type="text" name="" value="">
						<img class="main-select" alt="" src="/res/img/search.png">
						<div class="form-select-window">
							<div class="window-div1">
								<a href="" class="window-a1">최근검색어</a>
								<a href="" class="window-a2">인기검색어</a>
							</div>
							<div class="window-div2">
								dddd
							</div>
							<div class="window-div2">
								dddd
							</div>
							<div class="window-div2">
								dddd
							</div>
							<div class="window-div2">
								dddd
							</div>
							
							<div class="window-div3">
								<a>검색어 전체 삭제</a>
								<a>닫기</a>
							</div>
						</div>
					</form>
				</div>
				<c:if test="${loginUser == null}">
			<button id="btn_my_sell">내 물건 팔기</button>
			<button id="btn_login">로그인</button>
			<button id="btn_join">회원가입</button>	
		</c:if>
		<c:if test="${loginUser != null}">
			<button id="btn_my_sell">내 물건 팔기</button>
			<button id="btn_logout"><a href="/logout">Logout</a></button>
			<button id="btn_my_page"><a href="/user/my/profile">내정보</a></button>
		</c:if>	
		
			</div>
		</div>
	</div>
	<div>
		<nav id="main-nav">
			<ul id="menuListUl">
				<c:forEach var="item" items="${menuList}">
					<li id="menuListLi">
						<img class="btn_menu_img" alt="" src="/res/img/menuImg/${item.i_product_type}.png">
						<ul id="menuListul-ul">
							<li id="menuListli-li">
								<a href="">ddd</a>
								<a href="">ddd</a>
								<a href="">ddd</a>
							</li>
						</ul>
					</li>
				</c:forEach>
			</ul>
		</nav>
	</div>
</header>