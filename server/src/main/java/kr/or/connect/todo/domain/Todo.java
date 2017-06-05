package kr.or.connect.todo.domain;

import java.sql.Timestamp;

public class Todo {
	 private Integer id;
	    private String todo;
	    private Integer completed = 0;
	    private Timestamp date;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getTodo() {
	        return todo;
	    }

	    public void setTodo(String todo) {
	        this.todo = todo;
	    }

	    public Integer getCompleted() {
	        return completed;
	    }

	    public void setCompleted(Integer completed) {
	        this.completed = completed;
	    }

	    public Timestamp getDate() {
	        return date;
	    }

	    public void setDate(Timestamp date) {
	        this.date = date;
	    }
	    
	    // 속성값 확인용
	    @Override
	    public String toString() {
	        return "Todo{" +
	                "id=" + id +
	                ", todo='" + todo + '\'' +
	                ", completed=" + completed +
	                ", date=" + date +
	                '}';
	    }
	    
	    // 기본생성자
	    public Todo(){}
	 
	    public Todo(String todo, Integer completed, Timestamp date) {
	        this.todo = todo;
	        this.completed = completed;
	        this.date = date;
	    }
	    
	    public Todo(String todo, Timestamp date){
	    	this.todo = todo;
	    	this.date = date;
	    }

}
