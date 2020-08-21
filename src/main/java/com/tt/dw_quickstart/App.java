package com.tt.dw_quickstart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<BasicConfiguration>
{
    public static void main( String[] args ) throws Exception
    {  	
        new App().run("server", "introduction-config.yml");
    }

	@Override
	public void run(BasicConfiguration basicConfiguration, Environment environment) throws Exception {
	    int defaultSize = basicConfiguration.getDefaultSize();
	    
	    BrandRepository brandRepository = new BrandRepository(initBrands());
	    BrandResource brandResource = new BrandResource(defaultSize, brandRepository);
	 
	    environment
	      .jersey()
	      .register(brandResource);	
	    
	    environment
	    .healthChecks()
	    .register("application", new ApplicationHealthCheck());

		
	}
    
    @Override
    public void initialize(Bootstrap<BasicConfiguration> bootstrap) {
    	bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
    	super.initialize(bootstrap);
    }
    
    private List<Brand> initBrands() {
    	List<Brand> bList = new ArrayList<>();
    	Brand b = new Brand((long) 1, "numberOne");
    	bList.add(b);
    	
		return bList;
    }
}
