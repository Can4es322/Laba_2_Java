import java.util.Map;
import java.util.HashMap;

public class Main{


    public static void main(String[] args) throws Exception {
        
        MovieManipulator manipulator = new MovieManipulator();
        MovieAndGradeReader reader = new MovieAndGradeReader();
        Movie arrMovies[];
        int idMaxMin[];
        int arrGrade[]=new int[5];

       // manipulator.seacrhTenEvilCustomer(10);
        
        //arrGrade = manipulator.allTimeRating(10);
        manipulator.searchIdCustomer(10);

        // первый элемент высокий рейтинг, второй низкий

        idMaxMin = manipulator.findingAverageRating(5);
        arrMovies = reader.readsMovies();

        System.out.println(arrMovies[idMaxMin[0]].getName());
        System.out.println(arrMovies[idMaxMin[1]].getName());

        String idFilm = manipulator.countGrades(10);
        Integer id = Integer.valueOf(idFilm);
        System.out.println(arrMovies[id-1].getName());





    }

}