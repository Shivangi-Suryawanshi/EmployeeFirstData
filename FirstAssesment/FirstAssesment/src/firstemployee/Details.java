package firstemployee;
import java.time.LocalDateTime;
import java.util.*;
public class Details {
	int id;
	String name;
	String dept;
    LocalDateTime date;
   Details(int id, String name, String dept, LocalDateTime date) {
	 this.id=id;
	 this.name=name;
	 this.dept=dept;
	 this.date=date;
   }
}
