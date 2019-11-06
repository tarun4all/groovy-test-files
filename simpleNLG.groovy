// https://mvnrepository.com/artifact/uk.ac.abdn/SimpleNLG
@Grapes(
    @Grab(group='uk.ac.abdn', module='SimpleNLG', version='4.4.8')
)


import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

Lexicon lexicon = Lexicon.getDefaultLexicon();
NLGFactory nlgFactory = new NLGFactory(lexicon);
Realiser realiser = new Realiser(lexicon);

NLGElement s1 = nlgFactory.createSentence("I am a developer working in blah blah company");
String output = realiser.realiseSentence(s1);
print output;