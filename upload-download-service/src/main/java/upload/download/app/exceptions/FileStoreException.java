package upload.download.app.exceptions;

public class FileStoreException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileStoreException(String message) {
		super(message);
	}
	
	public FileStoreException(String message ,Throwable throwable) {
		super(message, throwable);
		
	}
	
	
}
