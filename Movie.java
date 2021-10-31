
public class Movie {

    private String _name;
    private String _id;
    private String _year;

    public Movie(String id, String year, String name){
        this._name = name;
        this._id = id;
        this._year = year;
    }


    public String getName() {
        return _name;
    }
 
    public void setName(String name) {
        this._name = name;
    }

    public String getId() {
        return _id;
    }
 
    public void setId(String id) {
        
        this._id = id;
    }

    public String getYear() {
        return _year;
    }
 
    public void setYear(String year) {
        
        this._year = year;
    }

    
}
