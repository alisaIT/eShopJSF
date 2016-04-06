package shopBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bean", eager = true)
@SessionScoped

public class ShopBean {
	int articleNumber = 0;

	String articleName = "";
	String username = "";
	String userpassword = "";
	String email = "";

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	ArrayList<String> articleList = new ArrayList<String>();

	/*
	 * @ManagedProperty(value="#{bean}") private ShopBean bean;
	 * 
	 * //must povide the setter method public void setBean(ShopBean bean) {
	 * this.bean = bean; }
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
		articleList.add("1: Buch 1 , also bla bal bal bajkaskakdahjhdkhakh");
		articleList.add("2: Buch 2 , also bla bal bal bajkaskakdahjhdkhakh");
		articleList.add("3. Buch 3 , also bla bal bal bajkaskakdahjhdkhakh");
	}

	public int getCount() {
		return articleList.size();
	}

	public List<String> getArticleList() {
		return articleList;
	}
}
