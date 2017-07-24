package com.fxp.springmvc.handlers;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fxp.springmvc.entities.User;
@SessionAttributes(value={"user"},types={String.class})
//@SessionAttributes({"user"})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	private static final String SUCCESS="success";
	
	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver(){
		System.out.println("testViewAndViewResolver");
		return SUCCESS;
	}
	
	/**
	 * 1.@RequestMapping除了修饰方法，还可以修饰类
	 * 
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		System.out.println("testRequestMapping");
		return SUCCESS;
	}
	/**
	 * 使用method属性来指定请求方式
	 * @return
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("testMethod");
		return SUCCESS;
	}
	/**
	 * 使用params和headers属性来精确指定请求方式
	 * @return
	 */
	@RequestMapping(value="testParamsAndHeaders",params={"username","age!=2"},headers={"Accept-Language=en,zh-CN;q=0.8,zh;q=0.6"})
	public String testParamsAndHeaders(){
		System.out.println("testParamsAndHeaders");
		return SUCCESS;
	}
	/**
	 * 支持ant通配符
	 * ?:一个字符，*:多个字符，**:多层路径
	 * 
	 * @return
	 */
	@RequestMapping(value="/testAntPath/*/ant")
	public String testAntPath(){
		System.out.println("testAntPath");
		return SUCCESS;
	}
	/**
	 * @PathVariable 可以映射URL中的占位符到目标方法的参数中
	 * @return
	 */
	@RequestMapping(value="/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id){
		System.out.println("testPathVariable id:"+id);
		return SUCCESS;
	}
	
	/**
	 * Rest 风格URL
	 * 以CRUD为例：
	 * 新增：/order POST
	 * 修改：/order/1 PUT
	 * 获取：/order/1 GET
	 * 删除：/order/1 DELETE
	 * 
	 * 如何发送DELETE和PUT
	 * 1.需要配置HiddenHttpMethodFilter
	 * 2.需要发送POST请求
	 * 3.需要在发送POST请求时携带一个name="_method"的隐藏域，值为DELETE或PUT
	 * 
	 * 在SpringMVC的目标方法中如何得到id？
	 * 使用@PathVariable注解
	 * @return
	 */
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.GET)
	public String testRestGet(@PathVariable("id") Integer id){
		System.out.println("testRest GET:"+id);
		return SUCCESS;
	}
	/**
	 * Rest
	 * @return
	 */
	@RequestMapping(value="/testRest",method=RequestMethod.POST)
	public String testRestPost(){
		System.out.println("testRest POST");
		return SUCCESS;
	}
	/**
	 * Rest
	 * @return
	 */
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") Integer id){
		System.out.println("testRest DELETE:"+id);
		return SUCCESS;
	}
	/**
	 * Rest
	 * @return
	 */
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id){
		System.out.println("testRest PUT:"+id);
		return SUCCESS;
	}
	
	/**
	 * @RequestParam 来映射请求参数
	 * value值即请求参数的参数名
	 * required该参数是否必须，默认为true
	 * defaultValue请求参数的默认值
	 * @return
	 */
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam(value="username")String username,
			@RequestParam(value="age",required=false,defaultValue="0")int age){
		System.out.println("testRequestParam username:"+username+" age:"+age);
		return SUCCESS;
	}
	/**
	 * 用法同上，映射请求头
	 * @param al
	 * @return
	 */
	@RequestMapping(value="/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language")String al){
		System.out.println("testRequestHeader al:"+al);
		return SUCCESS;
	}
	/**
	 * 了解：
	 * @CookieValue 用法同上
	 * @param sessionId
	 * @return
	 */
	@RequestMapping(value="/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
		System.out.println("testCookieValue sessionId:"+sessionId);
		return SUCCESS;
	}
	/**
	 * Spring MVC会按照请求参数名和POJO属性名进行自动匹配。
	 * 自动为该对象填充属性值。支持级联属性
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/testpojo")
	public String testpojo(User user){
		System.out.println("testpojo user:"+user);
		return SUCCESS;
	}
	/**
	 * 原生api做参数，具体类型见AnnotationMethodHandlerAdapter.resolveStandardArgument()
	 * @param req
	 * @param res
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/testServletAPI")
	public void testServletAPI(HttpServletRequest req,HttpServletResponse res,Writer out) throws IOException{
		System.out.println("testServletAPI req:"+req+" res:"+res);
		out.write("hello springmvc");
//		return SUCCESS;
	}
	/**
	 * 目标方法的返回值可以是ModelAndView类型
	 * 其中包含视图和模型信息
	 * @return
	 */
	@RequestMapping(value="/testModelAndView")
	public ModelAndView testModelAndView(){
		String viewName=SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("time",new Date());
		return modelAndView;
	}
	/**
	 * 目标方法可以添加（Map,Model,ModelMap）类型的参数，request会把它的map引用传给入参
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/testMap")
	public String testMap(Map<String, Object> map){
		System.out.println(map.getClass().getName());
		map.put("names", Arrays.asList("tome","jerry"));
		return SUCCESS;
	}
	/**
	 * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外（实际上使用的是value属性值）
	 * 还可以通过模型属性的对象类型指定那些模型属性需要放到会话中（实际上使用的是types属性值）
	 * 注意：该注解只能在类上
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map){
		User user = new User("tom", "111", "111@111", 11);
		map.put("user", user);
		map.put("address", "nanjing");
		return SUCCESS;
	}
	/**
	 * 运行流程：
	 * 1.执行@ModelAttribute注解修饰的方法：从数据库中取出对象，把对象放入到了Map中，键为：user
	 * 2.SpringMVC从Map中取出User对象，并把表单的请求参数赋给该User对象的对应属性。
	 * 3.SpringMVC把上述对象传入目标方法的参数。
	 * 
	 * 注意：在@ModelAttribute注解修饰的方法中放入到Map是的键需要和目标方法入参类型的第一个字母小写的字符串一致。
	 * 
	 * SpringMVC确定目标方法POJO类型入参的过程
	 * 1.确定key
	 * 1)若目标方法的POJO类型的参数没有使用@ModelAttribute作为修饰，则key为POJO类名第一个字母小写
	 * 2)若使用了@ModelAttribute类修饰，则key为@ModelAttribute注解的value属性值。
	 * 2.在implicitModel中查找key对应的对象，若存在，则作为入参传入。
	 * 1)若在@ModelAttribute标记的方法中在Map中保存过，且key和1确定的key一致，则会获取到。
	 * 3.若implicitModel中不存在key对应的对象，则检查当前的Handler是否使用@SessionAttributes注解修饰，
	 * 若使用了该注解，且@SessionAttributes注解的value属性值中包含了key，则会从HttpSession中获取
	 * 对应的value值，若存在则直接传入到目标方法的入参中，若不存在则抛异常。
	 * 4.若Handler没有标注@SessionAttributes注解或SessionAttributes注解的value值中不包含key，则
	 * 会通过反射来创建POJO类型的参数，传入为目标方法的参数
	 * 5.SpringMVC会把key和value保存到implicitModel中，进而会保存到request中。
	 * 
	 * 源码分析的流程：
	 * 1.调用@ModelAttribute注解修饰的方法，实际上把@ModelAttribute方法中Map中的数据放在了implicitModel中。
	 * 2.解析请求处理器的目标参数，实际上该目标参数来自于WebDataBinder对象的target属性
	 * 1)创建WebDataBinder对象：
	 * 	1>确定objectName属性：若传入的attrName属性值为"",则objectName为类名第一个字母小写。
	 * 	*注意：attrName。若目标方法的POJO属性使用了@Modelattribute来修饰，则attrName值即为@ModelAttribute的value属性值。
	 * 	2>确定target属性：
	 * 	~在implicitModel中查找attrName对应的属性值。若存在，ok
	 * 	~*若不存在：则验证当前Handler是否使用了@SessionAttributes进行修饰，若使用了，则尝试从Session中获取attrName所对应的属性值。
	 * 	~若session中没有对应的属性值，则抛出异常。
	 * 	~若Handler没有使用@SessionAttributes进行修饰，或@SessionAttributes中没有使用value值指定的key和attrName相匹配，则通过反射创建了POJO对象。
	 * 2)SpringMVC把表单的请求参数赋值给了WebDataBinder的target对应的属性。
	 * 3)*SpringMVC会把WebDataBinder的attrName和target给到implicitModel
	 * 4)把WebDataBinder的target作为参数传递给目标方法的入参。
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/testModelAttribute")
	public String testModelAttribute(User user){
		System.out.println("修改："+user);
		return SUCCESS;
	}
	/**
	 * 1.由@ModelAttribute 标记的方法，会在每个目标方法执行之前被SpringMVC调用
	 * 2.这个注解也可以来修饰目标方法POJO类型的入参，其value属性值有如下的作用：
	 * 1)SpringMVC会使用value属性值在implicitModel中查找对应的对象，如存在则会直接传入到目标方法的入参中。
	 * 2)SpringMVC会以value为key，POJO类型的对象为value，存入到request中。
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false)Integer id,Map<String,Object> map){
		System.out.println("ModelAttribute");
		if(id!=null){
			//模拟从数据库中获取对象
			User user=new User(1,"tom","123","tom@111",11);
			System.out.println("从数据库中获取对象："+user);
			map.put("user", user);
		}
	}
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView");
		return "helloView";
	}
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		System.out.println("testRedirect");
		return "redirect:/index.jsp";
	}
}
