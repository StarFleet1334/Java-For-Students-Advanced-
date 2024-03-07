package org.example.security;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CommandInjectionAttack {
    public static void commandInjection(){
        Console console = System.console();
        System.out.print("Enter directory: ");
        String dirToView = console.readLine();
        Path p = Paths.get("/Users/ilialataria/Desktop/Java For Students/learn/src/main/java/org/example/security/TheFarm/Animals/" + dirToView);
        try(Stream<Path> s = Files.walk(p)){
            s.filter(path -> path.toString().endsWith(".txt"))
             .forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void commandInjectionWhitelist(){
        Console console = System.console();
        System.out.print("Enter directory: ");
        String dirToView = console.readLine();
        // use a whitelist to ensure only valid directories are allowed
        if(dirToView.equals("Cattle") || dirToView.equals("Sheep")){
            Path p = Paths.get("/Users/ilialataria/Desktop/Java For Students/learn/src/main/java/org/example/security/TheFarm/Animals/" + dirToView);
            try(Stream<Path> s = Files.walk(p)){
                s.filter(path -> path.toString().endsWith(".txt"))
                 .forEach(System.out::println);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else{
            System.err.println("Invalid directory entered: "+dirToView);
        }
    }
    public static void main(String[] args) {
//        commandInjection();
          commandInjectionWhitelist();
    }

    // To run this class use this commands
    //  javac CommandInjectionAttack.java and then
    //  java  CommandInjectionAttack.java
    
}
