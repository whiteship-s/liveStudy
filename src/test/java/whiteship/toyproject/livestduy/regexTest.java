package whiteship.toyproject.livestduy;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexTest {

    @Test
    void regexTest() {
        String testStr = "# 목표\\r\\n자바가 제공하는 제어문을 학습하세요.\\r\\n\\r\\n# 학습할 것 (필수)\\r\\n선택문\\r\\n반복문\\r\\n\\r\\n# 과제 (옵션)\\r\\n\\r\\n## 과제 0. JUnit 5 학습하세요.\\r\\n* 인텔리J, 이클립스, VS Code에서 JUnit 5로 테스트 코드 작성하는 방법에 익숙해 질 것.\\r\\n* 이미 JUnit 알고 계신분들은 다른 것 아무거나!\\r\\n* [더 자바, 테스트](https://www.inflearn.com/course/the-java-application-test?inst=86d1fbb8) 강의도 있으니 참고하세요~\\r\\n\\r\\n## 과제 1. live-study 대시 보드를 만드는 코드를 작성하세요.\\r\\n* 깃헙 이슈 1번부터 18번까지 댓글을 순회하며 댓글을 남긴 사용자를 체크 할 것.\\r\\n* 참여율을 계산하세요. 총 18회에 중에 몇 %를 참여했는지 소숫점 두자리가지 보여줄 것.\\r\\n* [Github 자바 라이브러리](https://github-api.kohsuke.org/)를 사용하면 편리합니다.\\r\\n* 깃헙 API를 익명으로 호출하는데 제한이 있기 때문에 본인의 깃헙 프로젝트에 이슈를 만들고 테스트를 하시면 더 자주 테스트할 수 있습니다.\\r\\n\\r\\n## 과제 2. LinkedList를 구현하세요.\\r\\n* LinkedList에 대해 공부하세요.\\r\\n* 정수를 저장하는 ListNode 클래스를 구현하세요.\\r\\n* ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.\\r\\n* ListNode remove(ListNode head, int positionToRemove)를 구현하세요.\\r\\n* boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.\\r\\n\\r\\n## 과제 3. Stack을 구현하세요.\\r\\n* int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.\\r\\n* void push(int data)를 구현하세요.\\r\\n* int pop()을 구현하세요.\\r\\n\\r\\n## 과제 4. 앞서 만든 ListNode를 사용해서 Stack을 구현하세요.\\r\\n* ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.\\r\\n* void push(int data)를 구현하세요.\\r\\n* int pop()을 구현하세요.\\r\\n\\r\\n## 과제 5. Queue를 구현하세요.\\r\\n* 배열을 사용해서 한번\\r\\n* ListNode를 사용해서 한번.\\r\\n\\r\\n# 마감일시\\r\\n2020년 12월 12일 토요일 오후 1시까지.";
        String testStr2 = "# 목표\r\n자바의 Class에 대해 학습하세요.\r\n\r\n# 학습할 것 (필수)\r\n* 클래스 정의하는 방법\r\n* 객체 만드는 방법 (new 키워드 이해하기)\r\n* 메소드 정의하는 방법\r\n* 생성자 정의하는 방법\r\n* this 키워드 이해하기\r\n\r\n# 마감일시\r\n2020년 12월 19일 토요일 오후 1시까지.\r\n\r\n# 과제 (Optional)\r\n* int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요.\r\n* int value, Node left, right를 가지고 있어야 합니다.\r\n* BinrayTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node)와 dfs(Node node) 메소드를 구현하세요.\r\n* DFS는 왼쪽, 루트, 오른쪽 순으로 순회하세요.\r\n";
        String url = "[14주차 과제](https://velog.io/@honux/%EB%B0%B1%EA%B8%B0%EC%84%A0-%EB%9D%BC%EC%9D%B4%EB%B8%8C-%EC%9E%90%EB%B0%94-%EC%8A%A4%ED%84%B0%EB%94%94-14-%EC%A0%9C%EB%84%A4%EB%A6%AD) sdlfksjdflj 과제 : http://www.tajamaster.com/ex3_1.php?txt=27&ttt=ex3_1";

//        String[] split = testStr.split("# 과제 [0-9]");
//        String[] split1 = testStr2.split("# 과제 [0-9]");
//
//        String[] last = split[1].split("\\\\r\\\\n");

        String REGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern p = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(url);
        m.results().forEach(r -> System.out.println("r = " + r.group()));
    }
}
