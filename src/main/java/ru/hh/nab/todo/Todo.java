package ru.hh.nab.todo;

public class Todo {

    private Integer id;
    private String title;
    private Boolean done;

    private Todo(){}

    public Todo(int id, String title, boolean done){
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
