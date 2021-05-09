package com.tokointest.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

/**
 * Class for read json file.
 *
 * @author Love
 *
 */
@Component @RequiredArgsConstructor
public class TokoinJsonReader {

	public JSONArray findJsonArray(String fileName) {
		File customer = getCustomerFileReader.apply(fileName);
		JSONParser parser = new JSONParser();

		try (Reader is = new FileReader(customer)) {
			return (JSONArray) parser.parse(is);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> searchProcess(JSONArray jsonArray, Class<T> clazz, String term, String value)
			throws Exception {
		List<T> cus = new LinkedList<>();
		ObjectMapper mapper = new ObjectMapper();
		for (Object eachCropJson : jsonArray) {
			HashMap<String, Object> eachCropMap = (HashMap<String, Object>) mapper.convertValue(eachCropJson,
					HashMap.class);
			if (eachCropMap.get(term) != null && String.valueOf(eachCropMap.get(term)).contains(value)) {
				cus.add(getObject(eachCropJson, clazz));
			}
		}
		return cus;
	}

	public static <T> List<T> findDataFromJson(JSONArray array, Class<T> clazz, String term, String value) {
		try {
			return searchProcess(array, clazz, term, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	static <T> T getObject(Object json, Class<T> clazz) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), clazz);
	}

	static Function<String, File> getCustomerFileReader = filename -> {
		ClassLoader cl = TokoinJsonReader.class.getClassLoader();
		return new File(cl.getResource(filename).getFile());
	};
}
