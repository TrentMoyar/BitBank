import java.util.*;
import java.io.*;
import java.io.Writer.*;
public class RetainInfo
{
   private static File name, data;
   public static void main(String[] args) throws IOException
   {
      name = new File("names.txt");
      data = new File("data.txt");
      Set<String> inData = new HashSet<String>();
      Set<String> keys = new TreeSet<String>();
      Map<String, String> totalData = new TreeMap<String, String>();
      Scanner nameFile = new Scanner(name);
      Scanner dataFile = new Scanner(data);
      PrintWriter out = new PrintWriter(new File("aTOn.txt"));
      while(nameFile.hasNextLine())
      {
         inData.add(nameFile.nextLine());
      }
      while(dataFile.hasNextLine())
      {
         String temp = dataFile.nextLine();
         totalData.put(temp.substring(0, temp.indexOf(" ")), temp.substring(temp.indexOf(" ") + 1));
      }
      keys = totalData.keySet();
      keys.retainAll(inData);
      for(String s : keys)
      {
         out.println(s + ", " + totalData.get(s));
      }
      out.close();
   }
}