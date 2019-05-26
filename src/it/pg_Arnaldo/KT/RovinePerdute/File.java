package it.pg_Arnaldo.KT.RovinePerdute;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.stream.*;


public class File
{
	ArrayList <Città> citta = new ArrayList <Città>();
	XMLInputFactory xmlif = null;
	XMLStreamReader xmlr = null;
	private int numCitta = 0;		//contatore per gestire la creazione di città
	private int numTotCitta = 0;


	public File ()		// COSTRUTTORE File
	{

		try
		{
			xmlif = XMLInputFactory.newInstance();
			xmlr = xmlif.createXMLStreamReader("PgAr_Map_5.xml", new FileInputStream("PgAr_Map_5.xml"));
		}
		catch (Exception e)
		{
			System.out.println("Errore nell'inizializzazione del reader");
			System.out.println(e.getMessage());
		}
		scansioneCitta();		// avvio la scansione del file con questo metodo



		PercorsOttimale p1= new PercorsOttimale();
		VeicoloMet vm1=new VeicoloMet();
		VeicoloTon vt1=new VeicoloTon();


		p1.trovaMigliore(vm1);

		p1.trovaMigliore(vt1);

		scritturaFile();

	}

	private void scansioneCitta () // metodo che si occupa di leggere i dati nel file e riempire l'arrayList
	{
		try
		{
			while (xmlr.hasNext())
			{
				switch (xmlr.getEventType())
				{

					case XMLStreamConstants.START_ELEMENT:
						creazioneCitta (xmlr.getLocalName(), xmlr);
						break;
					case XMLStreamConstants.COMMENT:
						break;
					case XMLStreamConstants.CHARACTERS:
						break;
					default:

				}
				xmlr.next();
			}
		}
		catch (Exception e)
		{
			System.out.println("Errore nella lettura file");
			System.out.println(e.getMessage());
		}
	}

	private void creazioneCitta(String valore, XMLStreamReader xmlr)
	{
		int x = 0;
		int y = 0;
		int h = 0;
		String nome = "";
		int id = 0;



		switch (valore)
		{
			case "city":
				for (int i = 0; i < xmlr.getAttributeCount(); i++)
				{
					switch (xmlr.getAttributeLocalName(i)) // switch per attribuire i valori degli attributi alle variabili
					{
					case "id":
						id = Integer.valueOf(xmlr.getAttributeValue(i));
						break;
					case "name":
						nome = xmlr.getAttributeValue(i);
						break;
					case "x":
						x = Integer.valueOf(xmlr.getAttributeValue(i));
						break;
					case "y":
						y = Integer.valueOf(xmlr.getAttributeValue(i));
						break;
					case "h":
						h = Integer.valueOf(xmlr.getAttributeValue(i));
						break;

					}
				}

				citta.add(new Citta(x,y,h,id,nome));	// creazione citta con i dati appena ottenuti

				numCitta++; //contatore numero citta aumentato
				try
				{
					do
					{
						if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT)
						{
							if (xmlr.getLocalName() == "link")
							{
								for (int j = 0; j < xmlr.getAttributeCount(); j++)	// ciclo per ottenere le località che si possono raggiungere
								{
									citta.get(numCitta-1).addArrivo(xmlr.getAttributeValue(j));
								}
							}
						}

						xmlr.next();

					} while (!(xmlr.isEndElement() && xmlr.getLocalName().equals("city")));	// condizione per ottenere tutti i valori di link
				}
				catch (Exception e)
				{
					System.out.println("Errore nella lettura file");
				}
				break;
			case "map":
				// inserire metodo per lettura numero totale citta
				break;

		}
	} // fine metodo scansione Città

	public void scritturaFile ()
	{
		XMLOutputFactory xmlof = null;
		XMLStreamWriter xmlw = null;

		try
		{
			xmlof = XMLOutputFactory.newInstance();
			xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("Routes.xml"), "utf-8");
			xmlw.writeStartDocument("utf-8", "1.0");
		}
		catch (Exception e)
		{
			System.out.println("Errore nell'inizializzazione della scrittura file");
		}

		try
		{

			xmlw.writeStartElement("routes");
			xmlw.writeStartElement("route");

			// impostazione tag di apertura per veicolo Metztli
			xmlw.writeAttribute("team", "Metztli");
			xmlw.writeAttribute("cost", "Metztli");
			xmlw.writeAttribute("cities", String.valueOf(vm1.getPercorsoOtt().size())); // numero citta attraversate

			for (int i = 0; i < vm1.getPercosoOtt().size(); i++) // ciclo per Metztli
			{
				xmlw.writeStartElement("city");
				xmlw.writeAttribute("id", String.valueOf(vm1.getPercosoOtt().get(i).getId));
				xmlw.writeAttribute("name", vm1.getPercosoOtt().get(i).getNome());
				xmlw.writeEndElement();
			}
			xmlw.writeEndElement();

			// impostazione tag di apertura per veicolo Tonatiuh
			xmlw.writeStartElement("route");	// dati Veicolo	Tonatiuh
			xmlw.writeAttribute("team", "Tonatiuh");
			xmlw.writeAttribute("cost", "Tonatiuh");
			xmlw.writeAttribute("cities", String.valueOf(vt1.getPercorsoOtt().size()));		// numero citta attraversate
			for (int i = 0; i < vt1.getPercorsoOtt().size(); i++)		// ciclo per Tonatiuh
			{
				xmlw.writeStartElement("city");
				xmlw.writeAttribute("id", String.valueOf(vt1.getPercosoOtt().get(i).getId));
				xmlw.writeAttribute("name", vt1.getPercosoOtt().get(i).getNome());
				xmlw.writeEndElement();
			}
			xmlw.writeEndElement();
			xmlw.writeEndElement();	// chiusura TAG "routes"
			// comandi di chiusura
			xmlw.writeEndDocument();
			xmlw.flush();
			xmlw.close();


		}
		catch (Exception e)
		{
			System.out.println("Errore nella scrittura file");
		}
	}

}
