import java.util.ArrayList;
import java.util.List;

public class SILab2 {

    public static List<String> function(List<String> list) { //1
        if (list.size() <= 0) { //2
            throw new IllegalArgumentException("List length should be greater than 0"); //3
        } //4
        int n = list.size(); //5
        int rootOfN = (int) Math.sqrt(n); //6
        if (rootOfN * rootOfN  != n) { //7
            throw new IllegalArgumentException("List length should be a perfect square"); //8
        }
        List<String> numMines = new ArrayList<>(); //9
        for (int i = 0; i < n; i++) { //10.1/10.2/10.3
            if (!list.get(i).equals("#")) { //11
                int num = 0; //12
                if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ) { //13
                    if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ){ //14
                        num += 2; //15
                    }
                    else { //16
                        num  += 1; //17
                    }
                } //18
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")){ //20
                    num++; //21
                }
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")){ //22
                    num++; //23
                }
                numMines.add(String.valueOf(num)); //24
            } //25
            else { //26
                numMines.add(list.get(i)); //27
            }
        } //28
        return numMines; //29
    } //30

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("#");
        list.add("0");
        list.add("#");
        list.add("0");
        list.add("#");
        list.add("0");
        list.add("#");
        list.add("#");
        list=function(list);
        for(int i=0;i<4;i++)
            System.out.println(list.get(i)+" ");
    }
}