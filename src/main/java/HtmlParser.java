import com.sun.corba.se.pept.transport.OutboundConnectionCache;
import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by srivnee on 04/07/2016.
 */
public class HtmlParser {
    final static String ErrorOutputString = "None";

    public String parseHtml(String inputString) {

        //TODO: Implement logic to parse Html
        String[] inputStringArr = splitOnDelm(inputString,"\n");
        ArrayList<String> outputStringArr = new ArrayList<String>();
        for(String inp:inputStringArr){
            outputStringArr.add(parseHtmlLine(inp));
        }

        System.out.println( StringUtils.join(outputStringArr, "\n"));
        return StringUtils.join(outputStringArr, "\n");
    }

    private String parseHtmlLine(String inp) {
        int count = 0;
        String outputString = "";
        Pattern tagPattern = Pattern.compile("\\<(.*?)\\>");
        Matcher matcher = tagPattern.matcher(inp);
        Stack tagStack = new Stack();
        boolean nestedTags = false;
        boolean nestedTagProcessed = false;
        int outputStringStartIndex = -1;

        while(matcher.find()){
            String tag = matcher.group();
            String tagName = tag.substring(1,tag.length()-1);


            if(tagName.startsWith("/")){
                if(tagStack.empty()){
                    outputString = ErrorOutputString;
                    break;
                }
                tagName = tagName.substring(1);
                if(tagStack.pop().equals(tagName) && outputStringStartIndex != -1){
                  //  if(!nestedTags ||(nestedTags))

                  if(!nestedTags ||(nestedTags && !nestedTagProcessed)){
                      String tempString = inp.substring(outputStringStartIndex,matcher.start());
                      outputString = outputString.equals("")?tempString:outputString+"\n"+tempString;
                      nestedTagProcessed = true;

                  }
                    if(nestedTags && tagStack.empty())
                        nestedTags = false;
                }
            }
            else {
                if(!tagStack.empty()){
                    nestedTags =true;
                }

                tagStack.push(tagName);
                outputStringStartIndex = matcher.end();

            }




        }
        outputString =outputString==""?ErrorOutputString:outputString;
        return outputString ;
    }

    private String[] splitOnDelm(String inputString, String s) {
        return inputString.split(s);
    }
}
