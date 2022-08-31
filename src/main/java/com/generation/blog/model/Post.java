package com.generation.blog.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "tb_postagens")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "The field should contain a title")
	@Size(min = 5, max = 100, message = "The field should countain between 10 and 1000 characters.")
	private String title;

	@NotBlank(message = "The field should contain a text")
	@Size(min = 10, max = 1000, message = "The field shouldcountain between 10 and 1000 characters.")
	public String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	@UpdateTimestamp
	private LocalDateTime data;
}
