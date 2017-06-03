package kr.or.connect.todo.domain;

public class Todo {
	// 추후 Todo에 알맞게 변경해야한다
	private Integer id;
	private String author;
	private String title;
	private Integer pages;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	public Todo(){}	// 디폴트 생성자
	// 추후 todo테이블에 맞춰서 변경
	public Todo(String title, String author, Integer pages) {
		this.title = title;
		this.author = author;
		this.pages = pages;
	}
	
	// 속성값 확인용
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", pages=" + pages + "]";
	}
}
