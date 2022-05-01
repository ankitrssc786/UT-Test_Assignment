package com.pth.ci.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.FormParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.pth.ci.dto.ResponseDto;
import com.pth.ci.util.Util;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

	@PostMapping("/saveData")
	public ResponseDto saveData(@FormParam(value = "val") String val)
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {

		Util util = new Util();
		ResponseDto response = new ResponseDto();
		if (!val.equalsIgnoreCase("")) {
			if (val.matches("[0-9]+")) {
				List<String[]> myData = util.getData(val);

				CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\Dell765\\Documents\\test.csv"));

				long bytes = myData.toString().length();
				if (bytes / (1024 * 1024) <= 10) {
					writer.writeAll(myData);
					writer.close();
					response.setCode(200);
					response.setMessage("CSV File written successfully all at a time.");
				} else {
					response.setCode(400);
					response.setMessage("Bad Request (CSV File cannot be written more then 10 MB data at a time.)");
				}
			} else {
				response.setCode(204);
				response.setMessage("Values should be number only.");
			}
		} else {
			response.setCode(204);
			response.setMessage("No content. Request value is mandatory.");
		}
		return response;
	}

}
