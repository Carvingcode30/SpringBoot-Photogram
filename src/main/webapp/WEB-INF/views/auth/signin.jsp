<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Photogram</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
</head>

<body>
	<div class="container">
		<main class="loginMain">
			<!--로그인섹션-->
			<section class="login">
				<!--로그인박스-->
				<article class="login__form__container">
					<!--로그인 폼-->
					<div class="login__form">
						<h1>
							<img src="/images/logo.jpg" alt="">
						</h1>

						<!--로그인 인풋-->
						<form class="login__input" action="/auth/signin" method="post">
							<input type="text" name="username" placeholder="유저네임"
								required="required" /> <input type="password" name="password"
								placeholder="비밀번호" required="required" />
							<button>로그인</button>
						</form>
						<!--로그인 인풋end-->

						<!-- 또는 -->
						<div class="login__horizon">
							<div class="br"></div>
							<div class="or">또는</div>
							<div class="br"></div>
						</div>
						<!-- 또는end -->

						<!-- Oauth 소셜로그인 -->
						<div class="login__facebook">
							<button
								onclick="javascript:location.href='/oauth2/authorization/facebook'">
								<i class="fab fa-facebook-square"></i> <span>Facebook으로
									로그인</span>
							</button>
						</div>

						<!-- 구글 소셜 로그인 -->
						<div class="login__google">
							<button
								onclick="javascript:location.href='/oauth2/authorization/google'">
								<svg class="google-logo" xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 48 48" width="18px" height="18px">
      									<path fill="#FFC107"
										d="M43.611,20.083H42V20H24v8h11.303c-1.649,4.657-6.08,8-11.303,8c-6.627,0-12-5.373-12-12c0-6.627,5.373-12,12-12c3.059,0,5.842,1.154,7.961,3.039l5.657-5.657C34.046,6.053,29.268,4,24,4C12.955,4,4,12.955,4,24c0,11.045,8.955,20,20,20c11.045,0,20-8.955,20-20C44,22.659,43.862,21.35,43.611,20.083z" />
      									<path fill="#FF3D00"
										d="M6.306,14.691l6.571,4.819C14.655,15.108,18.961,12,24,12c3.059,0,5.842,1.154,7.961,3.039l5.657-5.657C34.046,6.053,29.268,4,24,4C16.318,4,9.656,8.337,6.306,14.691z" />
      									<path fill="#4CAF50"
										d="M24,44c5.166,0,9.86-1.977,13.409-5.192l-6.19-5.238C29.211,35.091,26.715,36,24,36c-5.202,0-9.619-3.317-11.283-7.946l-6.522,5.025C9.505,39.556,16.227,44,24,44z" />
      									<path fill="#1976D2"
										d="M43.611,20.083H42V20H24v8h11.303c-0.792,2.237-2.231,4.166-4.087,5.571c0.001-0.001,0.002-0.001,0.003-0.002l6.19,5.238C36.971,39.205,44,34,44,24C44,22.659,43.862,21.35,43.611,20.083z" />
    							</svg>
								<span>구글 계정으로 로그인</span>
							</button>
						</div>
						<!-- Oauth 소셜로그인end -->
					</div>

					<!--계정이 없으신가요?-->
					<div class="login__register">
						<span>계정이 없으신가요?</span> <a href="/auth/signup">가입하기</a>
					</div>
					<!--계정이 없으신가요?end-->
				</article>
			</section>
		</main>

	</div>
</body>

</html>