package unidue.ub.monitor;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import unidue.ub.settings.fachref.FachrefProcess;

@Configuration
public class ApplicationConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.getCorsRegistry()
                .addMapping("/**")
                .allowedOrigins("http://localhost:3000").allowedMethods("GET", "PUT", "DELETE", "POST");
        config.exposeIdsFor(FachrefProcess.class);
    }
}
