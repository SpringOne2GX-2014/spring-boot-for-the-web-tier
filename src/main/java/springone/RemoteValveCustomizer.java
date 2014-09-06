package springone;

import org.apache.catalina.Context;
import org.apache.catalina.Valve;
import org.apache.catalina.valves.RemoteIpValve;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

/**
 * Change the RemoteIpValve setInternalProxies so the demo works on an internal network
 */
@Component
public class RemoteValveCustomizer implements EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		((TomcatEmbeddedServletContainerFactory) container)
				.addContextCustomizers(new InternalProxiesCustomizer());
	}

	private static class InternalProxiesCustomizer implements TomcatContextCustomizer {

		@Override
		public void customize(Context context) {
			for (Valve valve : context.getPipeline().getValves()) {
				if (valve instanceof RemoteIpValve) {
					((RemoteIpValve) valve).setInternalProxies(".*");
				}
			}
		}

	}

}
