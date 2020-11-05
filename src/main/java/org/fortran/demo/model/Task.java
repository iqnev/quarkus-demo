/**
 * 
 */
package org.fortran.demo.model;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Ivelin Yanev
 *
 * @since 11.05.2020
 */
public class Task {

	@NotNull
	public String id;
	@NotNull
	@NotBlank(message="Title may not be blank")
	public String name;
	@NotNull
	public Date date;

	public Task() {

	}

	public Task(String task, Date date) {
		this.id = UUID.randomUUID().toString();
		this.name = task;
		this.date = date;
	}
}
