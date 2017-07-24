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
	 * �������ļ�������SimpleMappingExceptionResolver��ӳ���쳣
	 * @param i
	 * @return
	 */
	@RequestMapping("/testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver(@RequestParam("i")int i){
		String [] vals=new String[10];
		System.out.println(vals[i]);//����10�����±�Խ���쳣
		return "success";
	}
	/**
	 * ����������ֵ��쳣���ǽ���DefaultHandlerExceptionResolver�����
	 * @return
	 */
	@RequestMapping(value="/testDefaultHandlerExceptionResolver",method=RequestMethod.POST)
	public String testDefaultHandlerExceptionResolver(){
		System.out.println("testDefaultHandlerExceptionResolver");
		return "success";
	}
	
	/**
	 * @ResponseStatus ��ע���쳣���Ͽ��Զ����쳣��Ϣ��״̬����ע��������ֻҪ����ִ�оͻ��״�
	 * @param i
	 * @return
	 */
	@ResponseStatus(reason="ֻҪ��Ŀ�귽���ϱ�ע�ͻ��״�",value=HttpStatus.CONTINUE)
	@RequestMapping("/testResponseStatusExceptionResolver")
	public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
		if(i==13){
			throw new MyNumberException();
		}
		return "success";
	}
	
	
	/**
	 * 1.��@ExceptionHandler����������п��Լ���Exception���͵Ĳ������ò�������Ӧ�������쳣����
	 * 2.@ExceptionHandler�����ĵ�����в��ܴ���Map����ϣ�����쳣��Ϣ������ҳ���ϣ���Ҫʹ��ModelAndView��Ϊ����ֵ��
	 * 3.@ExceptionHandler������ǵ��쳣�����ȼ������⡣���ӽ����쳣����
	 * 4.@ControllerAdvice������ڵ�ǰHandler���Ҳ���@ExceptionHandler����������ǰ�������ֵ��쳣��
	 * ��ȥ@ControllerAdvice��ǵ����в���@ExceptionHandler��ǵķ����������쳣��
	 * @param ex
	 * @return
	 */
//	@ExceptionHandler({ArithmeticException.class})
//	public ModelAndView handleArithmeticException(Exception ex){
//		System.out.println("���쳣��HandleException��"+ex);
//		ModelAndView mv=new ModelAndView("error");
//		mv.addObject("exception",ex);
//		return mv;
//	}
//	@ExceptionHandler({RuntimeException.class})
//	public ModelAndView handleArithmeticException2(Exception ex){
//		System.out.println("���쳣��RuntimeException��"+ex);
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
	 * ResponseEntity<T>��ʹ�ã�
	 * HttpEntity<T>��������
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
	 * MultipartResolver������ʹ��ʧЧ	
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
	 * ʹ��json
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson(){
		return employeeDao.getAll();
	}
	
	//���ݰ󶨸�ʽ��ʱ����
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
	 * ע�⣺��ҪУ���Bean�������󶨽�������������ʱ�ɶԳ��ֵģ�����֮�䲻�����������������
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
			System.out.println("save������"+result.getErrorCount());
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField()+":"+error.getDefaultMessage());
			}
			//����֤������ת���Ƶ�ҳ��
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
