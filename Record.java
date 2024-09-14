
public enum Record
{
 //Enum constants
 LOTUS("lotus","noun","It is India's national flower"),
 PEN ("pen", "noun", "It is used to write on a book"),
 PEN1 ("pen", "noun", "It will have cap to close and refill"),
 ARROW( "arrow", "noun", "A sharp shaped at the front end."),
COFFEE("coffee","noun","It is a drink."),
 COFFEE1("coffee","noun","It is a prepared with milk, sugar and coffee powder."),
 BOY("boy","noun","A male youth."),
 DANCE("dance","verb","Move hands and legs according to the music."),
 BEAUTIFUL("beautiful","adjective","Having qualities of beauty."),
 NERVOUS("nervous", "adjective", "Easily alarmed."),
 BOY1("boy","noun","His gender is male child."),
 DANCE1("dance","verb","Put an end to the existence."),
 BEAUTIFUL1("beautiful","adjective","Pleasing the senses."),
 NERVOUS1("nervous", "adjective", "Tending to be anxious."),
 PLAIN("plain","adjective","It looks simple."),
 ANGRY("angry", "adjective","Shout at some one."),
 LITTLE("little", "adjective","Smallin size."),
 DESTROY("destroy","verb","His gender is male child."),
 COMPUTER("computer","noun","It is a electronic device."),
 COMPUTER1("computer","noun","It is a electronic device used for processing data."),
 COMPUTER2("computer","noun","It is a electronic device used for storing."),
 BOOK("book", "noun", "collection of pages"),
 BOOK1 ("book", "verb", "Reserving a seat in a Train or Flight or Bus."),
 BOOK2 ("book", "noun", " A written work published in printed or electronic form."),
 BOOK3 ("book", "verb", "To arrange something on a particular date."),
 BOOK4 ("book", "verb", "A written work published in printed or electronic form."),
 BOOK5("book", "noun", " To arrange something on a particular date."),
 JUMP("jump", "verb", "sudden movement in response to shock."),
 JUMP1("jump", "verb", "Jump out of building."),
 JUMP2("jump", "verb", "Put oneself off the surface."),
 JUMP3("jump", "verb", "Put oneself into the air by using the muscles of one's legs."),
 DISTINCT("distinct", "adjective", "Familiar. Worked in Java."),
 DISTINCT2("distinct", "adjective", "Unique. No duplicates."),
 DISTINCT3("distinct", "adjective", "Clearly different or of a different kind."),
 DISTINCT4("distinct", "adverb", "Uniquely. Written 'distinctly'."),
 DISTINCT5("distinct", "noun", "A keyword in this assignment."),
 DISTINCT6("distinct", "noun", "A keyword in this assignment."),
 DISTINCT7("distinct", "noun", "An advanced search option."),
 REVERSE1("reverse", "adjective", "On back side."),
 REVERSE2("reverse", "adjective", "Opposite to usual or previous arrangement."),
 REVERSE3("reverse", "noun", "A dictionary program's parameter."),
 REVERSE4("reverse", "noun", "Change to opposite direction."),
 REVERSE5("reverse", "noun", "The opposite."),
 REVERSE6("reverse", "noun", "To be updated..."),
 REVERSE7("reverse", "noun", "To be updated..."),
 REVERSE8("reverse", "noun", "To be updated..."),
 REVERSE9("reverse", "noun", "To be updated..."),
 REVERSE10("reverse", "verb", "Change something to opposite."),
 REVERSE11("reverse", "verb", "Go back"),
 REVERSE12("reverse", "verb", "Revoke ruling."),
 REVERSE13("reverse", "verb", "To be updated..."),
 REVERSE14("reverse", "verb", "To be updated..."),
 REVERSE15("reverse", "verb", "Turn something inside out."),
 PLACEHOLDER1("placeholder", "adjective", "Turn something inside out."),
 PLACEHOLDER2("placeholder", "adjective", "Turn something inside out."),
 PLACEHOLDER3("placeholder", "adverb", "Turn something inside out."),
 PLACEHOLDER4("placeholder", "conjunction", "Turn something inside out."),
 PLACEHOLDER5("placeholder", "interjection", "Turn something inside out."),
 PLACEHOLDER6("placeholder", "noun", "Turn something inside out."),
 ARROW1("arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
 RUN("run", "verb", "go or move faster");
 private final String keyword;
 private final String partOfSpeech;
 private final String definition;
 //Creating constructor for enum constants
 Record(String keyword, String partOfSpeech, String definition)
 {
  this.keyword = keyword;
  this.partOfSpeech = partOfSpeech;
  this.definition = definition;
 }
 //Getter methods to get keywords, parts of speech, definition
 public String getKeyword()
 {
  return keyword;
 }

 public String getPartOfSpeech()
 {
  return partOfSpeech;
 }
 public String getDefinition()
 {
  return definition;
 }

}
