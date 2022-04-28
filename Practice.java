import java.util.*;

// required for separate packages
//import MyFileReader;

public class Practice{

    public static void winner(List<Person> listOfPersons, Integer lottery){
        List<Person> winnerList= new ArrayList<>();
        int idx=-1;
        int minAge=10000;


        for(int i=0; i<listOfPersons.size(); i++){

            if (listOfPersons.get(i).lotteryNo== lottery){
                winnerList.add(listOfPersons.get(i));

                if (winnerList.size() >1 && listOfPersons.get(i).age<minAge){

                    minAge= listOfPersons.get(i).age;
                    idx=i;

                }
                // for first person with given lottery no.
                else{
                    minAge= listOfPersons.get(i).age;
                    idx=i;
                }
            }

        }// for ends
        if (idx==-1) System.out.println("No winner!");
        else System.out.println("Winner is "+listOfPersons.get(idx).name+" with age "+minAge);

    }

    public static void main(String[] args){

        System.out.println("Enter Lottery No.");
        Scanner sc= new Scanner(System.in);
        Integer lotteryInp= sc.nextInt();
//        MyFileReader fr= new MyFileReader();
//        List<Person> listOfPersons=fr.readFile("C://Users//riya//Work_Oracle//Java_practice//test.txt");
//        winner(listOfPersons,lotteryInp);

        // save to database once
        MyDbRepository dr= new MyDbRepository();
//        dr.readFileAddToDb("C://Users//riya//Work_Oracle//LotteryApp//test.txt");

        //retrieve from database
        dr.findWinner(lotteryInp);

    }
}
