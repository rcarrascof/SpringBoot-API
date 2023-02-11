package RcxDev.example.superPos.Service;

import RcxDev.example.superPos.Entities.weight_unit;
import RcxDev.example.superPos.Repository.weightUnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class weightUnitsService {

    private final weightUnitRepository repository;
    public List<weight_unit> getWeightUnits(String searchText) {
        if(searchText.length()>1){
            return repository.getWeightUnits(searchText);
        }

        return repository.getWeightUnits();
    }
}
