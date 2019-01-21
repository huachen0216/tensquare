package com.tensquare.user.controller;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import java.util.HashMap;
import java.util.Map;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Result login(@RequestBody User user) {
        User userLogin = userService.login(user);
        if (userLogin == null) {
            return new Result(false, StatusCode.LOGINERROR, "登陆失败");
        }

		// 生成令牌
		String token = jwtUtil.createJWT(userLogin.getId(), userLogin.getLoginname(), "user");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("token", token);
		map.put("role", "user");
        return new Result(true, StatusCode.OK, "登陆成功", map);
    }
	@RequestMapping(value = "/register/{code}", method = RequestMethod.POST)
	public Result register(@PathVariable String code, @RequestBody User user) {
		String checkCodeRedis = (String) redisTemplate.opsForValue().get("checkcode_" + user.getMobile());
		if (StringUtils.isEmpty(checkCodeRedis)) {
			return new Result(false, StatusCode.ERROR, "请重新获取验证码");
		}
		if (!StringUtils.equals(checkCodeRedis, code)) {
			return new Result(false, StatusCode.ERROR, "验证码错误");
		}
		userService.add(user);
		return new Result(true, StatusCode.OK, "注册成功");
	}

	@RequestMapping(value = "/sendsms/{mobile}", method = RequestMethod.POST)
	public Result sendSms(@PathVariable String mobile) {
		userService.sendSms(mobile);
		return new Result(true, StatusCode.OK, "发送成功");
	}

	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true, StatusCode.OK,"查询成功",userService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",userService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<User> pageList = userService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<User>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",userService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param user
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody User user  ){
		userService.add(user);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param user
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody User user, @PathVariable String id ){
		user.setId(id);
		userService.update(user);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除 必须是admin角色才能删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		userService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
