package com.bae.harvester.server.configuration;

import java.io.IOException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedOrigins("*")
      .allowedMethods("*")
      .allowedHeaders("*")
      .allowCredentials(false)
      .maxAge(3600);
  }

//  @Override
//  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    registry.addResourceHandler("/**")
//      .addResourceLocations("classpath:/static/")
//      .setCachePeriod(30);
//  }
//
//  @Override
//  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addRedirectViewController("/", "/index.html");
////    registry.addViewController("/").setViewName("forward:/index.html");
//  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    // By setting this, you instruct Spring to prioritize this handler above the
    // default one (which is order 0), obviously don't do this. But it's good to
    // understand.
    // -- registry.setOrder(-1);

    registry
      // Capture everything (REST controllers get priority over this, see above)
      .addResourceHandler("/**")
      // Add locations where files might be found
      .addResourceLocations("classpath:/static/**")
      // Needed to allow use of `addResolver` below
      .resourceChain(true)
      // This thing is what does all the resolving. This impl. is responsible for
      // resolving ALL files. Meaning nothing gets resolves automatically by pointing
      // out "static" above.
      .addResolver(new PathResourceResolver() {
        @Override
        protected Resource getResource(String resourcePath, Resource location) throws IOException {
          Resource requestedResource = location.createRelative(resourcePath);

          // If we actually hit a file, serve that. This is stuff like .js and .css files.
          if (requestedResource.exists() && requestedResource.isReadable()) {
            return requestedResource;
          }

          // Anything else returns the index.
          return new ClassPathResource("/static/index.html");
        }
      });

  }
}
