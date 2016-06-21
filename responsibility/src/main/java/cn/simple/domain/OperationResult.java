package cn.simple.domain;

/**
 * 返回操作结果
 * 
 * @author ldm
 * @Date 2016年6月21日
 */
public class OperationResult {
	private String operation;
	private String field;
	private String message;
	private boolean success;

	public OperationResult() {
		// TODO Auto-generated constructor stub
	}

	public OperationResult(String opr, String field, String msg, boolean success) {
		this.operation = opr;
		this.field = field;
		this.message = msg;
		this.success = success;

	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
