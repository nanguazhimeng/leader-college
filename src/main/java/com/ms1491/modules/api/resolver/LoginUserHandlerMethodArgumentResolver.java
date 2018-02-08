package com.ms1491.modules.api.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.ms1491.common.exception.RRException;
import com.ms1491.modules.api.annotation.LoginUser;
import com.ms1491.modules.api.interceptor.AuthorizationInterceptor;
import com.ms1491.modules.api.utils.ApiCode;
import com.ms1491.modules.appuser.entity.AppUserEntity;
import com.ms1491.modules.appuser.service.AppUserService;

/**
 * 有@LoginUser注解的方法参数，注入当前登录用户
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-03-23 22:02
 */
@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private AppUserService appUserService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(AppUserEntity.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
        //获取用户ID
        Object object = request.getAttribute(AuthorizationInterceptor.LOGIN_USER_KEY, RequestAttributes.SCOPE_REQUEST);
        if(object == null){
            return null;
        }

        //获取用户信息
        AppUserEntity user = appUserService.queryObject((String)object);
        if(user==null){
        	 throw new RRException("用户不存在",ApiCode.AC_INTERNAL_SERVER_ERROR);
        }
        
        if("0".equals(user.getStatus())){
        	 throw new RRException("账号被禁用",ApiCode.AC_ACCOUNT_DISABLED);
        }
        return user;
    }
}
