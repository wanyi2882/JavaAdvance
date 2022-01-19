package com.company;
import java.util.*;

public class BrowserHistory {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = sc.nextLine();

        String currentURL = "";

        while(!input.equals("Home")){
            if(input.equals("back")){
                if(!stack.isEmpty()){
                    currentURL = stack.pop();
                }
                else{
                    System.out.println("no previous URLs");
                    input = sc.nextLine();
                    continue;
                }
            }
            else{
                if(!currentURL.equals("")){
                    stack.push(currentURL);
                }
                currentURL = input;
            }
            System.out.println(currentURL);
            input = sc.nextLine();
        }
    }
}