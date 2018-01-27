package pl.wojtektutorial.koty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pl.wojtektutorial.koty.domain.Kot;

public class Interfejs {
	
	static Scanner sc = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	static KotDAO listaKotow = new KotDAO();

	public static void main(String[] args) {
		
		
		
		
		System.out.println("******************PROGRAM KOTY v1******************");
		
		
		
		String wyborUzytkownika;
		do
		{
			
			System.out.println("Wybierz opcje:");
			System.out.println("[1] Dodaj kota"
					+ "\n" + "[2] Poka¿ koty"
					+ "\n" + "[x] Zakoñcz program");
			
			
			wyborUzytkownika = getUserInput();
			
			if(wyborUzytkownika.equals("1"))
				dodajKota();
			else if(wyborUzytkownika.equals("2"))
				pokazKoty();
			else
				if(!wyborUzytkownika.equals("x"))
					System.out.println("Niedostepna opcja");
		}while(!wyborUzytkownika.equals("x"));
		System.out.println("koniec programu");
	
		}
	
	static public void pokazKoty()
	{
		System.out.println("*************POKA¯ KOTA*************");
		
		
		if(listaKotow.getKoty().size()==0)
		{
			System.out.println("Brak kotow w bazie");
		
		}
		else
		{
		
			Kot kot;
			for(int i=0; i<listaKotow.getKoty().size();i++)
			{
				kot = listaKotow.getKoty().get(i);
				System.out.println(i + ": "+ kot.getImie());
			}
			Pattern kotPattern = Pattern.compile("[0-9]+");
			
			String numerKota;
			do
			{		
				System.out.println("Ktorego kota chcesz blizej poznac?");
				numerKota = getUserInput();
							
			}	while (!kotPattern.matcher(numerKota).matches());
			
			Integer numerWybranegoKota = Integer.parseInt(numerKota);
			if(numerWybranegoKota<listaKotow.getKoty().size())
			{
				Kot wybranyKot = listaKotow.getKoty().get(numerWybranegoKota);
				System.out.println("Wybrany kot ma na imie "+wybranyKot.getImie()+", wa¿y "+wybranyKot.getWaga()+", urodzi³ siê "+wybranyKot.getDataUrodzenia().toString()+", a opiekuje siê nim "+wybranyKot.getImieOpiekuna());
			}
			else
				System.out.println("Nie ma takiego kota w bazie");
		}
	}
	
	
	static public void dodajKota() 
	{
	
	
		System.out.println("*************DODAJ KOTA*************");
		Kot kot = new Kot();
		
	
		System.out.println("Podaj imie kota");
		kot.setImie(getUserInput());
	
		
		System.out.println("Podaj imie opiekuna");
		kot.setImieOpiekuna(getUserInput());
		
		
		Pattern dataPattern = Pattern.compile("[12]{1}[0-9]{3}.[0-1]?[0-9].[0-3]?[0-9]");
		Pattern wagaPattern= Pattern.compile("[0-9]+(\\.[0-9]+)?");		
		
			
		String dataUrodzeniaWczytana;
		do
		{
			System.out.println("Podaj Date urodzenia w formacie RRRR.MM.DD");
			dataUrodzeniaWczytana = getUserInput();
			Matcher matcher = dataPattern.matcher(dataUrodzeniaWczytana);
			if(matcher.matches())
			{
				try
				{
					kot.setDataUrodzenia(sdf.parse(dataUrodzeniaWczytana));
				}
				catch (ParseException pe) 
				{
					System.out.println("Coœ jest nie tak z formatem daty!");
				}
				
			}
			//else System.out.println("Zly format daty, sprobuj ponownie");
			
		}
		while (kot.getDataUrodzenia()==null);
		
		
		String wagaWczytana;
		do
		{
			System.out.println("Podaj wage kota");
			wagaWczytana = getUserInput();
			Matcher matcher2 = wagaPattern.matcher(wagaWczytana);
			
			if(matcher2.matches())
				kot.setWaga(Float.valueOf(wagaWczytana));
			else
				System.out.println("Zly format wagi");
		}
		while(kot.getWaga()==0);
		
		
		
		//System.out.println(kot.przedstawSie());
		listaKotow.dodajKota(kot);
		
		//System.out.println("Mamy wszystko");
	}
	
	public static String getUserInput() {
		return sc.nextLine();
	}

}
