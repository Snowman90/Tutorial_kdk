package pl.wojtektutorial.koty;

import java.util.ArrayList;
import java.util.List;

import pl.wojtektutorial.koty.domain.Kot;

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
	
}
