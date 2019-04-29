import java.text.*;
import java.util.*;
import java.io.*;

class DecimalFormatEx4 {
    public static void main(String[] args) throws Exception{
        String tableName = "CUST_INFO";
        String fileName = "data4.txt";
        String msg = "INSERT INTO " + tableName 
            + " VALUES ({0}, {1}, {2}, {3});"
        Scanner s = new Scanner(new File(fileName));
        
        String pattern = "{0},{1},{2},{3}";
        MessageFormat mf = new MessageFormat(pattern);
        
        while(s.hasNextLine()) {
            String line = s.nextLine();
            Object[] objs = mf.parse(line);
            System.out.println(MessageFormat.format(msg, objs));
        }
        
        s.close();
    }
}