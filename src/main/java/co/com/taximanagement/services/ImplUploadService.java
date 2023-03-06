package co.com.taximanagement.services;

//import java.io.File;
import java.io.IOException;
//import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImplUploadService implements IUploadService {

	private final Logger log = LoggerFactory.getLogger(ImplUploadService.class);
	
	private final static String UPLOAD_PATH = "uploads";
	
	
	@Override
	public String copy(MultipartFile file) throws IOException {
		String fileName = UUID.randomUUID().toString().substring(0, 12) + "_" + file.getOriginalFilename().replace(" ", "");
		Path filePath = getPath(fileName);
		log.info(filePath.toString());
		
		Files.copy(file.getInputStream(), filePath);
		
		return filePath.toString();
	}

	
	@Override
	public Path getPath(String file) {
		return Paths.get(UPLOAD_PATH).resolve(file).toAbsolutePath();
	}

}
