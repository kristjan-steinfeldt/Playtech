import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class turn {
    Integer time;
    Integer gameid;
    Integer playerid;
    String action;
    String Dhand;
    String Phand;
    public turn(Integer Time, Integer GameId, Integer PlayerId, String Action, String DHand, String PHand){
        this.time=Time;
        this.gameid=GameId;
        this.playerid=PlayerId;
        this.action=Action;
        this.Dhand=DHand;
        this.Phand=PHand;
    }

 
    public String toString(){//overriding the toString() method  
        return time+","+gameid+","+playerid+","+action+","+Dhand+","+Phand;  
       }  

    public boolean ValidateHand(){
    String[] cards=(Dhand+"-"+Phand).split("-");
    String[] Dcards=Dhand.split("-");
    String[] Pcards=Phand.split("-");
    int Pscore=score(Pcards);
    int Dscore=score(Dcards);
    Set<String> set = new HashSet<>();
    final Pattern pattern = Pattern.compile("[A-Za-z][chds]|[2-9][chds]|10[chds]|[?]", Pattern.CASE_INSENSITIVE);

    for (int i = 0; i < cards.length; i++) {
           if (set.contains(cards[i])) {
                return false;
            }
        set.add(cards[i]);
    }
    for (String card : set) {
        final Matcher matcher = pattern.matcher(card);
        if(matcher.matches()){
        return false;
        }

    }
    return ValidateScore(Dscore,Pscore,this.action);
    } 

    private int score(String[] Hand) {
        int handvalue=0;
        for (String card : Hand) {
            switch (card.charAt(0)) {
                case '1':
                if (card.charAt(1)=='0') {
                    handvalue=+10;
                }
                else{
                    handvalue++;
                }
                break;
                case '2':
                handvalue+=2;
                break;
                case '3':
                handvalue+=3;
                break;  
                case '4':
                handvalue+=4;
                break;   
                case '5':
                handvalue+=5;
                break;
                case '6':
                handvalue+=6;
                break;     
                case '7':
                handvalue+=7;
                break;     
                case '8':
                handvalue+=8;
                break;     
                case '9':
                handvalue+=9;
                break;     
                case 'J':
                handvalue+=10;
                break;  
                case 'Q':
                handvalue+=10;
                break;  
                case 'K':
                handvalue+=10;
                break;     
                case 'A':
                handvalue=+11;
                break;
                case '?':
                break;                                             
                default:
                    break;
            }
            
        }
        return handvalue;
    }


    private boolean ValidateScore(int Dscore,int Pscore,String action) {
        switch (action) {
            case "P Hit":
            if (Pscore>=21||Dscore>=21 ){
                return false;
            }
            else {return true;}

            case "P Joined":
            if (Pscore>=21||Dscore>=21 ){
                return false;
            }
            else {return true;}

            case "P Stand":
            if (Pscore>=21||Dscore>=21 ){
                return false;
            }
            else {return true;}

            case "P Win":
            if (((Pscore<=21 & Pscore>Dscore) & Dscore>=17) ||(Dscore>21)||(Pscore==Dscore & Dscore>=17 ) ){
                return true;
            }
            else {return false;}
                        
            case "P Lose":
            if ((Dscore<21 & Pscore<Dscore & Dscore>=17)|| (Pscore>21)){
                return true;
            }
            else {return false;}

            case "D Hit":
            if ((Pscore>=21||Dscore>=21) || Dscore>=17) {
                return false;
            }
            else {return true;}

            case "D Show":
            if (Pscore>=21||Dscore>=21 ){
                return false;
            }
            else {return true;}

            case "D Redeal":
            if (Pscore>=21||Dscore>=21 ){
                return false;
            }
            else {return true;}

        default:
        return true;
    }
    }

//P Hit
//P Joined
//P Stand
//P Win
//P Lose
//D Hit
//D Show
//D Redeal
    }
