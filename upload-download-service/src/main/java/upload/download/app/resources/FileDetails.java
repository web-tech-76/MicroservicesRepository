package upload.download.app.resources;

import java.text.DecimalFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "fs.files")
public @Data class FileDetails {

	
	@Id
	private String _id;
	
	private String filename;
	private String contentType;
	private String chunkSize;
	
	
	public FileDetails() {}
	
	public FileDetails(String id, String filename, String contentType, long size){
		this._id= id;
		this.filename = filename;
		this.contentType=contentType;
				
		double b = size;
	    double k = b/1024.0;
	    double m = (k/1024.0);
	    double g = (m/1024.0);
	    double t = (g/1024.0);

	    DecimalFormat dec = new DecimalFormat("0.00");

	    if ( t>1 ) {
	    	chunkSize = dec.format(t).concat(" TB");
	    } else if ( g>1 ) {
	    	chunkSize  = dec.format(g).concat(" GB");
	    } else if ( m>1 ) {
	    	chunkSize  = dec.format(m).concat(" MB");
	    } else if ( k>1 ) {
	    	chunkSize  = dec.format(k).concat(" KB");
	    } else {
	    	chunkSize  = dec.format(b).concat(" Bytes");
	    }

		
	}
	
	
}
