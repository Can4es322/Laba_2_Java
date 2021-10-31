import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;


import java.util.Map;




public class MovieManipulator{

    public String countGrades(int rangeReader) throws Exception{

        FileReader fr = new FileReader("combined_data_1.txt");
        Scanner scan = new Scanner(fr);
        String idMovie="";
        Grade _arrGrade[] = new Grade[rangeReader];
        int maxCount= 0;
        int count= 1;
        String idMax="";
        String id;

        for(Integer k=1;k<=4;k++){
            fr = new FileReader("combined_data_"+k.toString()+".txt");
            scan = new Scanner(fr);

            while(scan.hasNextLine()){
                int j=0;

                while(j<rangeReader && scan.hasNextLine()){

                    String str = scan.nextLine();
                    if(str.charAt(str.length()-1) == ':'){
                        idMovie = str.substring(0, str.length()-1);
                    }
                    else{
        
                        String words[] = str.split(",");
                        _arrGrade[j] = new Grade(idMovie, words[0], words[1],words[2]);
                        j++;
                    }
                }

                id=_arrGrade[0].getIdMovie();
                
                for(int i=1; i< j;i++){
                    
                    if(id.equals(_arrGrade[i].getIdMovie())){
                        count++;
                    }else{

                        if(maxCount<count){
                            maxCount=count;
                            idMax=id;
                        }
                        count=1;
                        id = _arrGrade[i].getIdMovie();
                    }
                }
            }
        }

        fr.close();
        scan.close();
        return idMax;
    }

    
    public int[] findingAverageRating(int rangeReader)throws Exception{

        FileReader fr = new FileReader("combined_data_1.txt");
        Scanner scan = new Scanner(fr);
        String idMovie="";
        Grade _arrGrade[] = new Grade[rangeReader];
        double sum1= 0;
        double count= 0;
        String id="1";
        double arrRating[]= new double[17770];

        for(Integer k=1;k<=4;k++){
            fr = new FileReader("combined_data_"+k.toString()+".txt");
            scan = new Scanner(fr);

            while(scan.hasNextLine()){
                int j=0;

                while(j<rangeReader && scan.hasNextLine()){

                    String str = scan.nextLine();
                    if(str.charAt(str.length()-1) == ':'){
                        idMovie = str.substring(0, str.length()-1);
                    }
                    else{
        
                        String words[] = str.split(",");
                        _arrGrade[j] = new Grade(idMovie, words[0], words[1],words[2]);
                        j++;
                    }
                }

                if(id.equals(_arrGrade[0].getIdMovie()) == false){
                    arrRating[Integer.valueOf(id)-1] = sum1 / count;
                    sum1=0;
                    count = 0;
                }

                id = _arrGrade[0].getIdMovie();

                for(Integer i=0; i<j;i++){

                    if(id.equals(_arrGrade[i].getIdMovie())){
                        double sum2 = Float.valueOf(_arrGrade[i].getGrade());
                        sum1 +=sum2;
                        count++;
                    }else{
                        arrRating[Integer.valueOf(id)-1] = sum1 / count;
                        sum1=0;
                        count = 0;
                        id = _arrGrade[i].getIdMovie();
                    }
                }

            }

        }
        arrRating[Integer.valueOf(id)-1] = sum1 / count;

        double maxSum=0;
        double minSum=6;
        int idMaxMin[]=new int[2];


        for(int z=0;z<arrRating.length;z++){
            if(maxSum<arrRating[z]){
                maxSum=arrRating[z];
                idMaxMin[0]=z;
            }

            if(arrRating[z]<minSum){
                minSum=arrRating[z];
                idMaxMin[1]=z;
            }
        }

        fr.close();
        scan.close();
        
        return idMaxMin;
    }
    
    public void searchIdCustomer(int rangeReader)throws Exception{

        FileReader fr = new FileReader("combined_data_1.txt");
        Scanner scan = new Scanner(fr);
        String idMovie="";
        Grade _arrGrade[] = new Grade[rangeReader];

        Map<String, Integer> customer = new LinkedHashMap<>();


        for(Integer k=1;k<=4;k++){
            fr = new FileReader("combined_data_"+k.toString()+".txt");
            scan = new Scanner(fr);

            while(scan.hasNextLine()){
                int j=0;

                while(j<rangeReader && scan.hasNextLine()){

                    String str = scan.nextLine();
                    if(str.charAt(str.length()-1) == ':'){
                        idMovie = str.substring(0, str.length()-1);
                    }
                    else{
                        String words[] = str.split(",");
                        _arrGrade[j] = new Grade(idMovie, words[0], words[1],words[2]);
                        j++;
                    }
                }
                
                for(int i=0; i<j; i++){
                    if(customer.containsKey(_arrGrade[i].getIdCustomer())){
                        customer.replace(_arrGrade[i].getIdCustomer(), customer.get(_arrGrade[i].getIdCustomer())+1);
                    }else{
                        customer.put(_arrGrade[i].getIdCustomer(), 1);
                    }
                }


            }

        }
         
        ArrayList<String> keys = new ArrayList<>(customer.keySet());
        ArrayList<Integer> values = new ArrayList<>(customer.values());
        int maxVal=0;
        int idKey=0;

        for(int z=0;z<values.size();z++){
            int tmp = values.get(z);

            if(maxVal<tmp){
                maxVal=tmp;
                idKey=z;
            }
        }

        System.out.println(maxVal);
        System.out.println(keys.get(idKey));

        fr.close();
        scan.close();
        
        //customer.entrySet().stream()
        //.sorted(Map.Entry.<String,Integer>comparingByValue().reversed());
    

        //List<String> customerKey = customerSort.keySet().stream().collect(Collectors.toList());
        //List<Integer> customerValue = customerSort.values().stream().collect(Collectors.toList());

        // for(int z=0;z<customerValue.size();z++){
        //     System.out.printf("%d ",customerValue.get(z));
        //     System.out.print(customerKey.get(z));
        //     System.out.printf("\n");
        // }
       

       // arrCustomer.put(customerKey.get(customerKey.size()-1), customerValue.get(customerValue.size()-1));

    }


    public int[] allTimeRating(int rangeReader)throws Exception{

        FileReader fr = new FileReader("combined_data_1.txt");
        Scanner scan = new Scanner(fr);
        String idMovie="";
        Grade _arrGrade[] = new Grade[rangeReader];
        int arrGrade[] = new int[5];
        


        for(Integer k=1;k<=4;k++){
            fr = new FileReader("combined_data_"+k.toString()+".txt");
            scan = new Scanner(fr);

            while(scan.hasNextLine()){
                int j=0;

                while(j<rangeReader && scan.hasNextLine()){

                    String str = scan.nextLine();
                    if(str.charAt(str.length()-1) == ':'){
                        idMovie = str.substring(0, str.length()-1);
                    }
                    else{
                        String words[] = str.split(",");
                        _arrGrade[j] = new Grade(idMovie, words[0], words[1],words[2]);
                        
                        switch (_arrGrade[j].getGrade()) {
                            case "1":
                                arrGrade[0]+=1;
                                break;
                            case "2":
                                arrGrade[1]+=1;
                                break;
                            case "3":
                                arrGrade[2]+=1;
                                break;
                            case "4":
                                arrGrade[3]+=1; 
                                break;
                            case "5":
                                arrGrade[4]+=1;
                                break;
                        }

                        j++;
                    }
                }
                

            }

        }
        fr.close();
        scan.close();

        return arrGrade;
    }





    public void seacrhTenEvilCustomer(int rangeReader)throws Exception {
        FileReader fr = new FileReader("combined_data_1.txt");
        Scanner scan = new Scanner(fr);
        String idMovie="";
        Grade _arrGrade[] = new Grade[rangeReader];
        double sum1= 0;
        double count= 0;
        String id="1";
        double arrRating[]= new double[17770];

        for(Integer k=1;k<=4;k++){
            fr = new FileReader("combined_data_"+k.toString()+".txt");
            scan = new Scanner(fr);

            while(scan.hasNextLine()){
                int j=0;

                while(j<rangeReader && scan.hasNextLine()){

                    String str = scan.nextLine();
                    if(str.charAt(str.length()-1) == ':'){
                        idMovie = str.substring(0, str.length()-1);
                    }
                    else{
        
                        String words[] = str.split(",");
                        _arrGrade[j] = new Grade(idMovie, words[0], words[1],words[2]);
                        j++;
                    }
                }

                if(id.equals(_arrGrade[0].getIdMovie()) == false){
                    arrRating[Integer.valueOf(id)-1] = sum1 / count;
                    sum1=0;
                    count = 0;
                }

                id = _arrGrade[0].getIdMovie();

                for(Integer i=0; i<j;i++){

                    if(id.equals(_arrGrade[i].getIdMovie())){
                        double sum2 = Float.valueOf(_arrGrade[i].getGrade());
                        sum1 +=sum2;
                        count++;
                    }else{
                        arrRating[Integer.valueOf(id)-1] = sum1 / count;
                        sum1=0;
                        count = 0;
                        id = _arrGrade[i].getIdMovie();
                    }
                }

            }

        }
        arrRating[Integer.valueOf(id)-1] = sum1 / count;
        scan.close();
        fr.close();

        ArrayList<String> arrHightFilms = new ArrayList<>();

        for( Integer z=0;z<arrRating.length;z++){
            
            if(arrRating[z]>=4){
                arrHightFilms.add(z.toString());
            }
        }
        
        Map<String,Integer> idEvilCustomer = new LinkedHashMap<>();
        boolean flag = false;

        for (int q=0;q<arrHightFilms.size();q++) {
            for(Integer k=1;k<=4;k++){
                fr = new FileReader("combined_data_"+k.toString()+".txt");
                scan = new Scanner(fr);
                
                while(scan.hasNextLine()){
                    if(q >= arrHightFilms.size()){
                        flag=true;
                        break;
                    }

                    String str = scan.nextLine();
                    if(str.charAt(str.length()-1) == ':'){
                        idMovie = str.substring(0, str.length()-1);
                    } 

                    while((arrHightFilms.get(q).equals(idMovie)) && scan.hasNextLine()){
                        
                        str = scan.nextLine();
                        if(str.charAt(str.length()-1) == ':'){
                            idMovie = str.substring(0, str.length()-1);
                            q++;
                            break;
                        }
                        String words[] = str.split(",");
                        
                        if(Integer.valueOf(words[1]) < 3){
                            if(idEvilCustomer.containsKey(words[0])){
                                idEvilCustomer.replace(words[0], idEvilCustomer.get(words[0])+1);
                            }else{
                                idEvilCustomer.put(words[0], 1);
                            }
                        }
                        
                    }

                }
                if(flag){
                    break;
                }
            }
        }

        ArrayList<String> keys = new ArrayList<>(idEvilCustomer.keySet());
        ArrayList<Integer> values = new ArrayList<>(idEvilCustomer.values());

        for(int x=1;x<values.size();x++){
            for(int y=0;y<values.size()-x;y++){
                if(values.get(y) > values.get(y+1)){

                    int t = values.get(y);
                    values.set(y, values.get(y+1));
                    values.set(y+1, t);

                    String tt = keys.get(y);
                    keys.set(y, keys.get(y+1));
                    keys.set(y+1, tt);
                }
            }
        }

        for(int p=1;p<=10;p++){
            System.out.println(keys.get(keys.size()-p));
            System.out.println(values.get(values.size()-p));
        }
    }



    
}
    