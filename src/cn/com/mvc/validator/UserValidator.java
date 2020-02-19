package cn.com.mvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.com.mvc.model.User;

//通过Spring validator接口，编写校验User的校验类
//UserValidator校验类只针对User进行校验，所以需要通过"supports"方法进行验证
public class UserValidator implements Validator{
	
	@Override
	//判断参数类是否与User是相同的类
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	//编写校验User类的方法
	public void validate(Object obj, Errors errors) {
		
		User user=(User)obj;//参数为User类型的实例对象
		String name=user.getName();
		String password=user.getPassword();
		//判断user实例中"name"和"password"是否为Null
		if(password==null || password.equals("")){
			//添加错误提示
			errors.rejectValue("password", "password.is.empty","密码不能为空！");
		}
		else if(password.length()<6){
			//添加错误提示
			errors.rejectValue("password", "password.to.length","密码长度不能小于6位！");
		}
	}
	
}
