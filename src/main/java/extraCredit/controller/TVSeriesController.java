package extraCredit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import extraCredit.DAO.TVSeriesDao;
import extraCredit.domain.TVSeries;

@Controller
public class TVSeriesController {

	
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/tvseries", method = RequestMethod.POST)
	public void addTVSeries(@RequestBody TVSeries tvseries, TVSeriesDao tvseriesDAO) {
		tvseriesDAO.add(tvseries);
	}



}
