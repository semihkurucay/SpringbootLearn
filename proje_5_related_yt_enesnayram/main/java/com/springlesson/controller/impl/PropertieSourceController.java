package com.springlesson.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlesson.configration.DataSource;
import com.springlesson.configration.GlobalProperties;
import com.springlesson.configration.Server;

@RestController
@RequestMapping(path = "/rest/api/propertie")
public class PropertieSourceController {
	/*@Autowired
	private GlobalProperties globalProperties = new GlobalProperties();
	
	@GetMapping("/datasource")
	public DataSource getDataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setUrl(globalProperties.getUrl());
		dataSource.setUsername(globalProperties.getUsername());
		dataSource.setPassword(globalProperties.getPassword());

		return dataSource;
	}*/
	
	@Autowired
	private GlobalProperties globalProperties = new GlobalProperties();
	
	@GetMapping(path = "/server")
	public List<Server> getDataSource() {
		return globalProperties.getServers();
	}
}
