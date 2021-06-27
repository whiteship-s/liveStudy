package whiteship.toyproject.livestudy.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyInfoServiceTest {

  @Autowired
  GHRepository repository;

  StudyInfoService studyInfoService;

  @BeforeEach
  void setUp() {
    studyInfoService = new StudyInfoService(repository);
  }

  @Test
  void TitleTest1() throws IOException {
    assertThat(studyInfoService.getTitle(1)).isEqualTo("JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");
  }

  @Test
  void titleTest4() throws IOException {
    assertThat(studyInfoService.getTitle(4)).isEqualTo("제어문");
  }

  @Test
  void titleTest15() throws IOException {
    assertThat(studyInfoService.getTitle(15)).isEqualTo("람다식");
  }

  @Test
  void testGetGoal4() throws IOException {
    String[] body = studyInfoService.getBody(4, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바가 제공하는 제어문을 학습하세요.");
  }

  @Test
  void testGetGoal1() throws IOException {
    String[] body = studyInfoService.getBody(1, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0]))
        .isEqualTo("자바 소스 파일(.java)을 JVM으로 실행하는 과정 이해하기.");
  }

  @Test
  void testGetGoal2() throws IOException {
    String[] body = studyInfoService.getBody(2, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0]))
        .isEqualTo("자바의 프리미티브 타입, 변수 그리고 배열을 사용하는 방법을 익힙니다.");
  }

  @Test
  void testGetGoal3() throws IOException {
    String[] body = studyInfoService.getBody(3, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바가 제공하는 다양한 연산자를 학습하세요.");
  }

  @Test
  void testGetGoal5() throws IOException {
    String[] body = studyInfoService.getBody(5, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 Class에 대해 학습하세요.");
  }

  @Test
  void testGetGoal6() throws IOException {
    String[] body = studyInfoService.getBody(6, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 상속에 대해 학습하세요.");
  }

  @Test
  void testGetGoal7() throws IOException {
    String[] body = studyInfoService.getBody(7, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 패키지에 대해 학습하세요.");
  }

  @Test
  void testGetGoal8() throws IOException {
    String[] body = studyInfoService.getBody(8, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 인터페이스에 대해 학습하세요.");
  }

  @Test
  void testGetGoal9() throws IOException {
    String[] body = studyInfoService.getBody(9, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 예외 처리에 대해 학습하세요.");
  }

  @Test
  void testGetGoal10() throws IOException {
    String[] body = studyInfoService.getBody(10, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 멀티쓰레드 프로그래밍에 대해 학습하세요.");
  }

  @Test
  void testGetGoal11() throws IOException {
    String[] body = studyInfoService.getBody(11, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 열거형에 대해 학습하세요.");
  }

  @Test
  void testGetGoal12() throws IOException {
    String[] body = studyInfoService.getBody(12, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 애노테이션에 대해 학습하세요.");
  }

  @Test
  void testGetGoal13() throws IOException {
    String[] body = studyInfoService.getBody(13, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 Input과 Ontput에 대해 학습하세요.");
  }

  @Test
  void testGetGoal14() throws IOException {
    String[] body = studyInfoService.getBody(14, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 제네릭에 대해 학습하세요.");
  }

  @Test
  void testGetGoal15() throws IOException {
    String[] body = studyInfoService.getBody(15, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 람다식에 대해 학습하세요.");
  }

  @Test
  void testGetLearn4() throws IOException {
    String[] body = studyInfoService.getBody(4, "\r\n\r\n");
    System.out.println(body[1]);
  }

  @Test
  void testGetLearn() throws IOException {
    String[] body = studyInfoService.getBody(1, "\r\n\r\n");
    System.out.println(body[1]);
  }

  @Test
  void testGetLearn2() throws IOException {
    String[] body = studyInfoService.getBody(2, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0]))
        .isEqualTo("자바의 프리미티브 타입, 변수 그리고 배열을 사용하는 방법을 익힙니다.");
  }

  @Test
  void testGetLearn3() throws IOException {
    String[] body = studyInfoService.getBody(3, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바가 제공하는 다양한 연산자를 학습하세요.");
  }

  @Test
  void testGetLearn5() throws IOException {
    String[] body = studyInfoService.getBody(5, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 Class에 대해 학습하세요.");
  }

  @Test
  void testGetLearn6() throws IOException {
    String[] body = studyInfoService.getBody(6, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 상속에 대해 학습하세요.");
  }

  @Test
  void testGetLearn7() throws IOException {
    String[] body = studyInfoService.getBody(7, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 패키지에 대해 학습하세요.");
  }

  @Test
  void testGetLearn8() throws IOException {
    String[] body = studyInfoService.getBody(8, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 인터페이스에 대해 학습하세요.");
  }

  @Test
  void testGetLearn9() throws IOException {
    String[] body = studyInfoService.getBody(9, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 예외 처리에 대해 학습하세요.");
  }

  @Test
  void testGetLearn10() throws IOException {
    String[] body = studyInfoService.getBody(10, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 멀티쓰레드 프로그래밍에 대해 학습하세요.");
  }

  @Test
  void testGetLearn11() throws IOException {
    String[] body = studyInfoService.getBody(11, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 열거형에 대해 학습하세요.");
  }

  @Test
  void testGetLearn12() throws IOException {
    String[] body = studyInfoService.getBody(12, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 애노테이션에 대해 학습하세요.");
  }

  @Test
  void testGetLearn13() throws IOException {
    String[] body = studyInfoService.getBody(13, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 Input과 Ontput에 대해 학습하세요.");
  }

  @Test
  void testGetLearn14() throws IOException {
    String[] body = studyInfoService.getBody(14, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 제네릭에 대해 학습하세요.");
  }

  @Test
  void testGetLearn15() throws IOException {
    String[] body = studyInfoService.getBody(15, "\r\n\r\n");
    assertThat(studyInfoService.removeGoal(body[0])).isEqualTo("자바의 람다식에 대해 학습하세요.");
  }

}