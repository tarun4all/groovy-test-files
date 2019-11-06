@Grab('org.apache.opennlp:opennlp-tools:1.9.0')
import opennlp.tools.langdetect.*
import opennlp.tools.sentdetect.SentenceDetectorME 
import opennlp.tools.sentdetect.SentenceModel 
import opennlp.tools.util.Span

    def sen = "Hi. How are you? Welcome to Tutorialspoint. We provide free tutorials on various technologies";

    //Loading a sentence model 
    InputStream inputStream = new FileInputStream("./en-sent.bin"); 
    SentenceModel model = new SentenceModel(inputStream); 
    
    //Instantiating the SentenceDetectorME class 
    SentenceDetectorME detector = new SentenceDetectorME(model);  
    
    //Detecting the position of the sentences in the paragraph  
    Span[] spans = detector.sentPosDetect(sen);  
    
    //Printing the sentences and their spans of a paragraph 
    for (Span span : spans)         
        System.out.println(sen.substring(span.getStart(), span.getEnd())+" "+ span);  


// def base = 'http://apache.forsale.plus/opennlp/models'
// def url = "$base/langdetect/1.8.3/langdetect-183.bin"
// def model = new LanguageDetectorModel(new URL(url))
// def detector = new LanguageDetectorME(model)
// def best = detector.predictLanguage('Bienvenue à Montréal')
// assert best.lang == 'fra'
// println best