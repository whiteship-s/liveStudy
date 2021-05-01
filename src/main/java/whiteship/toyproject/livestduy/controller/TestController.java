package whiteship.toyproject.livestduy.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @GetMapping
  public void test() throws Exception {
    logger.info("INFO level test");
    logger.debug("DEBUG level test");
    logger.trace("TRACE level test");
    logger.warn("WARN level test");
    logger.error("ERROR level test");
  }
}
