# 자동차 경주 게임

## 요구 사항

### 기능 요구사항
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
  - 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
- 실행 결과 예시
  ```text
    경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
    pobi,crong,honux
    시도할 회수는 몇회인가요?
    5
    
    실행 결과
    pobi : -
    crong : -
    honux : -
    
    pobi : --
    crong : -
    honux : --
    
    pobi : ---
    crong : --
    honux : ---
    
    pobi : ----
    crong : ---
    honux : ----
    
    pobi : -----
    crong : ----
    honux : -----
    
    pobi : -----
    crong : ----
    honux : -----
    
    pobi, honux가 최종 우승했습니다.
  ```

### 프로그래밍 요구사항
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- **모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다.** 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- **모든 원시 값과 문자열을 포장한다.**
- **일급 컬렉션을 쓴다.**

### 기능 목록 및 commit 로그 요구사항
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
  - git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
- 참고문서: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)


## 구현할 기능 목록

### Domain
#### Car
- 차의 이름을 받아 객체를 생성하는 기능
  - 이름의 길이가 5글자 초과인 경우 예외를 던진다
- 랜덤 값에 따라 움직이는 기능
  - 랜덤 값 0에서 9사이 중 4 이상일 경우 움직인다.
- 차의 이름과 현재 위치를 반환하는 기능 구현

#### Cars
- 객체 생성자 구현
  - 이름이 없는 경우 예외를 발생함
- 차들을 전부 움직이는 기능
- 차들의 현재 위치와 이름들은 반환하는 기능


### View
#### InputView
- 차의 이름들을 입력받는 기능
- 시도 횟수를 입력받는 기능

#### OutputView
- 차들의 실행 결과를 출력하는 기능
  - 중간 결과와 최종 결과까지 같이 출력함

### Controller
#### CarRaceController
- 전반적인 진행 흐름 구현 (차 이름 입력, 결과 실행)