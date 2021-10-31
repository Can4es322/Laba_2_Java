import java.io.FileReader;
import java.util.Scanner;

public class MovieAndGradeReader{

    
    Movie _arrMovies[] = new Movie[17770];

    public Movie[] readsMovies() throws Exception{

        FileReader fr = new FileReader("movie_titles.txt");
        Scanner scan = new Scanner(fr);
        int i=0;

        while(scan.hasNextLine()){

            String str = scan.nextLine();
            String []words = str.split(",");
            _arrMovies[i] = new Movie(words[0],words[1],words[2]);
            i++;
        }

        fr.close();
        scan.close();

        return _arrMovies;
    }
  

}