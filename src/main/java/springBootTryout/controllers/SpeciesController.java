package springBootTryout.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBootTryout.data.Species;
import springBootTryout.service.SpeciesService;

import java.util.List;

@RestController
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

    @RequestMapping("/species")
    public List<Species> getAllSpecies(){
        return speciesService.getAllSpecies();
    }
    @RequestMapping("/species/{name}")
    public Species getSpecies(@PathVariable String name){
        return speciesService.getSpecies(name);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/species")
    public void addSpecies(@RequestBody Species species){
        speciesService.addSpecies(species);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/species/{name}")
    public void updateSpecies(@RequestBody Species species, @PathVariable String name){
        speciesService.updateSpecies(name, species);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/species/{name}")
    public void deleteSpecies(@PathVariable String name){
        speciesService.deleteSpecies(name);
    }

}
