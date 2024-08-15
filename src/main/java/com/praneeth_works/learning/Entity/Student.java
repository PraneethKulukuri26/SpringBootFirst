package com.praneeth_works.learning.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Data
@Table(name="Student_DB")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "mark")
	private int mark;
	
	@Column(name = "name")
	private String name;
}
