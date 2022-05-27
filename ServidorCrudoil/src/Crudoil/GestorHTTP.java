package Crudoil;

import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GestorHTTP implements HttpHandler{
	public void handle(HttpExchange httpExchange) {
		// TODO Auto-generated method stub
		String requestParamValue=null;
		if("GET".equals(httpExchange.getRequestMethod())) {
		requestParamValue = handleGetRequest(httpExchange);
		handleGETResponse(httpExchange,requestParamValue);
		}}
	private String handleGetRequest(HttpExchange httpExchange) {
	return httpExchange.getRequestURI().toString();
	}
	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) {
		try {
			JSONObject jsonObject = (JSONObject) readJsonSimpleDemo("Api.json");
			
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = jsonObject.toString();
		httpExchange.sendResponseHeaders(200, htmlResponse.length());
		outputStream.write(htmlResponse.getBytes());
		outputStream.flush();
		outputStream.close();
		}catch(Exception e) {}}

public static Object readJsonSimpleDemo(String filename) throws Exception {
    FileReader reader = new FileReader(filename);
    JSONParser jsonParser = new JSONParser();
    return jsonParser.parse(reader);
}
}