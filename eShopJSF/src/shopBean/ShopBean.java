package shopBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="bean", eager = true)
@SessionScoped

public class ShopBean {
	int articleNumber = 0;

	String articleName = "";
	
	ArrayList<String> articleList= new ArrayList<String>();

	/*@ManagedProperty(value="#{bean}")
	private ShopBean bean;

	//must povide the setter method
	public void setBean(ShopBean bean) {
		this.bean = bean;
	}
*/
	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String giveSpecialThing(int articleNumber) {
		// for list etaration
		// if arikelNumber==true
		return articleName;
	}

	public String giveArticlenumberAndName() {
		return getArticleNumber() + " " + getArticleName();
	}
	
	 public ShopBean() {
	        articleList.add("1");
	        articleList.add("2");
	        articleList.add("3");
	    }

	    public int getCount() {
	        return articleList.size();
	    }

	    public List<String> getArticleList() {
	        return articleList;
	    }
}
