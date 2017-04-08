/**
 * 
 */
package simpledb.query;
import java.util.*;
import java.text.*;
import java.lang.Long;
/**
 * @author deepali
 *
 */
public class TimestampConstant implements Constant {
	private Date val;
	String pattern = "yyyy-MM-dd HH:mm:ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);   
	
	//handle exception for format checking while input itself
	//storage as long values
	//TODO
	   public TimestampConstant(String n){
	      
			try {
				val = simpleDateFormat.parse(n);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   
	   /**
	    * Unwraps the date and returns it.
	    * @see simpledb.query.Constant#asJavaVal()
	    */
	   public Object asJavaVal() {
	      return val;
	   }
	   
	   public boolean equals(Object obj) {
	      TimestampConstant tc = (TimestampConstant) obj;
	      return tc != null && val.equals(tc.val);
	   }
	   
	   public int compareTo(Constant c) {
		   TimestampConstant tc = (TimestampConstant) c;
	       return val.compareTo(tc.val);
	   }
	   
	   public int hashCode() {
	      return val.hashCode();
	   }
	   
	   public String toString() {
	      return val.toString();
	   }
}
