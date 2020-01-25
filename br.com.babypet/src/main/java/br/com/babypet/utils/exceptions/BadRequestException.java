package br.com.babypet.utils.exceptions;

import java.util.List;

public class BadRequestException extends RuntimeException {
	
	private MessageErrorResponse errorResponse;
	
	
	
	public MessageErrorResponse getErrorResponse() {
		return this.errorResponse;
	}

	public void setErrorResponse(MessageErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public BadRequestException() {
		super ("Bad Request!!!");
	}

	public BadRequestException(String message) {
		super(message);
	}
	
	public BadRequestException(List<MessageErrorDetail> errors) {
		
		this.errorResponse = new MessageErrorResponse("Erros ao Salvar", errors);
		
	}
}
