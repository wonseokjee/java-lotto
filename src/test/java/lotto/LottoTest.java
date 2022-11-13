package lotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    // 아래에 추가 테스트 작성 가능
    CreateLotto createLotto = new CreateLotto();

    @Test
    void CreateLottoTestByOverSize() {
        assertThat(createLotto.numbers.size()).isEqualTo(6);
    }

    @DisplayName("1000원으로 나누어지지 않으면 에러가 발생한다.")
    @Test
    void ValidateUserPayDivide1000() {
        assertThatThrownBy(() -> new User(9800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 당첨번호를 넣었을 때 숫자 리스트로 리턴된다.")
    @Test
    void InputWinningNumberTest() {
        /*given*/
        List<Integer> winningNumberTest = List.of(1,2,3,4,5,6);
        /*when*/
        List<Integer> winningNumber = createLotto.winningNumber("1,2,3,4,5,6");
        /*then*/
        assertThat(winningNumberTest).isEqualTo(winningNumber);
    }

    @DisplayName("금액을 입력하면 티켓 갯수를 출력한다.")
    @Test
    void countTicket() {
        User user = new User(8000);
        /*given*/
        int countTicketTest = 8;
        /*when*/
        int countTicket = user.countTicket();
        /*then*/
        assertThat(countTicketTest).isEqualTo(countTicket);


    }
}

/*class RefereeTest{
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);
    private Referee referee;

    @BeforeEach
    void SetUp(){
        referee = new Referee();
    }
    @ParameterizedTest
    @CsvSource({"1,2,3,0 볼 3 스트라이크", "7,8,9,아웃", "2,3,1,3 볼 0 스트라이크"})
    public void compare(int number1, int number2, int number3, String expected) {
        String actual = referee.compare(ANSWER, Arrays.asList(number1, number2, number3));
        assertThat(actual).isEqualTo(expected);
    }
}*/
