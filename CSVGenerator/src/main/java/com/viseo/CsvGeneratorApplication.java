package com.viseo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viseo.util.CSVGeneratorUtil;

@SpringBootApplication
public class CsvGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvGeneratorApplication.class, args);
		CSVGeneratorUtil csvGeneratorUtil = new CSVGeneratorUtil();
		csvGeneratorUtil.generateCSV("C:/MyTools/Workspace/CMA-CGM_Codes/CSVGenerator/FILES/sample.csv");
		
		csvGeneratorUtil.readCSVSequencial("C:/MyTools/Workspace/CMA-CGM_Codes/CSVGenerator/FILES/sample.csv");
		csvGeneratorUtil.readCSVWithHeader("C:/MyTools/Workspace/CMA-CGM_Codes/CSVGenerator/FILES/sample.csv");
		csvGeneratorUtil.readCSVinPage("C:/MyTools/Workspace/CMA-CGM_Codes/CSVGenerator/FILES/sample.csv", 3);
	}
	


}
