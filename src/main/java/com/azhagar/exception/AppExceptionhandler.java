package com.azhagar.exception;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionhandler {

	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<ExceptionInfo> handleCNFE(CompanyNotFoundException cf) {

		ExceptionInfo info = new ExceptionInfo();
		info.setExcpId("");
		info.setExcpMsg(cf.getMessage());
		return new ResponseEntity<ExceptionInfo>(info, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionInfo> handleNPE(NullPointerException np) {
		ExceptionInfo info = new ExceptionInfo();
		info.setExcpId("");
		info.setExcpMsg(np.getMessage());

		return new ResponseEntity<ExceptionInfo>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ExceptionInfo> handleSQE(SQLException sq) {
		ExceptionInfo info = new ExceptionInfo();
		info.setExcpId("");
		info.setExcpMsg(sq.getMessage());

		return new ResponseEntity<ExceptionInfo>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
