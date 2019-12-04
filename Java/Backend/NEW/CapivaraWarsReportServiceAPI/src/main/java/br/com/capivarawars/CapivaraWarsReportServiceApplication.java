package br.com.capivarawars;

//<editor-fold defaultstate="collapsed" desc="imports...">
import br.com.capivarawars.database.model.ReadFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 Last update: -
 *///</editor-fold>
@SpringBootApplication
public class CapivaraWarsReportServiceApplication {
	static String fileName = "PlayerData";
		
	public static void main(String[] args) {
		SpringApplication.run(CapivaraWarsReportServiceApplication.class, args);

		System.out.println(
				"\n\n"
				+ "         ^_^      _______    \n"
				+ "  .-----/  0\\    (_______)   \n"
				+ " /  \\     __/    | MONGO | \n"
				+ " \\  /_- -/       (_______)   \n"
				+ "  \\\\\\  \\\\\\           \n"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				+ " >>> NOW, RUNNING A " + CapivaraWarsReportServiceApplication.class.getSimpleName() + " ON A RIVER API ;)\n"
		);
		System.out.println(ReadFile.readFile(fileName));
	}

}
