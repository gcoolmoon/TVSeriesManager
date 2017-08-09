package extraCredit.DAO;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import extraCredit.domain.Artist;
import extraCredit.domain.TVSeries;


@Controller
public class ImdbController {

	@Resource
	private ArtistDao artistDao;

	@Resource
	private TVSeriesDao movieDao;
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "tvseriesList";
	}
	
	@RequestMapping(value="/tvseries", method=RequestMethod.GET)
	public String getAll(Model model){
		model.addAttribute("tvseries", movieDao.getAll());
		return "tvseriesList";
	}
	
	@RequestMapping(value="/addTVSeries", method = RequestMethod.GET)
	public String addMovie(@ModelAttribute TVSeries m) {
        return "addTVSeries";
    }
	@RequestMapping(value="/addArtist", method = RequestMethod.GET)
	public String addArtist(@ModelAttribute Artist a) {
        return "addArtist";
    }
	
    @RequestMapping(value = "/artist/delete", method = RequestMethod.POST)
	public String delete(Artist a) {
        artistDao.delete(a);
        return "redirect:/artists";
    }


	
	
	
}
