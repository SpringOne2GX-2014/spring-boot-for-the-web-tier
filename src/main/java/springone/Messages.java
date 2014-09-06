package springone;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class Messages {

	private MessageSource source;

	private Locale locale;

	public Messages(MessageSource source, Locale locale) {
		this.source = source;
		this.locale = locale;
	}

	public String get(String code, Object... args) {
		return source.getMessage(code, args, locale);
	}

}
