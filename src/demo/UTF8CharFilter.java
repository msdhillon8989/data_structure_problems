package demo;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/**
 * Created by maninder on 29/12/16.
 */
public class UTF8CharFilter {
    public static void main(String[] args) throws CharacterCodingException {
        CharsetDecoder utf8Decoder = Charset.forName("UTF-8").newDecoder();
        utf8Decoder.onMalformedInput(CodingErrorAction.REPLACE);
        utf8Decoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        utf8Decoder.replaceWith("?");

// Read stress file
        //🐦 Eagle Attack Bird Flight 3D
        String s ="\uD83D\uD8a4\uD8a4\uDC26\uD83D\uD83D\uD83D Ea 喵喵Run نبض ";

        System.out.println(s);
        char c[] = s.toCharArray();
        StringBuilder ss = new StringBuilder();
        for(char cc :c)
        {
           // System.out.println((int)cc);
        }
        //System.out.println(ss.toString());

        //s="喵喵Run نبض Nabd";
        //String s = "\\\uD83D\\\uDC26 Eagle Attack Bird Flight 3D";
        //byte[] data = s.getBytes(Charset.forName("UTF-8"));
        //ByteBuffer input = ByteBuffer.wrap(data);
          //  String ss ="\uD8a4";
// UTF-8 decoding
        //CharBuffer output = utf8Decoder.decode(input);

// Char buffer to string
        //String outputString = output.toString();

        //System.out.println(outputString);

        System.out.println( s.replaceAll("[\uD000-\uFFFF]", "y"));
    }
}
