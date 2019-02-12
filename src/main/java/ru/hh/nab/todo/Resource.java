package ru.hh.nab.todo;

import org.springframework.web.bind.annotation.RequestBody;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Path("/")
public class Resource {

  private List<Todo> todosGlobal = new ArrayList<>();

  private Integer findPosition(Integer id) {
    int i = 0;
    while (!todosGlobal.get(i).getId().equals(id)) {
      i += 1;
    }
    return i;
  }

  @GET
  @Path("/")
  @Produces({MediaType.TEXT_HTML})
  public InputStream viewHome() throws FileNotFoundException {
    File index = new File("./src/main/java/ru/hh/nab/todo/view/index.html");
    return new FileInputStream(index);
  }

  @GET
  @Path("/todos")
  @Produces("application/json")
  public List<Todo> getAll() {
    return todosGlobal;
  }

  @PUT
  @Path("/todos")
  @Produces("application/json")
  public Todo update(@RequestBody Todo todo) {
    int id = todo.getId();
    int position = findPosition(id);
    todosGlobal.set(position, todo);
    return todo;
  }

  @POST
  @Path("/todos")
  @Produces("application/json")
  public Todo create(@RequestBody String title) {
    int id = 1;
    if (todosGlobal.size() != 0) {
      id = todosGlobal.get(todosGlobal.size() - 1).getId() + 1;
    }
    Todo todo = new Todo(id, title, false);
    todosGlobal.add(todo);
    return todo;
  }

  @DELETE
  @Path("/todos/{id}")
  @Produces("application/json")
  public Integer delete(@PathParam("id") Integer id) {
    int position = findPosition(id);
    todosGlobal.remove(position);
    return id;
  }

  @DELETE
  @Path("/todos/all")
  public void deleteMarked() {
    todosGlobal.removeIf(Todo::getDone);
  }

  @POST
  @Path("/todos/{done}")
  public void markAll(@PathParam("done") Boolean done) {
    for (Todo todo : todosGlobal) {
      todo.setDone(done);
    }
  }
}
