# KaKaoTalkThemedChatWindowByJetpackCompose

## 실행화면
![image](https://github.com/junni01kim/KakaoTalkThemedChatWindowByJetpackCompose/assets/127941871/5dd9db3f-21c8-4afc-af59-41854a8b64bd)
<img width="170" alt="KakaoTalk_20240309_010811782" src="https://github.com/junni01kim/KakaoTalkThemedChatWindowByJetpackCompose/assets/127941871/e0aab91a-9c5e-4a0c-9e33-b502225dd3aa">

## Jetpack Compose를 이용한 카카오톡 채팅방 만들기

## 개요
 해당 프로그램은 추후 제작할 보행자 네비게이션 프로그램에 사용할 Jetpack Compose의 Composable 개발 방식을 이해하기 위한 연습용 프로젝트이다.

## 구현 기능
 1) 창 넘기기 기능: 화면 시작 시 여러 버튼중 하나를 눌러 원하는 번호의 채팅창을 들어갈 수 있다. 반대로 채팅창에서 뒤로가기 버튼을 누르면 뒤로갈 수 있다.  
 2) 채팅 기능: 하단의 TextField에 텍스트를 입력하면 상단에 자신의 채팅이 등록된다.

## 작동방식
  - 하나의 채팅 클래스는 name과 text로 구성된다.
  - Button에 있는 람다함수를 통해 외부에 있는 또 다른 Composable에 값을 전달한다.

## 미구현 요소
  - 해당 프로젝트는 Jetpack Compose를 다뤄보기 위한 목적이기에 해당 부분은 아직 만들지 않았다
    1. 화면 회전 시 컴포저블이 초기화 된다.
    2. 뒤로가기 후 다시 되돌아올 시 컴포저블이 초기화 된다.
