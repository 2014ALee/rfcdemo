package com.ripefruitcreative;

public class video {
    String vidName;
    public static int hearingPrompts;
    public static int seeingPrompts;

    public video(int hp, int sp){
        System.out.println("Starting hp:");
        System.out.println(hp);
        hearingPrompts = hp;
        seeingPrompts = sp;
    }
    public void setValue(int startValue, int endValue){
        System.out.println("Setting values:");
        System.out.println("Start value:");
        System.out.println(startValue);
        System.out.println("Ending values:");
        System.out.println(endValue);
    }


     public boolean areAnswersCorrect(int hearCounter, int seeCounter){
         if(hearCounter != hearingPrompts || seeCounter != seeingPrompts){
            return false;
         }
         else{
             return true;
         }
     }
}
