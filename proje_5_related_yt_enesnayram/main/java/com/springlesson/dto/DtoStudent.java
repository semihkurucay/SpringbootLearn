package com.springlesson.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {
	private Long id;
	private String firstName;
	private String lastName;
	private Date birthOfDate;
	List<DtoCourse> dtoCourses = new ArrayList<>();
}
