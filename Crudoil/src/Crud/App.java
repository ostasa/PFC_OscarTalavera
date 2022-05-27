package Crud;

	import java.awt.Desktop;
import java.io.IOException;
	import java.net.URI;
	import java.net.http.HttpClient;
	import java.net.http.HttpRequest;
	import java.net.http.HttpResponse;
	import java.net.http.HttpResponse.BodyHandlers;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
import java.util.Scanner;

import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
	import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.mongodb.MongoClient;
	import com.mongodb.client.MongoCollection;
	import com.mongodb.client.MongoCursor;
	import com.mongodb.client.MongoDatabase;

	public class App {
		static Scanner x = new Scanner(System.in);
		static String urlApis= "http://127.0.0.1:7777/api";
		static ArrayList<Gasolinera> gasolineras = new ArrayList<>();
		static String mayuscula(String str) {
		      char[] arr = str.toCharArray();
		      arr[0] = Character.toUpperCase(arr[0]);
		      return new String(arr);
		   }
		public static void llamadaApi(String urlApi) throws IOException, InterruptedException{
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
	              .uri(URI.create(urlApi))
	              .GET()
	              .build();
		HttpResponse<String> respuesta=client.send(request,BodyHandlers.ofString());
			Gson gson = new Gson();
				Clase clas =gson.fromJson(respuesta.body(), Clase.class);
				gasolineras =  clas.getGasol();
				System.out.println("ESTE ES RESULTADO " + clas.gasol.size());
				 System.out.println("ESTE ES RESULTADO " + gasolineras.size());
				 System.out.println("Que filtro quiere codigo postal, pueblo o provincia (Cualquier otro caracter)");
				 String cp = x.nextLine().toLowerCase();
				 if (cp.equals("codigo postal") ) {
					 System.out.println("Codigo Postal en el que se desea buscar");
					 String cod = x.nextLine();
					 for(int i=0;i<gasolineras.size();i++){
						if( gasolineras.get(i).CP.equals(cod)) {
							System.out.println("Codigo Postal " +gasolineras.get(i).getCP());
							System.out.println("Pueblo " +gasolineras.get(i).getMunicipio());
							System.out.println("Marca " +gasolineras.get(i).getRotulo());
							System.out.println("Direccion " +gasolineras.get(i).getDireccion());
							System.out.println("Horario " +gasolineras.get(i).getHorario());
							System.out.println("Precio Diesel A " +gasolineras.get(i).getPrecioGasoleoA());
							System.out.println("Precio Diesel B " +gasolineras.get(i).getPrecioGasoleoB());
							System.out.println("Precio Diesel Premium " +gasolineras.get(i).getPrecioGasoleoPremium());
							System.out.println("Precio Gasolina 95 " +gasolineras.get(i).getPrecioGasolina95E5());
							System.out.println("Precio Gasolina 95 Premium " +gasolineras.get(i).getPrecioGasolina95E5Premium());
							System.out.println("Precio Gasolina 98 " +gasolineras.get(i).getPrecioGasolina98E5());
							 System.out.println("¿Quieres ir a esa Gasolinera?");
							 String ir = x.nextLine().toLowerCase();
							 if(ir.equals("si")) {
								 String url = "https://www.google.es/maps/place/" + gasolineras.get(i).getLatitud().replace(",",".") + "," + gasolineras.get(i).getLongitud().replace(",",".");
								 Desktop enlace=Desktop.getDesktop();
							        try {
							                enlace.browse(new URI(url));
							        } catch (Exception e) {
							            e.getMessage();
							        }
							 }else { if(ir.equals("cerrar")){
								 System.exit(1);}
							 }
						}
					 }
				 }else {if(cp.equals("pueblo")){
					 System.out.println("pueblo en el que se desea buscar");
					 String res = x.nextLine() ;
					 String cod = mayuscula(res);
					 for(int i=0;i<gasolineras.size();i++){
							if( gasolineras.get(i).getMunicipio().equals(cod)) {
								System.out.println("Codigo Postal " +gasolineras.get(i).getCP());
								System.out.println("Pueblo " +gasolineras.get(i).getMunicipio());
								System.out.println("Marca " +gasolineras.get(i).getRotulo());
								System.out.println("Direccion " +gasolineras.get(i).getDireccion());
								System.out.println("Horario " +gasolineras.get(i).getHorario());
								System.out.println("Precio Diesel A " +gasolineras.get(i).getPrecioGasoleoA());
								System.out.println("Precio Diesel B " +gasolineras.get(i).getPrecioGasoleoB());
								System.out.println("Precio Diesel Premium " +gasolineras.get(i).getPrecioGasoleoPremium());
								System.out.println("Precio Gasolina 95 " +gasolineras.get(i).getPrecioGasolina95E5());
								System.out.println("Precio Gasolina 95 Premium " +gasolineras.get(i).getPrecioGasolina95E5Premium());
								System.out.println("Precio Gasolina 98 " +gasolineras.get(i).getPrecioGasolina98E5());
								 System.out.println("¿Quieres ir a esa Gasolinera?");
								 String ir = x.nextLine().toLowerCase();
								 if(ir.equals("si")) {
									 String url = "https://www.google.es/maps/place/" + gasolineras.get(i).getLatitud().replace(",",".") + "," + gasolineras.get(i).getLongitud().replace(",",".");
									 Desktop enlace=Desktop.getDesktop();
								        try {
								                enlace.browse(new URI(url));
								        } catch (Exception e) {
								            e.getMessage();
								        }
								 }else { if(ir.equals("cerrar")){
									 System.exit(1);}
								 }
							}
						 }} 
				 
				 else{
				 
					 String prov ="0";
					 System.out.println("Provincia en la que se desea buscar");
					 String cod = x.nextLine().toLowerCase();
					 System.out.println(cod);
					 if (cod.equals("alava")) {
						prov="01"; 
					 }else { if (cod.equals("albacete")) {
							prov="02"; 
					 }else {
					 if (cod.equals("alicante")) {
							prov="03"; 
					 }else {
					 if (cod.equals("almeria")) {
							prov="04"; 
					 }else {
					 if (cod.equals("avila")) {
							prov="05"; 
					 }else { if (cod.equals("badajoz")) {
							prov="06"; 
					 }else { if (cod.equals("baleares")) {
							prov="07"; 
					 }else { if (cod.equals("barcelona")) {
							prov="08"; 
					 }else { if (cod.equals("burgos")) {
							prov="09"; 
					 }else { if (cod.equals("caceres")) {
							prov="10"; 
					 }else { if (cod.equals("cadiz")) {
							prov="11"; 
					 }else { if (cod.equals("castellon")) {
							prov="12"; 
					 }else { if (cod.equals("ciudad real")) {
							prov="13"; 
					 }else { if (cod.equals("cordoba")) {
							prov="14"; 
					 }else { if (cod.equals("la coruña")) {
							prov="15"; 
					 }else { if (cod.equals("cuenca")) {
							prov="16"; 
					 }else { if (cod.equals("girona")) {
							prov="17"; 
					 }else { if (cod.equals("granada")) {
							prov="18"; 
					 }else { if (cod.equals("guadalajara")) {
							prov="19"; 
					 }else { if (cod.equals("guipuzcoa")) {
							prov="20"; 
					 }else { if (cod.equals("huelva")) {
							prov="21"; 
					 }else { if (cod.equals("huesca")) {
							prov="22"; 
					 }else { if (cod.equals("jaen")) {
							prov="23"; 
					 }else { if (cod.equals("leon")) {
							prov="24"; 
					 }else { if (cod.equals("lleida")) {
							prov="25"; 
					 }else { if (cod.equals("la rioja")) {
							prov="26"; 
					 }else { if (cod.equals("lugo")) {
							prov="27"; 
					 }else { if (cod.equals("madrid")) {
							prov="28"; 
					 }else { if (cod.equals("malaga")) {
							prov="29"; 
					 }else { if (cod.equals("murcia")) {
							prov="30"; 
					 }else { if (cod.equals("navarra")) {
							prov="31"; 
					 }else { if (cod.equals("orense")) {
							prov="32"; 
					 }else { if (cod.equals("asturias")) {
							prov="33"; 
					 }else { if (cod.equals("palencia")) {
							prov="34"; 
					 }else { if (cod.equals("las palmas")) {
							prov="35"; 
					 }else { if (cod.equals("pontevedra")) {
							prov="36"; 
					 }else { if (cod.equals("salamanca")) {
							prov="37"; 
					 }else { if (cod.equals("tenerife")) {
							prov="38"; 
					 }else { if (cod.equals("cantabria")) {
							prov="39"; 
					 }else { if (cod.equals("segovia")) {
							prov="40"; 
					 }else { if (cod.equals("sevilla")) {
							prov="41"; 
					 }else { if (cod.equals("soria")) {
							prov="42"; 
					 }else { if (cod.equals("tarragona")) {
							prov="43"; 
					 }else { if (cod.equals("teruel")) {
							prov="44"; 
					 }else { if (cod.equals("toledo")) {
							prov="45"; 
					 }else { if (cod.equals("valencia")) {
							prov="46"; 
					 }else { if (cod.equals("valladolid")) {
							prov="47"; 
					 }else { if (cod.equals("vizcaya")) {
							prov="48"; 
					 }else { if (cod.equals("zamora")) {
							prov="49"; 
					 }else { if (cod.equals("zaragoza")) {
							prov="50"; 
					 }else { if (cod.equals("ceuta")) {
							prov="51"; 
					 }else { if (cod.equals("melilla")) {
							prov="52"; 
					 }}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
					 
					 for(int i=0;i<gasolineras.size();i++){
							if( gasolineras.get(i).getIDProvincia().equals(prov)) {
								System.out.println("Codigo Postal " +gasolineras.get(i).getCP());
								System.out.println("Pueblo " +gasolineras.get(i).getMunicipio());
								System.out.println("Marca " +gasolineras.get(i).getRotulo());
								System.out.println("Direccion " +gasolineras.get(i).getDireccion());
								System.out.println("Horario " +gasolineras.get(i).getHorario());
								System.out.println("Precio Diesel A " +gasolineras.get(i).getPrecioGasoleoA());
								System.out.println("Precio Diesel B " +gasolineras.get(i).getPrecioGasoleoB());
								System.out.println("Precio Diesel Premium " +gasolineras.get(i).getPrecioGasoleoPremium());
								System.out.println("Precio Gasolina 95 " +gasolineras.get(i).getPrecioGasolina95E5());
								System.out.println("Precio Gasolina 95 Premium " +gasolineras.get(i).getPrecioGasolina95E5Premium());
								System.out.println("Precio Gasolina 98 " +gasolineras.get(i).getPrecioGasolina98E5());
								 System.out.println("¿Quieres ir a esa Gasolinera?");
								 String ir = x.nextLine().toLowerCase();
								 if(ir.equals("si")) {
									 String url = "https://www.google.es/maps/place/" + gasolineras.get(i).getLatitud().replace(",",".") + "," + gasolineras.get(i).getLongitud().replace(",",".");
									 Desktop enlace=Desktop.getDesktop();
								        try {
								                enlace.browse(new URI(url));
								        } catch (Exception e) {
								            e.getMessage();
								        }
								 }else { if(ir.equals("cerrar")){
									 System.exit(1);}
								 }
				 }}}}
			// 	resultado = resul.getResultado();
			//  } catch (Exception eek) {
			// 	 System.out.println(resultado);
			// 	if (resultado.equals("ERROR") ) {
			// 		informe.sumarCorrectos();
			// 		System.out.println("Toca OK");
			// 	} else {
			// 		 informe.sumarErrores();
			// 		 logs.escribirArc(mensaje);
			// 		 System.out.println("Toca OK pero lo da mal");
			// 		String seguir = "";
			// 		System.out.println("Press Enter key to continue...");
			// 		try {
			// 			seguir = x.nextLine();
			//		} catch (Exception e) {
			//	}
			//}
		// 	 }
		// 	long fin = System.currentTimeMillis();
			 
		// 	double tiempo = (double) ((fin - inicio)/1000);
			 
		// 	System.out.println(tiempo +" segundos");
		// }

		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	try {
		llamadaApi(urlApis);
	} catch (IOException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}

	}

