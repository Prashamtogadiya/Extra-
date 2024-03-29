public class inter {
    public static void main(String[] args) {
        a a1= new a();
        // a []a1 ={new ()} ;
        ((b)a1).hel();
    }
}

class a implements b,c {
    
    public void hel(){
        // System.out.println("hii");
        
    }
}

interface b{
    public void hel();

    
}
interface c{
    public void hel();
}
