package com.springlesson.entites;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "home")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Home {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "location")
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Room> room = new ArrayList<>();
}
