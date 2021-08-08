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
public class GithubUserController {
//
//	@GetMapping(value = {"/user/", "/user/{param}"})
//	public Result getUser(@PathVariable(required = false) String param) {
//		LogUtil.log.debug("===== getUser start =====");
//
//		final Result result = new Result();
//		final ResultMap resultMap = new ResultMap();
//
//		try {
//
//			if(param == null) {
//				result.setMessage("오류 메시지 추가");
//				return result;
//			}
//
//			// 추가
//			resultMap.add("user", null);
//			result.setResultMap(resultMap);
//			result.setCode(ResultCodeEnum.SUCCESS.getCode());
//			result.setMessage(ResultCodeEnum.SUCCESS.getDescription());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			LogUtil.log.debug("----- getUser error -----" + e);
//			result.setMessage("[e] 오류 메시지");
//		}
//
//		LogUtil.log.debug("===== getUser start =====");
//		return result;
//
//	}
//
//	@GetMapping(value = {"/users", "/user-list"})
//	public Result getUserList() {
//		LogUtil.log.debug("===== getUserList start =====");
//
//		final Result result = new Result();
//		final ResultMap resultMap = new ResultMap();
//
//		try {
//
//			//추가
//			resultMap.add("users", null);
//			result.setResultMap(resultMap);
//			result.setCode(ResultCodeEnum.SUCCESS.getCode());
//			result.setMessage(ResultCodeEnum.SUCCESS.getDescription());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			LogUtil.log.debug("----- getUserList error -----" + e);
//			result.setMessage("[e] 오류 메시지");
//		}
//
//		LogUtil.log.debug("===== getUserList end =====");
//		return result;
//	}
	
}
