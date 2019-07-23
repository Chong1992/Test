package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class HelloController {
	@Autowired
	Application app;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(value="/{inputString}", method = RequestMethod.GET)
    public String acceptInput(@PathVariable("inputString") String input) {
    
    if(app.validate(input)){
    	return Integer.toString(input.hashCode());
    }
    else
	return "WRONG FORMAT";
    
	
    
    }
 
    
}
