package extraCredit.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="searchTVSeriesByName",query="select m from TVSeries m where m.name=:name"),
	@NamedQuery(name="searchTVSeriesByGenre",query="select m from TVSeries m where m.genre=:genre"),
	@NamedQuery(name="searchTVSeriesByRating",query="select m from TVSeries m where m.rating=:rating"),
	@NamedQuery(name="searchTVSeriesByYear",query="select m from TVSeries m where m.year=:year")
})
public class TVSeries {

	@Id @GeneratedValue
	private long id;
	private String name;
	private int year;
	private String summary;
	
	public TVSeries(){}
	
	public TVSeries(String name,int year,String summary, Rating rating, Genre genre){
		this.name = name;
		this.year=year;
		this.summary=summary;
		this.rating = rating;
		this.genre = genre;
	}
	
	@Lob
	private Byte[] poster;
	
	public void setPoster(Byte[] poster) {
		this.poster = poster;
	}

	@Enumerated(EnumType.STRING)
	private Rating rating;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="TVSeries_Artist",
			joinColumns=@JoinColumn(name ="TVSeries_Id"),
			inverseJoinColumns=@JoinColumn(name="artist_Id"))
	private List<Artist> artists=new ArrayList<Artist>();
	
	@ElementCollection
	private List<String> comments=new ArrayList<String>();
	
	public void addComments(String comment){
		this.comments.add(comment);
	}
	
	public void addArtists(Artist a){
		this.artists.add(a);
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public String getSummary() {
		return summary;
	}

	public Rating getRating() {
		return rating;
	}

	public Genre getGenre() {
		return genre;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public List<String> getComments() {
		return comments;
	}
	
	
	
}
