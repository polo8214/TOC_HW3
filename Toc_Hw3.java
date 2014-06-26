import java.net.*;
import java.nio.charset.Charset;
import java.io.*;
import org.json.*;


public class Toc_Hw3
{
  public static void main(String[] args) throws Exception
  {
	  String theUrl = args[0];
	  String town = args[1];
	  String road = args[2];
	  String year = args[3];
	  
	  
	    try
	    {
	      // create a url object
	      URL url = new URL(theUrl);
	 
	      // create a urlconnection object
	      URLConnection urlConnection = url.openConnection();
	      
	      int total_price=0;
	      int count=0;
	      JSONArray jarray = new JSONArray(new JSONTokener(new InputStreamReader(urlConnection.getInputStream(),Charset.forName("UTF-8"))));
	      JSONObject find;
	      for(int i = 0; i < jarray.length(); i++){

	        	 find = jarray.optJSONObject(i);
	        	 if(find.optString("�m����").equals(town) && 
	        		find.optString("�g�a�Ϭq��m�Ϋت��Ϫ��P").contains(road)&& 
	        		((find.optInt("����~��")/100) == Integer.parseInt(year))){

	        		 total_price += find.optInt("�`����"); 
	 				count++;
	 			}
	         }
	      
	      System.out.println("Output:"+(int)(total_price/count));

	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
  }
 
  

}