package com.tts.mapsapp.controlller;

import com.tts.mapsapp.models.Location;
import com.tts.mapsapp.service.MapService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapController {

	@Autowired
	MapService mapService;

	@GetMapping("/")
	public String getDefaultMap(Model model) {

		model.addAttribute(new Location());

		return "index";
	}

	@PostMapping("/home")
	public String getMapForLocation(Location location, Model model) {

        Boolean passed = mapService.addCoordinates(location);
        if (passed == true){
            model.addAttribute(location);

        }
        else {
            // String errorMsg = ;
            model.addAttribute("errorMsg", "Address not found");
        }
		return "index";
    }
    
    @PostMapping("/random")
    public String getRandomMap(Model model) {
        Location location = mapService.getRandomCoordinates();
        model.addAttribute(location);

        return "index";

    }

	// @PostMapping("/random")
	// public String getRandomLocation(Model model){

	// Location city = mapService.randomCity();

	// model.addAttribute(city);

	// return "index";
	// }

}
