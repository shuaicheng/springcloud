package com.ccx.helloworld.springcloud.config.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.commons.lang.StringUtils;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.apache.coyote.http11.Http11Nio2Protocol;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.net.Nio2Channel;
import org.apache.tomcat.util.net.NioChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomizedTomcatServerFactory {

	@Value("${server.tomcat.protocol}")
	private String protocol;
	
	@Value("${server.tomcat.max-keep-alive-requests}")
	private int maxKeepAliveRequests;
	
	@Value("${server.tomcat.keep-alive-timeout}")
	private int keepAliveTimeout;
	
	private static final String NIO_2_PROTOCOL = "org.apache.coyote.http11.Http11Nio2Protocol";
	private static final String NIO_1_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatServerFactory() {
		return new WebServerFactoryCustomizer<TomcatServletWebServerFactory>() {

			@Override
			public void customize(TomcatServletWebServerFactory factory) {
				if(StringUtils.isNotBlank(protocol)) {
					factory.setProtocol(protocol);
				}else {
					factory.setProtocol(NIO_1_PROTOCOL);
				}
				log.info("#############################Tomcat factory configuration########################################");
				log.info("factory.port:{}", factory.getPort());
				log.info("#############################Tomcat factory configuration########################################");
				factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {

					@Override
					public void customize(Connector connector) {
						log.info("#############################Tomcat connector configuration########################################");
						log.info("connector.port", connector.getPort());
						log.info("connector.socket.soKeepAlive:{}", connector.getAttribute("socket.soKeepAlive"));
						log.info("#############################Tomcat connector configuration########################################");

						log.info("#############################Tomcat connector protocol configuration########################################");
						if(NIO_2_PROTOCOL.equals(protocol)) {
							AbstractHttp11Protocol<Nio2Channel> protocol = null;
							protocol = ((Http11Nio2Protocol) connector.getProtocolHandler());
							protocol.setMaxKeepAliveRequests(maxKeepAliveRequests);
							protocol.setKeepAliveTimeout(keepAliveTimeout);
							log.info("protocol.keepAliveTimeout:{}", protocol.getKeepAliveTimeout());
							log.info("protocol.maxKeepAliveRequests:{}", protocol.getMaxKeepAliveRequests());
							
							log.info("protocol.getAcceptCount():{}",protocol.getAcceptCount());
							log.info("protocol.getMaxThreads():{}",protocol.getMaxThreads());
							log.info("protocol.getMaxConnections():{}",protocol.getMaxConnections());
							log.info("protocol.getConnectionTimeout():{}",protocol.getConnectionTimeout());
							log.info("protocol.getKeepAliveTimeout():{}",protocol.getKeepAliveTimeout());
						}else {
							AbstractHttp11Protocol<NioChannel> protocol = null;
							protocol = ((Http11NioProtocol) connector.getProtocolHandler());
							protocol.setMaxKeepAliveRequests(maxKeepAliveRequests);
							protocol.setKeepAliveTimeout(keepAliveTimeout);
							log.info("protocol.keepAliveTimeout:{}", protocol.getKeepAliveTimeout());
							log.info("protocol.maxKeepAliveRequests:{}", protocol.getMaxKeepAliveRequests());
							
							log.info("protocol.getAcceptCount():{}",protocol.getAcceptCount());
							log.info("protocol.getMaxThreads():{}",protocol.getMaxThreads());
							log.info("protocol.getMaxConnections():{}",protocol.getMaxConnections());
							log.info("protocol.getConnectionTimeout():{}",protocol.getConnectionTimeout());
						}
						log.info("#############################Tomcat connector protocol configuration########################################");
					}

				});
				
			}

		};
	}
}
