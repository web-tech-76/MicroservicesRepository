package upload.download.app.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

import upload.download.app.resources.FileDetails;

@Service
public class MongoDbFileService {

	
	@Autowired
	GridFsOperations gridoperations;

	public List<FileDetails> findAll() {
		List<FileDetails> fileList = new ArrayList<FileDetails>();
		List<GridFSFile> gridfsList = new ArrayList<GridFSFile>();

		gridoperations.find(new Query()).into(gridfsList);

		System.out.println(" return list size : " + gridfsList.size());

		for (GridFSFile gridFSFile : gridfsList) {

			fileList.add(

					new FileDetails(gridFSFile.getObjectId().toString(), gridFSFile.getFilename(),
							gridFSFile.getMetadata().getString("contentType"), gridFSFile.getLength()));
		}
		return fileList;
		// return this.gridTemplate.find(new Query()).into(new ArrayList<GridFSFile>());
	}
	
	public GridFSFile findFile(String id) {
			GridFSFile file = gridoperations.findOne(new Query(Criteria.where("_id").is(id)));
		return file;
	}
	

	public String saveFile(InputStream fin, FileDetails document) {

		try {
			DBObject metaData = new BasicDBObject();
			metaData.put("contentType", document.getContentType());
			ObjectId objectId = gridoperations.store(fin, document.getFilename(), metaData);
			return objectId.toString();
		} catch (Exception e) {
			return "";
		}
	}

	public String[] saveAll(List<InputStream> finList, List<FileDetails> documentList) {

		String[] objectIds = new String[documentList.size()];
		int count = 0;

		try {
			while (documentList.iterator().hasNext() && finList.iterator().hasNext()) {
				DBObject metaData = new BasicDBObject();
				metaData.put("contentType", documentList.iterator().next().getContentType());
				ObjectId objectId = gridoperations.store(finList.iterator().next(),
						documentList.iterator().next().getFilename(), metaData);
				objectIds[count] = objectId.toString();
			}
			return objectIds;
		} catch (Exception e) {
			return null;
		}
	}

	public void deleteFile(String id) {
		gridoperations.delete(new Query(Criteria.where("_id").is(id)));
	}

	public void deleteAll() {
		gridoperations.delete(new Query());
	}

	public GridFsResource download(String id) {
		GridFSFile file = null;
		file = gridoperations.findOne(new Query(Criteria.where("_id").is(id)));
		
		return gridoperations.getResource(file.getFilename());
	}

}
