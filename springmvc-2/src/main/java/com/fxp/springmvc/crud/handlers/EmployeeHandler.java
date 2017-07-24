package com.fxp.springmvc.crud.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.spi.http.HttpHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fxp.springmvc.crud.dao.DepartmentDao;
import com.fxp.springmvc.crud.dao.EmployeeDao;
import com.fxp.springmvc.crud.entities.Employee;
import com.fxp.springmvc.crud.exceptions.MyNumberException;

@Controller
public class EmployeeHandler {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private ResourceBundleMessageSource messageSource;
	/**
	 * 在配置文件中配置SimpleMappingExceptionResolver来映射异常
	 * @param i
	 * @return
	 */
	@RequestMapping("/testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver(@RequestParam("i")int i){
		String [] vals=new String[10];
		System.out.println(vals[i]);//超过10产生下标越界异常
		return "success";
	}
	/**
	 * 这个方法出现的异常就是交给DefaultHandlerExceptionResolver处理的
	 * @return
	 */
	@RequestMapping(value="/testDefaultHandlerExceptionResolver",method=RequestMethod.POST)
	public String testDefaultHandlerExceptionResolver(){
		System.out.println("testDefaultHandlerExceptionResolver");
		return "success";
	}
	
	/**
	 * @ResponseStatus 标注到异常类上可以定制异常信息和状态，标注到方法上只要方法执行就会抛错。
	 * @param i
	 * @return
	 */
	@ResponseStatus(reason="只要在目标方法上标注就会抛错",value=HttpStatus.CONTINUE)
	@RequestMapping("/testResponseStatusExceptionResolver")
	public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
		if(i==13){
			throw new MyNumberException();
		}
		return "success";
	}
	
	
	/**
	 * 1.在@ExceptionHandler方法的入参中可以加入Exception类型的参数，该参数即对应发生的异常对象
	 * 2.@ExceptionHandler方法的的入参中不能传入Map，若希望把异常信息传导到页面上，需要使用ModelAndView作为返回值。
	 * 3.@ExceptionHandler方法标记的异常有优先级的问题。更接近的异常优先
	 * 4.@ControllerAdvice：如果在当前Handler中找不到@ExceptionHandler方法来处理当前方法出现的异常，
	 * 则将去@ControllerAdvice标记的类中查找@ExceptionHandler标记的方法来处理异常。
	 * @param ex
	 * @return
	 */
//	@ExceptionHandler({ArithmeticException.class})
//	public ModelAndView handleArithmeticException(Exception ex){
//		System.out.println("出异常了HandleException："+ex);
//		ModelAndView mv=new ModelAndView("error");
//		mv.addObject("exception",ex);
//		return mv;
//	}
//	@ExceptionHandler({RuntimeException.class})
//	public ModelAndView handleArithmeticException2(Exception ex){
//		System.out.println("出异常了RuntimeException："+ex);
//		ModelAndView mv=new ModelAndView("error");
//		mv.addObject("exception",ex);
//		return mv;
//	}
	
	@RequestMapping("/testExceptionHandlerExceptionResolver")
	public String testExceptionHandlerExceptionResolver(@RequestParam("i")int i){
		System.out.println("result:"+10/i);
		return "success";
	}
	
	@RequestMapping("/testFileUpload")
	public String fileUpload(@RequestParam("desc") String desc,
			@RequestParam("file") MultipartFile file) throws IOException{
		System.out.println("desc:"+desc);
		System.out.println("OriginalFilename:"+file.getOriginalFilename());
		System.out.println("getInputStream"+file.getInputStream());
		return "success";
	}
	
	
	@RequestMapping("/i18n")
	public String i18n(Locale locale){
		String val=messageSource.getMessage("i18n.username", null, locale);
		System.out.println(val);
		return "i18n";
	}
	
	
	/**
	 * ResponseEntity<T>的使用，
	 * HttpEntity<T>与其类似
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
		byte[] body=null;
		ServletContext servletContext=session.getServletContext();
		InputStream in=servletContext.getResourceAsStream("/files/sql.txt");
		body=new byte[in.available()];
		in.read(body);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=sql.txt");
		HttpStatus statusCode=HttpStatus.OK;
		ResponseEntity<byte[]> response=new ResponseEntity<>(body,headers,statusCode);
		return response;
	}
	
	/**
	 * MultipartResolver的配置使其失效	
	 * @param body
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/testHttpMessageConverter")
	public String testHttpMessageConverter(@RequestBody String body){
		System.out.println(body);
		return "helloworld "+new Date();
	}
	
	/**
	 * 使用json
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson(){
		return employeeDao.getAll();
	}
	
	//数据绑定格式化时调用
	@InitBinder
	public void initBinder(WebDataBinder binder){
		System.out.println("initBinder");
	}
	
	@RequestMapping("/testConversionServiceConverter")
	public String testConverter(@RequestParam("employee") Employee employee){
		System.out.println("testConverter:"+employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false)Integer id,
			Map<String,Object> map){
		if(id!=null){
			map.put("employee", employeeDao.getEmployeeById(id));
		}
	}
	
	@RequestMapping(value="/empInput",method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/empInput/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id")Integer id,Map<String,Object> map){
		map.put("employee",employeeDao.getEmployeeById(id));
		map.put("departments", departmentDao.getAll());
		return "input";
	}
	
	@RequestMapping(value="/empInput/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	/**
	 * 注意：需要校验的Bean对象和其绑定结果对象或错误对象时成对出现的，它们之间不允许声明其他的入参
	 * @param employee
	 * @param result
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/empInput",method=RequestMethod.POST)
	public String save(@Valid Employee employee,BindingResult result,
			Map<String,Object> map){
		System.out.println("save"+employee);
		if(result.getErrorCount()>0){
			System.out.println("save出错了"+result.getErrorCount());
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField()+":"+error.getDefaultMessage());
			}
			//若验证出错，则转向定制的页面
			map.put("departments", departmentDao.getAll());
			return "input";
		}
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/empInput",method=RequestMethod.GET)
	public String input(Map<String,Object> map){
		map.put("departments", departmentDao.getAll());
		map.put("employee", new Employee());
		return "input";
	}
	
	
	
	@RequestMapping("/emps")
	public String list(Map<String,Object> map){
		map.put("employees",employeeDao.getAll());
		return "list";
	}
}
