package co.com.taximanagement.services;

import java.io.IOException;
//import java.net.MalformedURLException;
import java.nio.file.Path;

//import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

	//public Resource upload(String nombreArchivo) throws MalformedURLException;
	
	public String copy(MultipartFile archivo) throws IOException;
	
	//public boolean delete(String nombreArchivo);
	
	public Path getPath(String nombreArchivo);
}
