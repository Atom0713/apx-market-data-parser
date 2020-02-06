/*
 *Created by Artem on 04/02/2020
 */
public class QuoteValue {
    private String tLabel;
    private String value;

    public String getTLabel(){
        return tLabel;
    }
    public void setTLabel(String input){
        this.tLabel = input;
    }

    public String getValue(){
        return value;
    }
    public void setValue(String input){
        this.value = input;
    }


    @Override
  public String toString() {
            return "QuoteValue{" +
                      "tLabel='" + tLabel + '\'' +
                      ", value=" + value +
                      '}';
          }
}
