package com.rt.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;


/**
 * Handles requests for the application home page.
 */
@CrossOrigin
@RestController
public class HomeController {
	
	
static MessageResponse response = null;
	
	static Map context = new HashMap();
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
/*	
	*//**
	 * Simply selects the home view to render by returning its name.
	 *//*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
*/	
	

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
	

	@RequestMapping(value = "/dashbord", method = RequestMethod.POST)
     public UserResp Login(@RequestBody User  usr) {
		
		UserResp resp=new UserResp();
		System.out.println(usr.getInput());

		response = Conversion.conversationAPI(usr.getInput(),context); 
	//	System.out.println("Watson Response:"+ response.getText().get(0));
		context = response.getContext();
		resp.setRespid(1);
		resp.setMsg(response.getText().get(0));
		
      return resp;
    }
	
}
