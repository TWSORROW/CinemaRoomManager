package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();
        
        int totalSeats = rows * columns;
        int income = 0;
        int purchased = 0;
        int currentIncome = 0;
        String[][] cinema = new String[rows + 1][columns + 1];
        for (int i = 0; i <= rows; i++){
            for (int j = 0; j <= columns; j++) {
                if (i == 0 && j == 0) {
                    cinema[i][j] = " ";
                }else if (i == 0) {
                    cinema[0][j] = String.valueOf(j);
                }else if (j == 0) {
                    cinema[i][0] = String.valueOf(i);
                }else {
                    cinema[i][j] = "S";
                }
                
                
            }    
        }
        
        while (true) {
                System.out.println();
                System.out.println("1. Show the seats");
                System.out.println("2. Buy a ticket");
                System.out.println("3. Statistics");
                System.out.println("0. Exit");
                int option = scanner.nextInt();
                switch(option) {
                    case 1:
                        printCinemaSecond(cinema, rows, columns);
                        break;
                    case 2:
                        buyATicket(cinema, rows, columns, purchased, currentIncome);
                        break;
                    case 3:
                        stats(cinema, rows, columns, purchased, currentIncome, income);
                        break;
                    case 0:
                        return;
                        
                }
        }
    
    }
    
    public static void stats(String[][] cinema, int rows, int columns, int purchased, int currentIncome, int income) {
                for (int i = 0; i <= rows; i++) {
                    for (int j = 0; j <= columns; j++) {
                        if (cinema[i][j].equals("B")) {
                            purchased += 1;

                            if (rows * columns < 60) {
                                currentIncome += 10;
                            } else {
                                if (i < rows / 2 || i == rows / 2) {
                                    currentIncome += 10;
                                } else {
                                    currentIncome += 8;
                                }
                            }
                        }
                    }
                }
        System.out.println("Number of purchased tickets: " + purchased);
        int totalSeats = rows * columns;
        System.out.printf("Percentage: %.2f%%%n", (double) purchased/(rows * columns) * 100);
        System.out.println();
        System.out.println("Current income: $" + currentIncome);
        
        if (totalSeats <= 60 ) {
            income = totalSeats * 10;
            System.out.println("Total income:");
            System.out.println("$" + income);
        }else if (totalSeats > 60){
            income = (rows / 2) * columns * 10 + (rows - rows / 2) * columns * 8;
            System.out.print("Total income:");
            System.out.println("$" + income);
        }
    }
    
    public static void printCinema(String[][] cinema, int rows, int columns) {
        System.out.println();
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++){
            for (int j = 0; j <= columns; j++) {
                if (i == 0 && j == 0) {
                    cinema[i][j] = " ";
                }else if (i == 0) {
                    cinema[0][j] = String.valueOf(j);
                }else if (j == 0) {
                    cinema[i][0] = String.valueOf(i);
                }else {
                    cinema[i][j] = "S";
                }
                
                
            }
            
            
        }
        
    }
    
    public static void printCinemaSecond(String[][] cinema, int rows, int columns) {
        
        System.out.println();
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++){
            for (int j = 0; j <= columns; j++) {
               
                System.out.print(cinema[i][j] + " ");
                
            }
            
            System.out.println();
        }
        System.out.println();
    }
    
   
    
    public static void buyATicket(String[][] cinema, int rows, int columns, int purchased, int currentIncome) {
        
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter a row number:");
            int target_rows = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int target_columns = scanner.nextInt();
            
            if (target_rows > rows || target_columns > columns) {
                System.out.println("Wrong input!");
                continue;
            }else if (cinema[target_rows][target_columns].equals("B")){
              
                System.out.println("That ticket has already been purchased!");
                continue;
                        
                    
            }else {
                  //System.out.print("Ticket price : ");
                    int seats = rows * columns;
                    int price = 0;
                    if (seats <= 60 ) {
                        price = 10;
                        System.out.print("Ticket price : ");
                        System.out.println("$" + price);
                    }else if (seats > 60) {
                        if (target_rows <= rows / 2) {
                            price = 10;
                            System.out.print("Ticket price : ");
                            System.out.println("$" + price);
                        }else if (target_rows > rows / 2){
                            price = 8;
                            System.out.print("Ticket price : ");
                            System.out.println("$" + price);
                            }
                
                    }
                 cinema[target_rows][target_columns] = "B";
                break;
            }
                
        }
           
                  
           
        
           
            
    }
            
            
}
       
        
        
       
    
        

