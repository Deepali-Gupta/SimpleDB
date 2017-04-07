/**
 * 
 */
package simpledb.query;
import java.util.*;
import java.text.*;
/**
 * @author deepali
 *
 */
public class TimestampConstant implements Constant {
	private Date val;
	String pattern = "yyyy-MM-dd HH:mm:ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);   
	   /**
	    * Create a constant by wrapping the specified date
	    * @param n the long value
	 * @throws ParseException 
	    */
	//handle exception for format checking while input itself
	//storage as long values
	//TODO
	   public TimestampConstant(String n) throws ParseException {
	      val = simpleDateFormat.parse(n);
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
	   
	   public boolean after(Date d) {
		   return val.after(d);
	   }
	   
	   public boolean before(Date d) {
		   return val.before(d);
	   }
	   
	   public int hashCode() {
	      return val.hashCode();
	   }
	   
	   public String toString() {
	      return val.toString();
	   }
}
