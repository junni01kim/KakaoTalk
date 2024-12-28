# kakaotalk
2024 고급 모바일 프로그래밍 수업 이수를 위한, Flutter 연습용 숏 프로젝트

목표: Dart 학습, Flutter 프론트 디자인 학습

## 플러터 실행 디바이스 수정 방법
```
[ctrl + shitf + p]
Flutter: Select Device 
```

## 에뮬레이터 띄우는 방법

```
[ctrl + shitf + p]
Flutter: Launch Emulator
```

## 각 파일 설명
`pubspec.yaml` 파일은 앱에 관한 기본 정보(예: 현재 버전, 종속 항목, 함께 제공될 애셋)를 지정한다.

## 코드 해석
1. 파일 최상단에는 main() 함수가 있습니다. 현재 형식으로는 MyApp에서 정의된 앱을 실행하라고 Flutter에 지시할 뿐입니다.
2. MyApp의 코드는 전체 앱을 설정합니다. 앱 전체 상태를 생성하고(나중에 자세히 설명) 앱의 이름을 지정하고 시각적 테마를 정의하고 '홈' 위젯(앱의 시작점)을 설정합니다.
3. `build()` 위젯의 상황이 변경될 때마다 자동으로 호출된다.
4.`watch()` 메서드를 사용하여 앱의 현재 상태에 관한 변경사항을 추적합니다
5. Flutter 코드에서는 후행 쉼표를 많이 사용합니다.
6. 리팩터링하려는 코드 부분(여기서는 Text)으로 커서를 이동하고 `Ctrl+.`

## 사용 기능
1. ListView builder
2. TextField
3. TextEditingController
4. Flexible, Expanded

## 배운 것 
1. lower_case로 파일을 만들지 않으면 많은 오류가 발생한다.
2. 위젯 생성 시 화면 크기가 무한대가 되는 오류 조심할 것.
3. 1회만 사용하는 코드들은 `const`를 붙여 상수화 시키는 것이 유리하다. (Q. 한번만 사용할 것을 상수화 시키면 메모리 낭비 아닌가?)
4. if문을 right(명칭 생각안남)에 배치하지 못한다.
