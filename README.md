# 자동차 경주 게임
## 구현 필요 기능
1. n대의 자동차를 주어진 회수 동안 전진 혹은 멈추도록 함
1-1. 사용자로부터 자동차 수와 이동할 회수를 입력받을 수 있어야 함
1-1-1. 입력값이 잘못되었을 때 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 메시지를 출력한 다음 해당 부분부터 다시 입력받는다.
1-2. 0에서 9사이 중 random값을 구한 후 4 이상일 때 전진한다
1-2-1. 자동차가 얼마나 전진했는지 하이픈(-)으로 표시
2. 각 자동차에 이름을 부여할 수 있어야 함
2-1. 이름은 5자 이하, 쉼표로 구분
3. 경주 게임이 완료되었을 때 우승자를 표시한다
3-1. 우승자가 여럿일 경우 쉼표로 구분