package SMS;
import java.util.*;
class item
{
    String item_code, item_name;
    int item_quantity;
    float item_rate;
    public void add_item(int order)
    {
         String code;
         Scanner sc=new Scanner(System.in);
         if (item_name.length() > 3) 
         {
            code = item_name.substring(0, 3);
         } 
         else
         {
            code = item_name;
         }
         code=code.toUpperCase();
         if(order<10)
         {
             item_code=code+"00"+order;
         }
         else
         {
             item_code=code+"0"+order;
         }
         System.out.println("\nItem code : "+item_code);
         System.out.println("\nEnter rate of item :");
         item_rate=sc.nextFloat();
         System.out.println("Enter quantity of item :");
         item_quantity=sc.nextInt();
    }
    public void change_rate()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\nPrevious rate : "+item_rate);
        System.out.println("\nEnter new rate : ");
        item_rate=sc.nextFloat();
        System.out.println("Rate updated");
    }
    public void issue_item()
    {
        int issue=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("\nHow many "+item_name+"  are to be issued??");
        issue=sc.nextInt();
        if(issue>item_quantity)
            System.out.println("Only "+item_quantity+" available in stock.");
        else
            item_quantity=item_quantity-issue;
    }
    public void recieve_item()
    {
        int recieve=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("\nHow many "+item_name+"  are to be recieved??");
        recieve=sc.nextInt();
        item_quantity=item_quantity+recieve;
    }
    public void display()
    {
        System.out.println(item_code+"\t\t"+item_name+"\t\t"+item_quantity+"\t\t"+item_rate);   
    }
    public void display_filter()
    {
    	
    }
}

public class Shop_Management_System
{
    public static void main(String args[])
    {
        item it[]=new item[100];
        for(int i=0;i<100;i++)
        {
            it[i]=new item();
        }
        int ch, item_count=0;
        String PassSEO="SEOAdmin";
        String PassSK="SKAdmin";
        Scanner sc=new Scanner(System.in);
        char mm='y';
        int p_try=0,flag=0;
        String i_code;
        int f=0;
        do
        {
            System.out.println("---------------MENU---------------\n");
            System.out.println("1.SEO\n2.SK\n");
            System.out.println("----------------------------------\n");
            System.out.println("Enter your choice");
            ch=sc.nextInt();
            sc.nextLine();
            p_try=0;
            switch(ch)
            {
                case 1:
                    do
                    {
                        String pass=new String();
                        System.out.println("Enter password :");
                        
                        pass=sc.nextLine();
                        if(pass.equals(PassSEO))
                        {
                           p_try=3;
                           char c='y';
                           do
                           {
                               int choice;
                               f=0;
                               flag=0;
                               System.out.println("-------------SEO MENU-------------\n"); 
                               System.out.println("1. Register New Item\n");
                               System.out.println("2. Change Rate Of Item\n");
                               System.out.println("3. Issue Item\n");
                               System.out.println("4. Recieve Item\n");
                               System.out.println("5. Item Details\n");
                               System.out.println("6. Display All Items\n");
                               System.out.println("7. Display Items based on price\n");
                               System.out.println("----------------------------------\n");
                               System.out.println("Enter your choice :");
                               choice=sc.nextInt();
                               sc.nextLine();
                               switch(choice)
                               {
                                   case 1:
                                      String i_name;
                                      System.out.println("\nEnter name of item");
                                      i_name=sc.nextLine();
                                      for(int j=0;j<item_count;j++)
                                      {

                                          String str1;
                                          str1=it[j].item_name;
                                          if(i_name.equalsIgnoreCase(str1))
                                          {    
                                              flag=1;
                                              break;
                                          }
                                      }
                                      if(flag==1)
                                      {
                                          System.out.println("Item already exists. Update quantity.\n");
                                      }
                                      else
                                      {
                                          it[item_count].item_name=i_name;
                                          it[item_count].add_item(item_count);
                                          item_count++;
                                          for(int i=0;i<(item_count-1);i++)
                                          {
                                              for(int j=i+1;j<item_count;j++)
                                              {
                                                  if(it[i].item_code.compareTo(it[j].item_code)>0)   
                                                  {    
                                                        item temp = new item(); 
                                                        temp=it[i];  
                                                        it[i] = it[j];  
                                                        it[j] = temp;
                                                  }
                                              }
                                          }
                                      }
                                      break;
                                   case 2:
                                       System.out.println("Enter Item Code to issue :");
                                       i_code=sc.nextLine();
                                       for(int i=0;i<item_count;i++)
                                       {
                                           if(i_code.equals(it[i].item_code))
                                           {
                                               it[i].change_rate();
                                               f=1;
                                               break;
                                           }
                                           
                                       }
                                       if(f!=1)
                                               System.out.println("No such item exists");
                                       break;
                                   case 3:
                                       System.out.println("Enter Item Code to recieve :");
                                       i_code=sc.nextLine();
                                       for(int i=0;i<item_count;i++)
                                       {
                                           if(i_code.equals(it[i].item_code))
                                           {
                                               it[i].issue_item();
                                               f=1;
                                               break;
                                           }
                                           
                                       }
                                       if(f!=1)
                                               System.out.println("No such item exists");
                                       break;
                                   case 4:
                                       System.out.println("Enter Item Code to update :");
                                       i_code=sc.nextLine();
                                       for(int i=0;i<item_count;i++)
                                       {
                                           if(i_code.equals(it[i].item_code))
                                           {
                                               it[i].recieve_item();
                                               f=1;
                                               break;
                                           }
                                           
                                       }
                                       if(f!=1)
                                               System.out.println("No such item exists");
                                       break;
                                   case 5:
                                       System.out.println("Enter Item Code to update :");
                                       i_code=sc.nextLine();
                                       for(int i=0;i<item_count;i++)
                                       {
                                           if(i_code.equals(it[i].item_code))
                                           {
                                               System.out.println("Item Code\tItem Name\tQuantity\tRate");
                                               it[i].display();
                                               f=1;
                                               break;
                                           }
                                           
                                       }
                                       if(f!=1)
                                               System.out.println("No such item exists");
                                       break;
                                   case 6:
                                       System.out.println("Item Code\tItem Name\tQuantity\tRate");
                                       for(int i=0;i<item_count;i++)
                                       {
                                           it[i].display();
                                       }
                                       break;
                                   case 7:
                                	   float p;
                                	   System.out.println("Enter price:");
                                	   p=sc.nextFloat();
                                	   System.out.println("Item Code\tItem Name\tQuantity\tRate");
                                       for(int i=0;i<item_count;i++)
                                       {
                                           if(it[i].item_rate<p)
                                        	   it[i].display();
                                       }
                                       break;
                                   default:
                                       System.out.println("Wrong choice!!");
                               }
                               System.out.println("Want to do more operations?(y/n) : ");
                               c=sc.next().charAt(0);
                               sc.nextLine();
                           }while(c=='y'||c=='Y');
                        }
                        else
                        {
                            p_try++;
                            System.out.println("Wrong password!!! "+(3-p_try)+" attempts left!!");
                        }
                    }while(p_try<3);
                    break;
                case 2 :
                    do
                    {
                        p_try=0;
                        String pass=new String();
                        System.out.println("Enter password :");
                        pass=sc.nextLine();
                        if(pass.equals(PassSK))
                        {
                           p_try=3;
                           char c='y';
                           do
                           {
                               int choice;
                               f=0;
                               flag=0;
                               System.out.println("-------------SK MENU--------------\n"); 
                               System.out.println("1. Issue Item\n");
                               System.out.println("2. Recieve Item\n");
                               System.out.println("3. Item Details\n");
                               System.out.println("4. Display All Items\n");
                               System.out.println("----------------------------------\n");
                               System.out.println("Enter your choice :");
                               choice=sc.nextInt();
                               sc.nextLine();
                               switch(choice)
                               {
                                   case 1:
                                       System.out.println("Enter Item Code to issue :");
                                       i_code=sc.nextLine();
                                       for(int i=0;i<item_count;i++)
                                       {
                                           if(i_code.equals(it[i].item_code))
                                           {
                                               it[i].issue_item();
                                               f=1;
                                               break;
                                           }
                                           
                                       }
                                       if(f!=1)
                                               System.out.println("No such item exists");
                                       break;
                                   case 2:
                                       System.out.println("Enter Item Code to recieve :");
                                       i_code=sc.nextLine();
                                       for(int i=0;i<item_count;i++)
                                       {
                                           if(i_code.equals(it[i].item_code))
                                           {
                                               it[i].recieve_item();
                                               f=1;
                                               break;
                                           }
                                        
                                       }
                                       if(f!=1)
                                               System.out.println("No such item exists");
                                       break;
                                   case 3:
                                       System.out.println("Enter Item Code to Display :");
                                       i_code=sc.nextLine();
                                       for(int i=0;i<item_count;i++)
                                       {
                                           if(i_code.equals(it[i].item_code))
                                           {
                                               System.out.println("Item Code\tItem Name\tQuantity\tRate");
                                               it[i].display();
                                               f=1;
                                               break;
                                           }
                                       }
                                       if(f!=1)
                                               System.out.println("No such item exists");
                                       break;
                                   case 4:
                                       System.out.println("Item Code\tItem Name\tQuantity\tRate");
                                       for(int i=0;i<item_count;i++)
                                       {
                                           it[i].display();
                                       }
                                       break;
                                   default:
                                       System.out.println("Wrong choice!!");
                               }
                               System.out.println("Want to do more operations?(y/n) : ");
                               c=sc.next().charAt(0);
                               sc.nextLine();
                           }while(c=='y'||c=='Y');
                        }
                        else
                        {
                            p_try++;
                            System.out.println("Wrong password!!! "+(3-p_try)+" attempts left!!");
                        }
                    }while(p_try<3);
                    break;
                default :
                    System.out.println("Wrong choice!!");
            }
            System.out.println("Want to go to Main Menu?(y/n) : ");
            mm=sc.next().charAt(0);
            sc.nextLine();
        }while(mm=='y'||mm=='Y');
    }
}
