package practice.fruit_shop;
import java.lang.*;
import java.util.*;

class Fruit_detail{
    public int quantity;
    
    public String name;
    Fruit_detail(){
        
    }
   
    Fruit_detail(int quantity, String name)
    {
       this.quantity = quantity;
       this.name = name;}
    
    
}
abstract class Admin { // parent class
    private String name1;
    private int ID;
    public void setID(int ID){
        this.ID=ID;
    }
    public int getID(){
        return ID;
    }
    public void setname1(String name1){
        this.name1=name1;
    }
     public String getname1(){
       return name1;
    } 
    abstract void design();
}
public class Fruit_Shop extends Admin{
    Scanner obj=new Scanner(System.in);
    Scanner obj1=new Scanner(System.in);
    int i;
    @Override
    void design(){             
         System.out.println("\n============================================================");
         System.out.println("---------Welcome to the Fruit Shop software---------");
         System.out.println("============================================================\n");
    //return "\n============================================================\n----------------------Welcome to the Fruit Shop management software----------------------\n============================================================\n";
    }
    
    void choise(Fruit_detail arr[],Fruit_Shop a){
        System.out.println("------------------------------------------------------------\n");
        System.out.println("Proceed with\n1. Add Fruit\n2. Buy Fruit\n3. Display Fruit");
        int chs=obj.nextInt();//add or borrow
        if(chs==1){
            System.out.println("Choose Serial from fruit list you want to add");
        int ok=obj.nextInt();//for which index
        System.out.println("How many fruits you want to add?");
        int ok1=obj1.nextInt();
            a.add_fruit(arr,ok,ok1,a);
            a.main_exit(arr,a);
        }
        else if(chs==2){
            System.out.println("Choose Serial from fruits list you want to buy");
        int ok=obj.nextInt();//for which index
        System.out.println("How many fruits you want to buy?");
        int ok1=obj.nextInt();
            a.sell_fruit(arr, ok,ok1);
            a.main_exit(arr,a);
        }
        else{
            a.display_fruit(arr,a);
            a.main_exit(arr,a);
        }
    }
    void add_fruit(Fruit_detail arr[],int ok,int ok3,Fruit_Shop a){
        for ( i = 0; i < arr.length; i++){
            if(i==ok){
                arr[i].quantity+=ok3;}
            else{
                System.out.println("Please provide correct serial no.");
                a.main_exit(arr,a);
            }
         }
       System.out.println("Successfully added in the fruits list");
    }
    void sell_fruit(Fruit_detail arr[],int ok,int ok1){
        for ( i = 0; i < arr.length; i++){
            if(i==ok){
                if(0<arr[i].quantity && arr[i].quantity>=ok1){
                arr[i].quantity-=ok1;
                System.out.println("Fruits Buyed Successfully");
                }
                else{
                System.out.println("The fruit "+arr[i].name+" have only "+arr[i].quantity+ " now");
                }
                }
            }
    }  
    void display_fruit(Fruit_detail arr[],Fruit_Shop a){
        System.out.println("\n------------------------------------------------------------");
        System.out.println("   Serial         Quantity           Fruit Name");
        System.out.println("------------------------------------------------------------");
        for (i = 0; i < arr.length; i++){
           System.out.println("    "+ i + "  :            " + arr[i].quantity+ "              "+ arr[i].name);
        }
        System.out.println("------------------------------------------------------------\n");   
    }

    void main_exit(Fruit_detail arr[],Fruit_Shop a){
         System.out.println("Press 1 or 2 for following process\n1. Main Menu\n2. Exit");
            int lop=obj.nextInt();
            if(lop==2){
                System.out.println("\n**Thanks "+a.getname1()+" for being with us\n\n");
                System.exit(0);
            }
            else{
                a.choise(arr,a);
            }
    }

    public static void main(String[] args)
    {
        Fruit_Shop a=new Fruit_Shop();
        int i;
        Scanner obj=new Scanner(System.in);
        Fruit_detail[] arr;
        arr = new Fruit_detail[5];
        arr[0] = new Fruit_detail(1, "Mango");
        arr[1] = new Fruit_detail(2, "Apple");
        arr[2] = new Fruit_detail(0, "Banana");
        arr[3] = new Fruit_detail(4, "Orange");
        arr[4] = new Fruit_detail(5, "Avocado");
        System.out.println("Enter Your Name:");
        String nam=obj.nextLine();
        System.out.println("Enter Your code:");
        int id=obj.nextInt();
        a.setID(id);
        a.setname1(nam);
        a.design();
        System.out.println("Your Name is: "+a.getname1()+"\nYour code is: "+a.getID());
        a.choise(arr,a);
        }
}
 