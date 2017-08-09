package extraCredit.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import extraCredit.domain.Actor;
import extraCredit.domain.Artist;
import extraCredit.domain.Director;
import extraCredit.domain.Genre;
import extraCredit.domain.TVSeries;
import extraCredit.domain.Rating;



@Transactional
@Service
public class TVSeriesDao {

	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public TVSeriesDao() throws ParseException{
		TVSeries m1 = new TVSeries("Game Of Throne",2008,"Based on true story", Rating.Excellent, Genre.Adventrue);
		TVSeries m2 = new TVSeries("Friends",1995,"Story about friends in manhatten", Rating.Excellent, Genre.Comedy);
		m1.addComments("The best movie");
		m1.addComments("Best movie i have ever seen");
		m2.addComments("What a director");
		
		Artist actor1 = new Actor("Tony","Tom Hanks","Iowa",sdf.parse("10/20/1975"));
		Artist director1 = new Director("James Cameroon","Chicago",sdf.parse("10/20/1970"));
		Artist actor2 = new Actor("Roberts","Julia","NewYork",sdf.parse("10/20/1980"));
		Artist director2 = new Director("Cambridge","Louisianna",sdf.parse("11/22/1976"));
		
		m1.addArtists(actor1);
		m1.addArtists(director1);
		
		m2.addArtists(actor2);
		m2.addArtists(director2);
		
		add(m1);
		add(m2);
		
	}
	
	public void add(TVSeries m) {
		sf.getCurrentSession().persist(m);
	}
	
	public List<Artist> getAll() { //Getting all artists
		Query q = sf.getCurrentSession().createQuery("from TVSeries");
		List<Artist> artists = q.list();
		return artists;
	}
}
