package springone;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleRestController {

	@RequestMapping("/convert")
	public List<String> rest() {
		return Arrays.asList("Dave", "Andy", "Stephane", "Christian", "Phil");
	}

}
