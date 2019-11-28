package pecs.iths.java.alapok;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import itsh.java.alapok.vehicle.Vehicle;

public class CarMain {

	static String fileHelye = "C:\\DEV\\workspaces\\eclipse\\ProgAlapokJava\\JavaAlapok\\vehicles\\AttisVehicles.txt";

	public static void main(String[] args) {

		/*
		 * String nev = "Attila vagyok!"; int age = 39; double suly = 88.4, magassag =
		 * 112.4;
		 * 
		 * System.out.println(nev); System.out.println(age); System.out.println(suly);
		 * System.out.println(magassag);
		 */

		/*
		 * suzuki.setAlvazszam(85290064); suzuki.setManualisValto(Boolean.FALSE);
		 * suzuki.setMotor(1.4); suzuki.setRendszam("PRN-824");
		 * suzuki.setUzemanyag('B'); suzuki.setGyartasiev(2014);
		 */

		Car suzuki = new Car("PRN-824", 85290064, 1.4, Boolean.FALSE, 'B', LocalDate.of(2019, 11, 19));
		Car merci = new Car("ABC-123", 88854752, 1.4, Boolean.FALSE, 'B', LocalDate.of(2016, 10, 30));
		Car hyundai = new Car("OKL-111", 111111, 1.6, Boolean.TRUE, 'D', LocalDate.of(2013, 10, 30));
		Car renault = new Car("JKK-789", 9965255, 1.9, Boolean.TRUE, 'H', LocalDate.of(1980, 10, 30));
		Car chervolet = new Car("AAA-222", 741852, 1.1, Boolean.FALSE, 'G', LocalDate.of(2016, 10, 30));
		Car honda = new Car("CVF-741", 852221, 2.6, Boolean.TRUE, 'B', LocalDate.of(1520, 10, 30));
		Car nissan = new Car("UUH-854", 95147533, 1.4, Boolean.FALSE, 'D', LocalDate.of(1980, 10, 30));

		List<Car> autok = new ArrayList<>(); // Lista inicializálása

		autok.add(suzuki);
		autok.add(merci);
		autok.add(hyundai);
		autok.add(renault);
		autok.add(chervolet);
		autok.add(honda);
		autok.add(nissan);

		for (Car car : autok) {
			System.out.println(car);
		}

		// Fileba kiir
		saveCarToFile(autok);

		// beolvas
		readCarsFromFile();

	}

	public static List<Car> readCarsFromFile() {

		List<Car> felolvasottJarmuvekListaja = new ArrayList<Car>();

		try (BufferedReader olvaso = Files.newBufferedReader(Paths.get(fileHelye))) {

			String egysor = null;
			// 2. File felolvasása

			while ((egysor = olvaso.readLine()) != null) {

				// 3. Soronként Vehicle objektum készítése
				// egysor = "PRN-824,85290064,1.4,false,B,2019-11-19"
				//|"PRN-824"|"85290064"|"1.4"|"false"|"B"|"2019-11-19"|
				String[] aSorok = egysor.split(",");

				//"2019-11-19"
				String[] datumErtekek = aSorok[5].split("-");
				
				LocalDate datum = LocalDate.of(
								Integer.parseInt(datumErtekek[0]), //2019
								Integer.parseInt(datumErtekek[1]), //11
								Integer.parseInt(datumErtekek[2])); //19
				
				Car car = new Car(aSorok[0], //PRN-824
						Integer.parseInt(aSorok[1]), //85290064
						Double.parseDouble(aSorok[2]), 	//1.4
						Boolean.valueOf(aSorok[3]), //false
						aSorok[4].toCharArray()[0], //B
						datum);

				felolvasottJarmuvekListaja.add(car);
				System.out.println(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return felolvasottJarmuvekListaja;
	}

	public static void saveCarToFile(List<Car> flottaAutok) {

		try (BufferedWriter irogep = new BufferedWriter(new FileWriter(new File(fileHelye)))) {

			for (Car car : flottaAutok) {

				irogep.write(car.toString()); // egy auto kiirasa a fileba
				irogep.write("\n"); // soremelest csinal a fileban

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Én mindig lefutok!");
		}

	}

}
