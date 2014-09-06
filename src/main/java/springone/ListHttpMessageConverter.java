package springone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

@Component
public class ListHttpMessageConverter extends AbstractHttpMessageConverter<List<String>> {

	private static final String BEFORE = "<!DOCTYPE html><html lang=\"en\"><head>"
			+ "<title>SpringOne 2014</title>"
			+ "<script src=\"/webjars/jquery/2.1.1/jquery.js\"></script>"
			+ "<script src=\"/js/jquery.lettering.js\"></script>"
			+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/page.css\"/></head>"
			+ "<body><div class=\"container\"><div class=\"os-phrases\">";

	private static final String AFTER = "</div></div><script>$(document).ready(function() {$(\".os-phrases > h2\")."
			+ "lettering('words').children(\"span\").lettering().children(\"span\")."
			+ "lettering();})</script></body></html>";

	@Override
	protected boolean supports(Class<?> clazz) {
		return List.class.isAssignableFrom(clazz);
	}

	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return Arrays.asList(MediaType.TEXT_HTML);
	}

	@Override
	protected List<String> readInternal(Class<? extends List<String>> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		return null;
	}

	@Override
	protected void writeInternal(List<String> t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		PrintWriter out = new PrintWriter(outputMessage.getBody());
		out.write(BEFORE);
		for (String string : t) {
			out.write("<h2>" + string + "</h2>");
		}
		out.write(AFTER);
		out.flush();
	}

}
