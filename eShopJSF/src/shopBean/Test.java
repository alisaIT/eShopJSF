package shopBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bean2", eager = true)
//@ManagedBean(name = "dbBean")

@SessionScoped
public class Test {
	public void test() {
		System.out.println("test bean geht!");
		
	}
}
