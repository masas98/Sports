package lt.bit.Sport.Controllers;


import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lt.bit.Sport.services.StorageService;

@Controller
@RequestMapping("/files")
public class FileStorageController {
	
	@Autowired
	private StorageService storageService;
	
	@GetMapping("/")
	public String home() {
		return "uploadForm";
	}
	
	@PostMapping("/")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		storageService.store(file);
		return home();
	}
	
//	@GetMapping("/paveikslas.jpg")
//	public ResponseEntity<Resource> getFile(){
//		Resource file=storageService.loadFile("paveikslas.jpg");
//	}
	
	
}
