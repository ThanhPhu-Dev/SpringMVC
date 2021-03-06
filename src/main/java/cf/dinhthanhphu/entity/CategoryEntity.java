package cf.dinhthanhphu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	//MapopedBy trỏ tới tên biến category ở trong news.
	//tên MapopedBy phải giống tên biến ở class NewEntity
	@OneToMany(mappedBy = "category")
	private List<NewEntity> news = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<NewEntity> getNews() {
		return news;
	}

	public void setNews(List<NewEntity> news) {
		this.news = news;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
