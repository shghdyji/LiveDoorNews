package Beans;

import java.util.List;


public class ItemBean {
	private String url;
	private String article;
	private String title;
	private int idArticle;
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	private List<ItemBean> relatedLink;
	private int idCategory;
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public List<ItemBean> getRelatedLink() {
		return relatedLink;
	}
	public void setRelatedLink(List<ItemBean> relatedLink) {
		this.relatedLink = relatedLink;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
