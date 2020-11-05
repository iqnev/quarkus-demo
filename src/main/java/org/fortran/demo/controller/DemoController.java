/**
 * 
 */
package org.fortran.demo.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.fortran.demo.model.Task;
import org.fortran.demo.service.TaskService;

/**
 * @author Ivelin Yanev
 *
 * @since 11.05.2020
 */
@Path("/demo/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DemoController {

	private final TaskService taskService;

	public DemoController(TaskService taskService) {
		this.taskService = taskService;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newTask(@Valid Task task) {
	
		try {
			if (task == null) {
				return Response.status(Status.BAD_REQUEST).entity("Task not provided").build();
			}

			return Response.ok(taskService.addTask(task)).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@GET
	public Response allTasks() {
		return Response.ok(taskService.allTasks()).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") String id) {
		return Response.ok(taskService.delete(id)).build();
	}
}
