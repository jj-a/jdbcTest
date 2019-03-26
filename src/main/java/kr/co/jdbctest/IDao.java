package kr.co.jdbctest;

import java.util.List;

public interface IDao {
	
	public List<BbsDTO> list();
	public List<BbsDTO> paging(int start, int end);
	public BbsDTO read(int num);
	public int rowCount();
	
	public int insert(BbsDTO dto);
	public int update(BbsDTO dto);
	public int delete(int num);

}
