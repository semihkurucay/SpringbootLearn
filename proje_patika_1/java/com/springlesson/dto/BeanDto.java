package com.springlesson.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
public class BeanDto {
	private Long id;
	private String name;
	private String beanData;
	
	public void initialBeanMethod() {
		log.info("Bean başlamadan önce ben geldim");
		System.out.println("Bean başlamadan önce bu metod geldi");
	}
	
	public void destroyBeanMethod() {
		log.info("Bean bittikten sonra ben geldim");
		System.out.println("Bean bittikten sonra bu metod geldi");
	}
}
