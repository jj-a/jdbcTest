package kr.co.jdbctest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JdbcMainTest {

	public static void main(String[] args) {
		
		String jdbc="src/main/java/kr/co/jdbctest/jdbc.xml";
		ApplicationContext context=new FileSystemXmlApplicationContext(jdbc);
		
		IDao dao=(IDao)context.getBean("bbsDAO");
		
		BbsDTO dto=null;
		List<BbsDTO> list=null;
		
		
		// 조회
		System.out.println();
		System.out.println("**목록 조회**");
		System.out.println("번호 · 이름 · 이메일 · 홈페이지 · 제목 · 내용 · 비밀번호 · 등록일 · 조회수");
		
		list=dao.list();
		
		for(int idx=0;idx<list.size();idx++) {
			dto=list.get(idx);
			System.out.print(dto.getIdx()+" · ");
			System.out.print(dto.getName()+" · ");
			System.out.print(dto.getEmail()+" · ");
			System.out.print(dto.getHomepage()+" · ");
			System.out.print(dto.getTitle()+" · ");
			System.out.print(dto.getContent()+" · ");
			System.out.print(dto.getPwd()+" · ");
			System.out.print(dto.getWdate()+" · ");
			System.out.println(dto.getHit());
		}
		
		System.out.println("전체 레코드 개수: "+dao.rowCount());

		System.out.println();
		
		// 추가
		int result=dao.insert(new BbsDTO("어피치", "apeach@kakao.com", "kakaofriend.co.kr", "카카오프렌즈", "어피치", "1234", 0));
		if(result==0) System.out.println("* 행 추가 실패\n");
	 	else System.out.println("* 행 추가 성공\n");
		
		
		// 수정
		dto=new BbsDTO();
		dto.setIdx(4);
		dto.setName("콘(CON)");
		result=dao.update(dto);
		if(result==0) System.out.println("* 행 수정 실패\n");
	 	else System.out.println("* 행 수정 성공\n");
		
		
		// 삭제
		int num=20;
		result=dao.delete(num);
		if(result==0) System.out.println("* 행 삭제 실패\n");
	 	else System.out.println("* 행 삭제 성공\n");
		
		
		// 상세보기
		System.out.println("**상세 조회**");
		System.out.println("번호 · 이름 · 이메일 · 홈페이지 · 제목 · 내용 · 비밀번호 · 등록일 · 조회수");

		dto=dao.read(1);

		System.out.print(dto.getIdx()+" · ");
		System.out.print(dto.getName()+" · ");
		System.out.print(dto.getEmail()+" · ");
		System.out.print(dto.getHomepage()+" · ");
		System.out.print(dto.getTitle()+" · ");
		System.out.print(dto.getContent()+" · ");
		System.out.print(dto.getPwd()+" · ");
		System.out.print(dto.getWdate()+" · ");
		System.out.println(dto.getHit()+"\n");
		
		
		// 페이징
		int start=1, end=8;
		System.out.println("**목록 조회(페이징)**");
		System.out.println("번호 · 이름 · 이메일 · 홈페이지 · 제목 · 내용 · 비밀번호 · 등록일 · 조회수");
		
		list=dao.paging(start, end);
		
		for(int idx=0;idx<list.size();idx++) {
			dto=list.get(idx);
			System.out.print(dto.getIdx()+" · ");
			System.out.print(dto.getName()+" · ");
			System.out.print(dto.getEmail()+" · ");
			System.out.print(dto.getHomepage()+" · ");
			System.out.print(dto.getTitle()+" · ");
			System.out.print(dto.getContent()+" · ");
			System.out.print(dto.getPwd()+" · ");
			System.out.print(dto.getWdate()+" · ");
			System.out.println(dto.getHit());
		}
		
		
	}
}
