@Grab('org.apache.opennlp:opennlp-tools:1.9.0')
import opennlp.tools.langdetect.*
import opennlp.tools.sentdetect.SentenceDetectorME 
import opennlp.tools.sentdetect.SentenceModel
import opennlp.tools.util.Span
import java.util.* 
import java.nio.charset.StandardCharsets 
import java.nio.file.* 
import java.io.*

try
{ 
    // lines = Files.readAllLines(Paths.get(this.args[0]), StandardCharsets.UTF_8);
    data = new String(Files.readAllBytes(Paths.get(this.args[0])));
    Stack<String> SENSTACK = new Stack<String>();

    //Loading a sentence model
    InputStream inputStream = new FileInputStream("./en-sent.bin"); 
    SentenceModel model = new SentenceModel(inputStream); 
    
    //Instantiating the SentenceDetectorME class 
    SentenceDetectorME detector = new SentenceDetectorME(model); 
    
    //Detecting the position of the sentences in the paragraph  
    Span[] spans = detector.sentPosDetect(data);  
    
    FileWriter fw = new FileWriter(this.args[1]);

    //writting the sentences and their spans of a paragraph
    for (Span span : spans) {
        SENSTACK.push(data.substring(span.getStart(), span.getEnd()));
        System.out.println(data.substring(span.getStart(), span.getEnd()));
    }

    fw.write(Arrays.toString(SENSTACK))
    fw.close()
} catch (IOException e) { 

    // do something 
    print e.printStackTrace(); 
}