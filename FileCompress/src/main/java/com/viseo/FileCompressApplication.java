package com.viseo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viseo.util.FileCompressUtil;

@SpringBootApplication
public class FileCompressApplication {
	public static void main(String[] args) {
		SpringApplication.run(FileCompressApplication.class, args);

		FileCompressUtil fileCompressUtil = new FileCompressUtil();
		fileCompressUtil.compressSingleFile(
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/source/cma-cgm-logo.png",
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/destination/compressSingle.zip");

		fileCompressUtil.compressMultipleFiles(
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/source/cma-cgm-logo.png",
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/source/eClaimsImp.csv",
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/destination/compressMultiple.zip");
		
		fileCompressUtil.compressDirectory(
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/source",
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/destination/compressFolder.zip");
		
		fileCompressUtil.decompressFile(
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/destination/compressSingle.zip",
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/destination/decompressSingle");
		
		fileCompressUtil.appendToZip(
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/source/DSC_0082.JPG",
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/destination/compressSingle.zip");

		
		fileCompressUtil.decompressFile(
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/destination/compressFolder.zip",
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/destination/decompressFolder");
		
		fileCompressUtil.decompressFile(
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/destination/compressSingle.zip",
				"C:/MyTools/Workspace/CMA-CGM_Codes/FileCompress/FileExample/destination/decompressAppended");
	}
}
