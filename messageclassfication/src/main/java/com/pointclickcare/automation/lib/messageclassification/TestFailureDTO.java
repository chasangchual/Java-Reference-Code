package com.pointclickcare.automation.lib.messageclassification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestFailureDTO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	 
	private final String sql = "SELECT failure_id, exception_class, error_msg_pattern, last_class, last_called_method, last_line_number FROM test_failure ORDER BY error_msg_pattern " ;
	public List<TestFailure> loadFailures()	{
		List<TestFailure> failures = new ArrayList<TestFailure>() ; 
		
		List<Map<String, Object>> rs = jdbcTemplate.queryForList(sql) ;
		if(rs != null && rs.size() > 0) {
			for (Map<String, Object> row : rs) {
				TestFailure failure = new TestFailure() ; 
				
				failure.setFailureId((Integer)row.get("failure_id")) ;
				failure.setException((String)row.get("exception_class")) ;
				failure.setErrorMsgPattern((String)row.get("error_msg_pattern")) ;
				failure.setLastClass((String)row.get("last_class")) ;
				failure.setLastMethod((String)row.get("last_called_method")) ;
				failure.setLastLine((Integer)row.get("last_line_number")) ;
				
				failures.add(failure) ;
			}
		}
		
		return failures ;
	}
}
