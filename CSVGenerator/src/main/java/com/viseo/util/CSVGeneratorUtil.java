package com.viseo.util;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

import de.siegmar.fastcsv.reader.CsvIndex;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRecord;
import de.siegmar.fastcsv.reader.IndexedCsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRecord;
import de.siegmar.fastcsv.writer.CsvWriter;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class CSVGeneratorUtil {
	
	public void generateCSV(String destinationFile) {
		Path file = Path.of(destinationFile);
		try (CsvWriter csv = CsvWriter.builder().build(file)) {
		    csv
		        .writeRecord("header 1", "header 2")
		        .writeRecord("value 1", "value 2");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void readCSVSequencial(String sourceFile) {
		Path file = Path.of(sourceFile);
		try (CsvReader<CsvRecord> csv = CsvReader.builder().ofCsvRecord(file)) {
		    csv.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readCSVWithHeader(String sourceFile) {
		Path file = Path.of(sourceFile);
		try (CsvReader<NamedCsvRecord> csv = CsvReader.builder().ofNamedCsvRecord(file)) {
		    csv.forEach(rec -> System.out.println(rec.getField("header 1")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readCSVinPage(String sourceFile, int page) {
		Path file = Path.of(sourceFile);
		try (IndexedCsvReader<CsvRecord> csv = IndexedCsvReader.builder().pageSize(page).ofCsvRecord(file)) {
		    CsvIndex index = csv.getIndex();
		    int lastPage = index.pages().size() - 1;
		    List<CsvRecord> csvRecords = csv.readPage(lastPage);
		    log.info("CSV  RECORDS : Fist={}, Last={}",csvRecords.getFirst(), csvRecords.getLast());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
