package lt.bit.Sport.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService implements StorageService{
	
	private final Path storageLocation;
	
	public FileStorageService() {
		this.storageLocation=Paths.get("uploads");
	}

	@Override
	public void init() {
		try {
			Files.createDirectory(this.storageLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void store(MultipartFile file) {
		try {
			Path targetFile=this.storageLocation.resolve(file.getOriginalFilename()).normalize().toAbsolutePath();
			InputStream inputStream=file.getInputStream();
			Files.copy(inputStream, targetFile, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
		

	@Override
	public Resource resource() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
