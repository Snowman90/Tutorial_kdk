package pl.wojtektutorial.koty;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.wojtektutorial.koty.domain.Kot;


@Repository
public class KotDAO {

	public List<Kot> koty = new ArrayList<Kot>();
	
	public void dodajKota (Kot kot)
	{
			koty.add(kot);
			System.out.println("Kot dodany");
	}
	
	public List<Kot> getKoty()
	{
		return koty;
	}
	
	public Kot getKotById(Integer id) {
		if (id<koty.size()) {
			return koty.get(id);
		} else {
			return null;
		}
	}
	
}
