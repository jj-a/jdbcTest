package kr.co.jdbctest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BbsDAO implements IDao {
	
	// POJO 방식 DB 연결
	
	// Spring Bean 객체 주입
	// setter 함수 필요
	JdbcTemplate jt;	// jdbc.xml > jdbcTemplate property
	

	@Override
	public List<BbsDTO> list() {
		
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT * FROM board2 ");
		sql.append("ORDER BY idx DESC ");
		
		// RowMapper = PreparedStatement + ResultSet
		RowMapper<BbsDTO> rowMapper=new RowMapper<BbsDTO>() {

			@Override
			public BbsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BbsDTO dto=new BbsDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPwd(rs.getString("pwd"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getInt("hit"));
				
				return dto;
			}
		}; // rowMapper end

		
		List<BbsDTO> list=jt.query(sql.toString(), rowMapper);
		
		return list;
		
	} // list() end

	
	@Override
	public List<BbsDTO> paging(int start, int end) {
		
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT * FROM board2 ");
		sql.append("WHERE idx>="+start+" AND idx<="+end+" ");
		sql.append("ORDER BY idx DESC ");
		
		// RowMapper = PreparedStatement + ResultSet
		RowMapper<BbsDTO> rowMapper=new RowMapper<BbsDTO>() {

			@Override
			public BbsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BbsDTO dto=new BbsDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPwd(rs.getString("pwd"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getInt("hit"));
				
				return dto;
			}
		}; // rowMapper end

		
		List<BbsDTO> list=jt.query(sql.toString(), rowMapper);
		
		return list;
	} // paging() end

	
	@Override
	public BbsDTO read(int num) {

		StringBuilder sql=new StringBuilder();
		sql.append("SELECT * FROM board2 ");
		sql.append("WHERE idx="+num+" ");
		
		BbsDTO dto=null;
		
		// RowMapper = PreparedStatement + ResultSet
		RowMapper<BbsDTO> rowMapper=new RowMapper<BbsDTO>() {

			@Override
			public BbsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

				BbsDTO dto=new BbsDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPwd(rs.getString("pwd"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getInt("hit"));
				
				return dto;
			}
		}; // rowMapper end

		dto=jt.queryForObject(sql.toString(), rowMapper);
		
		return dto;
	} // read() end

	
	@Override
	public int rowCount() {
		int cnt=0;
		
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT COUNT(*) FROM board2");
		cnt=jt.queryForObject(sql.toString(), Integer.class);
		
		return cnt;
	} // rowCount() end

	
	@Override
	public int insert(BbsDTO dto) {
		
		StringBuilder sql=new StringBuilder();
		sql.append("INSERT INTO board2(idx, name, email, homepage, title, content, pwd, wdate, hit) ");
		sql.append("VALUES(board2_idx_seq.nextval, ");
		sql.append("'"+dto.getName()+"', ");
		sql.append("'"+dto.getEmail()+"', ");
		sql.append("'"+dto.getHomepage()+"', ");
		sql.append("'"+dto.getTitle()+"', ");
		sql.append("'"+dto.getContent()+"', ");
		sql.append("'"+dto.getPwd()+"', ");
		sql.append("sysdate, ");
		sql.append(dto.getHit()+") ");
		
		int res=jt.update(sql.toString());
		
		return res;
	} // insert() end

	
	@Override
	public int update(BbsDTO dto) {
		
		StringBuilder sql=new StringBuilder();
		sql.append("UPDATE board2 SET name='"+dto.getName()+"' ");
		sql.append("WHERE idx="+dto.getIdx()+" ");
		
		int res=jt.update(sql.toString());
		
		return res;
	} // update() end

	
	@Override
	public int delete(int num) {

		StringBuilder sql=new StringBuilder();
		sql.append("DELETE FROM board2 WHERE idx="+num);
		
		int res=jt.update(sql.toString());
		
		return res;
	} // delete() end
	

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	} // setJt() end
	
	
}
