import java.io.*;
import java.util.*;
public class MyFileReader{

    //object required to access this non-static method
    public List<Person> readFile(String path){
        List<Person> listOfPersons= new ArrayList<>();
        try{
            //read file
            BufferedReader br = new BufferedReader(new FileReader(path));

            //One way of reading the file
            String contentLine = br.readLine();
            while (contentLine != null) {

                String[] personContent= contentLine.split(" ");

                Person p=new Person(personContent[0], Integer.parseInt(personContent[1]), Integer.parseInt(personContent[2]), personContent[3], personContent[4]);

                listOfPersons.add(p);
                contentLine = br.readLine();
            }
            return listOfPersons;
        }//try block

        catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}