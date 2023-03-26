import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    
    public static void main(String[] args) throws Exception {
		List<turn> session = new ArrayList<>();
		List<turn> output=new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File("inputs/game_data_1.txt"));
			final Pattern pattern = Pattern.compile("[0-9]+,[0-9]+,[0-9]+,[A-Za-z// ]+,[A-Za-z0-9-?]+,[A-Za-z0-9-]+", Pattern.CASE_INSENSITIVE);
			while (scanner.hasNextLine()) {
				final Matcher matcher = pattern.matcher(scanner.nextLine());
					if (matcher.matches()){
					String[] line =scanner.nextLine().split(",");
					turn turn = new turn( Integer.parseInt(line[0]),Integer.parseInt(line[1]),Integer.parseInt(line[2]),line[3],line[4],line[5]);
					session.add(turn);	
				}

			}
			Collections.sort(session, new SortByTime());
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (NumberFormatException e){}
		Collections.sort(session, new SortByTime());

		for (int i = 0; i < session.size(); i++) {
			turn currentTurn=session.get(i);
		if (currentTurn.ValidateHand()){
			//all good

		}
		else{
			output.add(currentTurn);
			if (session.removeIf(n ->(n.gameid==currentTurn.gameid))){

			}
		}
		}
		Collections.sort(output, new SortById());  
		for (turn turn : output) {

			System.out.println(turn.toString());
			
			}
	}

}

    

