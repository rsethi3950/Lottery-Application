import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDbRepository {

    //object required to access this non-static method
    public void readFileAddToDb(String path){

        try{
            //read file
            BufferedReader br = new BufferedReader(new FileReader(path));

            //One way of reading the file
            String contentLine = br.readLine();
            while (contentLine != null) {

                String[] personContent= contentLine.split(" ");

                Person p=new Person(personContent[0], Integer.parseInt(personContent[1]), Integer.parseInt(personContent[2]), personContent[3], personContent[4]);

                MysqlConnect mysqlConnect = new MysqlConnect();
                String sql = "INSERT INTO person VALUES (?,?,?,?,?)";

                try{
                    PreparedStatement myst = mysqlConnect.connect().prepareStatement(sql);
                    myst.setString(1,p.name);
                    myst.setInt(2,p.lotteryNo);
                    myst.setInt(3,p.age);
                    myst.setString(4,p.city);
                    myst.setString(5,p.country);
                    myst.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                finally {
                    mysqlConnect.disconnect();
                }

                contentLine = br.readLine();
            }

        }//try block

        catch(IOException e){
            System.out.println(path);
            e.printStackTrace();
        }
    }

    public void findWinner(Integer lotteryInp) {
        MysqlConnect mysqlConnect= new MysqlConnect();
        String query= "SELECT * from (SELECT * from person WHERE lottery_No=?) as myalias ORDER BY AGE LIMIT 1";

        try{
            PreparedStatement myst= mysqlConnect.connect().prepareStatement(query);
            myst.setInt(1,lotteryInp);
            ResultSet rs=myst.executeQuery();
            while (rs.next()){
                System.out.println("winner is "+rs.getString(1));
            }
        }
        catch (SQLException e){
            e.printStackTrace();

        }
    }


}