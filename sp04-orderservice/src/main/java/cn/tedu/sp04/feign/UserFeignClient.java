package cn.tedu.sp04.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;

@FeignClient(name= "user-service" ,fallback = UserFeignClientFB.class)
public interface UserFeignClient {
	@GetMapping("/{userId}")
	JsonResult<User> getUser(@PathVariable Integer userId);
	
	@GetMapping("/{userId}/score")
	JsonResult addScore(@PathVariable Integer userId,@RequestBody Integer score);

}
