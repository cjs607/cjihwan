package com.greedy.jsp.member.model.service;

import static com.greedy.jsp.common.jdbc.JDBCTemplate.close;
import static com.greedy.jsp.common.jdbc.JDBCTemplate.commit;
import static com.greedy.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greedy.jsp.member.model.dao.MemberDAO;
import com.greedy.jsp.member.model.dto.MemberDTO;

public class MemberService {
	
	private final MemberDAO memberDAO;
	//필드로 DAO 초기화해두고 사용 밑에서 수정하지 못하게 final로
	
	public MemberService() {
		memberDAO = new MemberDAO();
		//생성자로 초기화
	}

	public int registMember(MemberDTO requestMember) {
		//회원가입 메소드
		Connection con = getConnection();
		
		int result = memberDAO.insertMember(con, requestMember);
		//데이터가 정상적으로 담겨오면 commit 아닐경우 rollback한다.
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	/* 로그인 처리용 메소드 */
	public MemberDTO loginCheck(MemberDTO requestMember) {
		
		Connection con = getConnection();
		MemberDTO loginMember = null;
		
		/* 1. DB에 저장된 회원 아이디와 일치하는 회원의 비밀번호 조회 */
		String encPwd = memberDAO.selectEncryptPwd(con, requestMember);
		
		/* 2. 파라미터로 전달받은 비밀번호와 DB에 저장된 비밀번호가 일치하는지 확인 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			/* 3. 비밀번호가 일치하면 회원 정보 조회 */
			loginMember = memberDAO.selectLoginMember(con, requestMember);
		}
		
		close(con);
		
		return loginMember;
	}
	
	/* 회원 정보 수정용 메소드 */
	public MemberDTO updateMember(MemberDTO changeInfo) {
		
		Connection con = getConnection();
		
		MemberDTO changedMember = null;
		
		/* 1. DB에 저장된 회원 아이디와 일치하는 회원의 비밀번호 조회 */
		String encPwd = memberDAO.selectEncryptPwd(con, changeInfo);
		
		/* 2. 파라미터로 전달받은 비밀번호와 DB에 저장된 비밀번호가 일치하는지 확인 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(changeInfo.getPwd(), encPwd)) {
			
			/* 3. 비밀번호가 일치하면 회원 정보 수정 */
			int result = memberDAO.updateMember(con, changeInfo);
			
			/* 4. update가 성공하면  회원 정보 조회 */
			changedMember = memberDAO.selectLoginMember(con, changeInfo);
			
			/* 5. 모두 정상적으로 동작하면 commit */
			if(result > 0 && changedMember != null) {
				commit(con);
			} else {
				rollback(con);
			}
		}
		
		close(con);
		
		return changedMember;
	}

	public int deleteMember(MemberDTO requestMember) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		/* 1. DB에 저장된 회원 아이디와 일치하는 회원의 비밀번호 조회 */
		String encPwd = memberDAO.selectEncryptPwd(con, requestMember);
		
		/* 2. 파라미터로 전달받은 비밀번호와 DB에 저장된 비밀번호가 일치하는지 확인 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			
			/* 3. 비밀번호가 일치하면 회원 정보 삭제 */
			result = memberDAO.deleteMember(con, requestMember);
		}
		
		/* 4. 트랜젝션 제어 */
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}











