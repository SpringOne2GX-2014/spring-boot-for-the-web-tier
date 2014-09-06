package springone;

import java.util.Arrays;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExampleWebController {

	@Autowired
	private MessageSource source;

	@RequestMapping("/hello/{name}")
	public ModelAndView hello(@PathVariable String name, Locale locale) {
		return new ModelAndView("hello")
				.addObject("name", name)
				.addObject("items", Arrays.asList("Using Groovy", "And Groovy Templates", "Really Rocks!"))
				.addObject("messages", new Messages(source, locale));
	}

	@RequestMapping("/whoami")
	@ResponseBody
	public String ip(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getRemoteAddr()
				+ ":" + request.getServerPort() + "\n";
	}
}
