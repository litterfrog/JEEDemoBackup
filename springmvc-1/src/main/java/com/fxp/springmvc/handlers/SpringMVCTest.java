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
	 * 1.@RequestMapping�������η�����������������
	 * 
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		System.out.println("testRequestMapping");
		return SUCCESS;
	}
	/**
	 * ʹ��method������ָ������ʽ
	 * @return
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("testMethod");
		return SUCCESS;
	}
	/**
	 * ʹ��params��headers��������ȷָ������ʽ
	 * @return
	 */
	@RequestMapping(value="testParamsAndHeaders",params={"username","age!=2"},headers={"Accept-Language=en,zh-CN;q=0.8,zh;q=0.6"})
	public String testParamsAndHeaders(){
		System.out.println("testParamsAndHeaders");
		return SUCCESS;
	}
	/**
	 * ֧��antͨ���
	 * ?:һ���ַ���*:����ַ���**:���·��
	 * 
	 * @return
	 */
	@RequestMapping(value="/testAntPath/*/ant")
	public String testAntPath(){
		System.out.println("testAntPath");
		return SUCCESS;
	}
	/**
	 * @PathVariable ����ӳ��URL�е�ռλ����Ŀ�귽���Ĳ�����
	 * @return
	 */
	@RequestMapping(value="/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id){
		System.out.println("testPathVariable id:"+id);
		return SUCCESS;
	}
	
	/**
	 * Rest ���URL
	 * ��CRUDΪ����
	 * ������/order POST
	 * �޸ģ�/order/1 PUT
	 * ��ȡ��/order/1 GET
	 * ɾ����/order/1 DELETE
	 * 
	 * ��η���DELETE��PUT
	 * 1.��Ҫ����HiddenHttpMethodFilter
	 * 2.��Ҫ����POST����
	 * 3.��Ҫ�ڷ���POST����ʱЯ��һ��name="_method"��������ֵΪDELETE��PUT
	 * 
	 * ��SpringMVC��Ŀ�귽������εõ�id��
	 * ʹ��@PathVariableע��
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
	 * @RequestParam ��ӳ���������
	 * valueֵ����������Ĳ�����
	 * required�ò����Ƿ���룬Ĭ��Ϊtrue
	 * defaultValue���������Ĭ��ֵ
	 * @return
	 */
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam(value="username")String username,
			@RequestParam(value="age",required=false,defaultValue="0")int age){
		System.out.println("testRequestParam username:"+username+" age:"+age);
		return SUCCESS;
	}
	/**
	 * �÷�ͬ�ϣ�ӳ������ͷ
	 * @param al
	 * @return
	 */
	@RequestMapping(value="/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language")String al){
		System.out.println("testRequestHeader al:"+al);
		return SUCCESS;
	}
	/**
	 * �˽⣺
	 * @CookieValue �÷�ͬ��
	 * @param sessionId
	 * @return
	 */
	@RequestMapping(value="/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
		System.out.println("testCookieValue sessionId:"+sessionId);
		return SUCCESS;
	}
	/**
	 * Spring MVC�ᰴ�������������POJO�����������Զ�ƥ�䡣
	 * �Զ�Ϊ�ö����������ֵ��֧�ּ�������
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
	 * ԭ��api���������������ͼ�AnnotationMethodHandlerAdapter.resolveStandardArgument()
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
	 * Ŀ�귽���ķ���ֵ������ModelAndView����
	 * ���а�����ͼ��ģ����Ϣ
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
	 * Ŀ�귽��������ӣ�Map,Model,ModelMap�����͵Ĳ�����request�������map���ô������
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
	 * @SessionAttributes ���˿���ͨ��������ָ����Ҫ�ŵ��Ự�е������⣨ʵ����ʹ�õ���value����ֵ��
	 * ������ͨ��ģ�����ԵĶ�������ָ����Щģ��������Ҫ�ŵ��Ự�У�ʵ����ʹ�õ���types����ֵ��
	 * ע�⣺��ע��ֻ��������
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
	 * �������̣�
	 * 1.ִ��@ModelAttributeע�����εķ����������ݿ���ȡ�����󣬰Ѷ�����뵽��Map�У���Ϊ��user
	 * 2.SpringMVC��Map��ȡ��User���󣬲��ѱ����������������User����Ķ�Ӧ���ԡ�
	 * 3.SpringMVC������������Ŀ�귽���Ĳ�����
	 * 
	 * ע�⣺��@ModelAttributeע�����εķ����з��뵽Map�ǵļ���Ҫ��Ŀ�귽��������͵ĵ�һ����ĸСд���ַ���һ�¡�
	 * 
	 * SpringMVCȷ��Ŀ�귽��POJO������εĹ���
	 * 1.ȷ��key
	 * 1)��Ŀ�귽����POJO���͵Ĳ���û��ʹ��@ModelAttribute��Ϊ���Σ���keyΪPOJO������һ����ĸСд
	 * 2)��ʹ����@ModelAttribute�����Σ���keyΪ@ModelAttributeע���value����ֵ��
	 * 2.��implicitModel�в���key��Ӧ�Ķ��������ڣ�����Ϊ��δ��롣
	 * 1)����@ModelAttribute��ǵķ�������Map�б��������key��1ȷ����keyһ�£�����ȡ����
	 * 3.��implicitModel�в�����key��Ӧ�Ķ������鵱ǰ��Handler�Ƿ�ʹ��@SessionAttributesע�����Σ�
	 * ��ʹ���˸�ע�⣬��@SessionAttributesע���value����ֵ�а�����key������HttpSession�л�ȡ
	 * ��Ӧ��valueֵ����������ֱ�Ӵ��뵽Ŀ�귽��������У��������������쳣��
	 * 4.��Handlerû�б�ע@SessionAttributesע���SessionAttributesע���valueֵ�в�����key����
	 * ��ͨ������������POJO���͵Ĳ���������ΪĿ�귽���Ĳ���
	 * 5.SpringMVC���key��value���浽implicitModel�У������ᱣ�浽request�С�
	 * 
	 * Դ����������̣�
	 * 1.����@ModelAttributeע�����εķ�����ʵ���ϰ�@ModelAttribute������Map�е����ݷ�����implicitModel�С�
	 * 2.��������������Ŀ�������ʵ���ϸ�Ŀ�����������WebDataBinder�����target����
	 * 1)����WebDataBinder����
	 * 	1>ȷ��objectName���ԣ��������attrName����ֵΪ"",��objectNameΪ������һ����ĸСд��
	 * 	*ע�⣺attrName����Ŀ�귽����POJO����ʹ����@Modelattribute�����Σ���attrNameֵ��Ϊ@ModelAttribute��value����ֵ��
	 * 	2>ȷ��target���ԣ�
	 * 	~��implicitModel�в���attrName��Ӧ������ֵ�������ڣ�ok
	 * 	~*�������ڣ�����֤��ǰHandler�Ƿ�ʹ����@SessionAttributes�������Σ���ʹ���ˣ����Դ�Session�л�ȡattrName����Ӧ������ֵ��
	 * 	~��session��û�ж�Ӧ������ֵ�����׳��쳣��
	 * 	~��Handlerû��ʹ��@SessionAttributes�������Σ���@SessionAttributes��û��ʹ��valueֵָ����key��attrName��ƥ�䣬��ͨ�����䴴����POJO����
	 * 2)SpringMVC�ѱ������������ֵ����WebDataBinder��target��Ӧ�����ԡ�
	 * 3)*SpringMVC���WebDataBinder��attrName��target����implicitModel
	 * 4)��WebDataBinder��target��Ϊ�������ݸ�Ŀ�귽������Ρ�
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/testModelAttribute")
	public String testModelAttribute(User user){
		System.out.println("�޸ģ�"+user);
		return SUCCESS;
	}
	/**
	 * 1.��@ModelAttribute ��ǵķ���������ÿ��Ŀ�귽��ִ��֮ǰ��SpringMVC����
	 * 2.���ע��Ҳ����������Ŀ�귽��POJO���͵���Σ���value����ֵ�����µ����ã�
	 * 1)SpringMVC��ʹ��value����ֵ��implicitModel�в��Ҷ�Ӧ�Ķ�����������ֱ�Ӵ��뵽Ŀ�귽��������С�
	 * 2)SpringMVC����valueΪkey��POJO���͵Ķ���Ϊvalue�����뵽request�С�
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false)Integer id,Map<String,Object> map){
		System.out.println("ModelAttribute");
		if(id!=null){
			//ģ������ݿ��л�ȡ����
			User user=new User(1,"tom","123","tom@111",11);
			System.out.println("�����ݿ��л�ȡ����"+user);
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
