package com.example.quizapp.Model;

public class Questions {

    //QUESTIONS

    public static  String question[] = {
            "What is a keyword is Java to create an object?",
            "How to declare a variable?",
            "Choose the appropriate data type for this value : “1”?",
            "What is a size of Char in Java?",
            "What is essential in making sure that you loop is not infinite?",
            "What is a class?",
            "Choose an appropriate data type for this value: 1?",
            "An abstract class can have non-abstract methods?",
            "Choose a best definition of an object?",
            "How you can prevent a member variable from becoming serialised?"

    };

    //CHOICES

    public static  String choices[][] = {
            {"This","Sync","New()","New"},
            {"VariableName","VariableType","VariableType variableName","VariableName variableType"},
            {"String","Char","Boolean","Int"},
            {"4 bits","8 bits","16 bits","7 bits"},
            {"That you Boolean statement will at some point be false","That there is a Boolean statement somewhere in your code","All of the choices","That your Boolean statement will at some point be true"},
            {"An exucutable piece of code","An abstract definition of an object","An object","A variable"},
            {"Double","Int","String","Boolean"},
            {"True","False","Maybe","Not applicable"},
            {"Something you own","An instance of a class","A thing","Something you can operate"},
            {"By making it volatile","By making it transient","By making it private","It is not possible"}

    };

    //ANSWERS - CORRECT

    public static  String answers[] = {
            "New",
            "VariableType variableName ",
            "String",
            "16 bits ",
            "That you Boolean statement will at some point be false",
            "An abstract definition of an object ",
            "Int",
            "True",
            "An instance of a class",
            "By making it transient"

    };
}
