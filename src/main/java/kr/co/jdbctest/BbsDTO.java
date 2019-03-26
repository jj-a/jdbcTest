package kr.co.jdbctest;

public class BbsDTO {
	
	private int idx;
	private String name, email, homepage, title, content, pwd, wdate;
	private int hit;
	
	
	// Constructor
	
	public BbsDTO(String name, String email, String homepage, String title, String content, String pwd, int hit) {
		this.name = name;
		this.email = email;
		this.homepage = homepage;
		this.title = title;
		this.content = content;
		this.pwd = pwd;
		this.hit = hit;
	}
	
	public BbsDTO() {
		;
	}
	
	
	// Getter & Setter

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHomepage() {
		return homepage;
	}
	
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getWdate() {
		return wdate;
	}
	
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	public int getHit() {
		return hit;
	}
	
	public void setHit(int hit) {
		this.hit = hit;
	}
	

}
