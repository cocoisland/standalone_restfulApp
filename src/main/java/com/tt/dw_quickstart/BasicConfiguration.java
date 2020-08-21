package com.tt.dw_quickstart;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class BasicConfiguration extends Configuration {
	@NotNull private final int defaultSize;
	
	@JsonCreator
	public BasicConfiguration(@JsonProperty("defaultSize") int defaultSize) {
		this.defaultSize = defaultSize;
	}
	
	public int getDefaultSize() {
		return defaultSize;
	}
}
