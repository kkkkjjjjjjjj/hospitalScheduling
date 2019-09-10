package cn.mdsoftware.mdframework.common.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.mdsoftware.mdframework.bean.FileMeta;
import cn.mdsoftware.mdframework.bean.FileMeta;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import cn.mdsoftware.mdframework.bean.FileMeta;

@Component
@ConfigurationProperties(prefix = "file.op")
public class FileOperation {
	private static String localFilePath;
	
	public static List<FileMeta> uploadFile(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		List<FileMeta> fileLists = new ArrayList<>();
		Map<String, MultipartFile> fileMap = request.getFileMap();
		
		Iterator<Map.Entry<String, MultipartFile>> iter = fileMap.entrySet().iterator();
		
		while(iter.hasNext()) {
			Map.Entry<String, MultipartFile> entry = iter.next();
			FileMeta fileMeta = new FileMeta();
			fileMeta.setFileName(entry.getValue().getOriginalFilename());
			fileMeta.setFileType(entry.getValue().getContentType());
			fileMeta.setFileSize(String.valueOf(entry.getValue().getSize()));
			fileMeta.setBytes(entry.getValue().getBytes());
			
			File file = new File(localFilePath + fileMeta.getFileName());
			if(!file.exists()) {
				//file.mkdirs();
				file.createNewFile();
			}
			
			FileCopyUtils.copy(fileMeta.getBytes(), new BufferedOutputStream(new FileOutputStream(file), 1024*2));
			
			fileLists.add(fileMeta);
			
		}
		
		return fileLists;
	}
	
	public static String gainFullPaht(String fileNames, FastFileStorageClient storageClient) throws Exception {
		String[] fNames = fileNames.split("#");
		StorePath storePath = null;
		String picPath = "";
		if(fNames.length > 0) {
			for (int i = 0; i < fNames.length; i++) {
				File file = new File(localFilePath + fNames[i]);
				FileInputStream input;
				input = new FileInputStream(file);
				storePath = storageClient.uploadFile(input,file.length(), FilenameUtils.getExtension(fNames[i]),null);
				if(i != fNames.length - 1) {
					picPath += storePath.getFullPath() + ",";
				} else {
					picPath += storePath.getFullPath();
				}
			}
		}
		return picPath;
	}

	public String getLocalFilePath() {
		return localFilePath;
	}

	@SuppressWarnings("static-access")
	public void setLocalFilePath(String localFilePath) {
		this.localFilePath = localFilePath;
	}
}
