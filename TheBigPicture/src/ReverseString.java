public class ReverseString {
    private String originString;

    public ReverseString(String string){
        this.originString = string;
    }

    public String getOriginString() {
        return originString;
    }

    public String reverse(){
        StringBuilder reversedStr = new StringBuilder();
        for(int i =0; i<originString.length();i++)
        {
            reversedStr.append(originString.charAt(originString.length()-i-1));
        }
        return reversedStr.toString();
    }
}
