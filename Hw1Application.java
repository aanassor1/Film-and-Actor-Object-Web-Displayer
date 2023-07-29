package mainPackage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mainPackage.domain.Actor;
import mainPackage.domain.Film;

@SpringBootApplication
public class Hw1Application implements CommandLineRunner {
	
	public static List<Film> films;
	
	public static void main(String[] args) {
		SpringApplication.run(Hw1Application.class, args);
	}
	
	public void run(String... args) {
		films = new ArrayList<>();
		List<Actor> Actors = new ArrayList<>();

		Film f = new Film();
		f.setId(1);
		f.setTitle("Wild Aid: Leonardo DiCaprio and Jackie Chan");
		f.setSetting("This is set in the great wilderness of the jungles of China.");
		
		Actor a = new Actor();
		a.setName("Leonadro Dicaprio");
		a.setAgent("Rick Yorn");
		a.setLanguage("English");
		a.setAge(47);
		Actors.add(a);
		
		a = new Actor();
		a.setName("Jackie Chan");
		a.setAgent("Willie Chan Chi-Keung");
		a.setLanguage("English");
		a.setAge(67);
		Actors.add(a);
		
		f.setActors(Actors);
		films.add(f);
	}
}
