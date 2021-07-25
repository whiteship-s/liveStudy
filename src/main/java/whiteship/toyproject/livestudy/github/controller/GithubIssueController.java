package whiteship.toyproject.livestudy.github.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import whiteship.toyproject.livestudy.common.result.Result;
import whiteship.toyproject.livestudy.common.result.ResultCodeEnum;
import whiteship.toyproject.livestudy.common.result.ResultMap;
import whiteship.toyproject.livestudy.common.util.LogUtil;

@RestController
@RequestMapping("/api/github/")
public class GithubIssueController {

	
	// http://localhost:8080/api/github/issue/1
	
	@GetMapping(value = {"/issue/", "/issue/{param}"}) 
	public Result getIssue(@PathVariable(required = false) String param) {
		LogUtil.log.debug("===== getIssue start =====");
		
		final Result result = new Result();
		final ResultMap resultMap = new ResultMap();
		
		try {
			
			if(param == null) {
				result.setMessage("오류 메시지 추가");
				return result;
			}
			
			// 추가 
			resultMap.add("issue1", null);
			result.setResultMap(resultMap);
			result.setCode(ResultCodeEnum.SUCCESS.getCode());
			result.setMessage(ResultCodeEnum.SUCCESS.getDescription());

		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.log.debug("----- getIssue error -----" + e);
			result.setMessage("[e] 오류 메시지");
		}

		LogUtil.log.debug("===== getIssue end =====");
		return result;
		
	}
	
	@GetMapping(value = {"/issues", "/issue-list"}) 
	public Result getIssueList() {
		LogUtil.log.debug("===== getIssueList start =====");
		
		final Result result = new Result();
		final ResultMap resultMap = new ResultMap();
		
		try {

			//추가 
			resultMap.add("issues", null);
			result.setResultMap(resultMap);
			result.setCode(ResultCodeEnum.SUCCESS.getCode());
			result.setMessage(ResultCodeEnum.SUCCESS.getDescription());
			
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.log.debug("----- getIssueList error -----" + e);
			result.setMessage("[e] 오류 메시지");
		}
		
		LogUtil.log.debug("===== getIssueList end =====");
		return result;
	}
	
}
