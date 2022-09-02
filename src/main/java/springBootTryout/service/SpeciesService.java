package springBootTryout.service;

import org.springframework.stereotype.Service;
import springBootTryout.SpringBootTryoutApp;
import springBootTryout.data.Species;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SpeciesService {
    private List<Species> speciesList = new ArrayList<>(Arrays.asList(
            new Species("Cat", 20, false),
            new Species("Blue whale", 100, false),
            new Species("Dodo", 35, true)
    ));

    public List<Species> getAllSpecies(){
        return speciesList;
    }
    public Species getSpecies(String name){
        return speciesList.stream().filter(species -> species.getName().equals(name)).findFirst().get();
    }
    public void addSpecies(Species species){
        speciesList.add(species);
    }
    public void updateSpecies(String name, Species species){
        for(int i = 0; i < speciesList.size(); i++){
            Species s =speciesList.get(i);
            if (s.getName().equals(name)){
                speciesList.set(i, species);
                return;
            }
        }
    }
    public void deleteSpecies(String name){
        speciesList.removeIf(species -> species.getName().equals(name));
    }
}
