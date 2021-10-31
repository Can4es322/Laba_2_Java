
public class Grade{

    private String _idMovie;
    private String _idCustomer;
    private String _grade;
    private String _data;

    public Grade(String idMovie, String idCustomer, String grade, String data){
        this._idMovie = idMovie;
        this._data = data;
        this._idCustomer = idCustomer;
        this._grade = grade;
    }

    public String getIdMovie() {
        return _idMovie;
    }
 
    public void setIdMovie(String idMovie) {
        this._idMovie = idMovie;
    }

    public String getIdCustomer() {
        return _idCustomer;
    }
 
    public void setIdCustomer(String idCustomer) {
        
        this._idCustomer = idCustomer;
    }

    public String getData() {
        return _data;
    }
 
    public void setData(String data) {
        
        this._data = data;
    }

    public String getGrade() {
        return _grade;
    }
 
    public void setGrade(String grade) {
        
        this._grade = grade;
    }

    

}
