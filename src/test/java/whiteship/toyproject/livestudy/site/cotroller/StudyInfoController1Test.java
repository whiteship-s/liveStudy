package whiteship.toyproject.livestudy.site.cotroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import whiteship.toyproject.livestudy.site.service.CommentService1;
import whiteship.toyproject.livestudy.site.service.StudyInfoService1;



@WebMvcTest()
class StudyInfoController1Test {

  @Autowired
  private MockMvc mockMvc;
  @MockBean private StudyInfoService1 studyInfoService1;
  @MockBean private CommentService1 commentService1;

  @Test
  void getIssueTest() throws Exception {
    mockMvc.perform(get("/v1/issue/1"))
        .andExpect(status().isOk())
        .andDo(print());
  }
}