package org.zerock.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/security-context.xml"})

public class DBEncrpyterTests {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void test() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement("select uid, upw from tbl_member_secu", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String uid = rs.getString(1);
				String upw = rs.getString(2);
				
				System.out.println(uid + " : " + upw);
				String enStr = encoder.encode(upw);
				rs.updateString(2, enStr);
				rs.updateRow();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {try {rs.close();}catch(Exception e) {}}
			if(rs!=null) {try {pstmt.close();}catch(Exception e) {}}
			if(rs!=null) {try {con.close();}catch(Exception e) {}}
		}
	}
	
}