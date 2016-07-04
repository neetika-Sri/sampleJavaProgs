import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by srivnee on 04/07/2016.
 */
public class HtmlParser {

    public String parseHtml(String inputString) {
        //TODO: Implement logic to parse Html
        String[] inputStringArr = splitOnDelm(inputString,"\n");
        ArrayList<String> outputStringArr = new ArrayList<String>();
        for(String inp:inputStringArr){
            outputStringArr.add(parseHtmlLine(inp));
        }

        return StringUtils.join(outputStringArr, "\n");
    }

    private String parseHtmlLine(String inp) {
        int count = 0;
        String outputString = "None";
        /*String openingTag = Pattern.quote("<")+"/^([^\\].*)/"+Pattern.quote(">");
        Pattern openingTagPat = Pattern.compile(openingTag);
        Matcher matcher = openingTagPat.matcher(inp);
        while(matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.end());

        }*/
        return outputString ;
    }

    private String[] splitOnDelm(String inputString, String s) {
        return inputString.split(s);
    }
}
