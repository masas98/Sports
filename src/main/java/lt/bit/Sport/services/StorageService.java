package lt.bit.Sport.services;



import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	
	void init();
	
	void store(MultipartFile file);
	
	Resource resource();
	

	
	
}
