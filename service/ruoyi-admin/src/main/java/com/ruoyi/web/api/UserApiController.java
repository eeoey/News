package com.ruoyi.web.api;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**

 * @date 2021/4/6

 */
@RequestMapping("/api/v1/user")
@RestController
@Api("用户管理")
@CrossOrigin
public class UserApiController {
    @Autowired
    private IUserInfoService service;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("登录")
    public AjaxResult login(@RequestParam @ApiParam String username,@RequestParam @ApiParam String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, true, "WEB");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return AjaxResult.success();
        } catch (AuthenticationException e) {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return AjaxResult.error(msg);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation("注册")
    public AjaxResult register(@RequestBody @ApiParam UserInfo param){
        UserInfo oldUserParam = new UserInfo();
        oldUserParam.setPhoneNumber(param.getPhoneNumber());
        if(!service.selectUserInfoList(oldUserParam).isEmpty()){
            return AjaxResult.error("用户已被注册");
        }
        service.register(param);
        return AjaxResult.success();
    }


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation("退出登录")
    public AjaxResult logout(){
        ShiroUtils.logout();
        return AjaxResult.success();
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ApiOperation("详情")
    public AjaxResult info(){
        return AjaxResult.success(service.selectUserInfoById(ShiroUtils.getUserId()));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("更新信息")
    public AjaxResult updateInfo(@RequestBody UserInfo param){
        param.setPassword(null);
        param.setId(ShiroUtils.getUserId());
        service.updateUserInfo(param);
        return AjaxResult.success();
    }

}
