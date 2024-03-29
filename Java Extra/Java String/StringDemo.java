public class StringDemo{
    public static void main(String[] args) {
        String  str = "darshan college Rajkot "; 
        int index = str.indexOf('a');
        while(index!=-1){
            System.out.println(index);
            index = str.indexOf('a',index+1);
        }
    }
}