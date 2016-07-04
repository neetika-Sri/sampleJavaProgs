import junit.framework.Assert;
import org.junit.Test;


/**
 * Created by srivnee on 04/07/2016.
 */


    /* Problem Statemenet :-
    In a tag-based language like XML or HTML, contents are enclosed between a start tag and an end tag like <tag>contents</tag>. Note that the corresponding end tag starts with a /.
Given a string of text in a tag-based language, parse this text and retrieve the contents enclosed within sequences of well-organized tags meeting the following criterion:
1.	The name of the start and end tags must be same. The HTML code <h1>Hello World</h2> is not valid, because the text starts with an h1 tag and ends with a non-matching h2 tag.
2.	Tags can be nested, but content between nested tags is considered not valid. For example, in <h1><a>contents</a>invalid</h1>, contents is valid but invalid is not valid.
3.	Tags can consist of any printable characters.
Input Format
The first line of input contains a single integer, (the number of lines).
The subsequent lines each contain a line of text.
Constraints
o	Each line contains a maximum of printable characters.
o	The total number of characters in all test cases will not exceed
Output Format
For each line, print the content enclosed within valid tags.
If a line contains multiple instances of valid content, print out each instance of valid content on a new line; if no valid content is found, print None.
Sample Input
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>
Sample Output
Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush

*/
public class HtmlParserTest {
    @Test
    public void testHtmlParser() throws Exception {
        HtmlParser htmlParser = new HtmlParser();
        String input = "<h1>Nayeem loves counseling</h1>\n" +
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>\n" +
                "<Amee>safat codes like a ninja</amee>\n"+
                "<SA premium>Imtiaz has a secret crush</SA premium>";
        String output = "Nayeem loves counseling\n" +
                "Sanjay has no watch\n" +
                "So wait for a while\n" +
                "None\n" +
                "Imtiaz has a secret crush";
        Assert.assertEquals(output,htmlParser.parseHtml(input));
    }

}


