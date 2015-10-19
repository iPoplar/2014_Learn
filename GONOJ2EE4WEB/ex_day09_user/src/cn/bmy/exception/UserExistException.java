package cn.bmy.exception;

public class UserExistException extends Exception {
	/**
	 * 异常是用来封装信息的
	 * 用构造函数来封装信息
	 */
	
	public UserExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
