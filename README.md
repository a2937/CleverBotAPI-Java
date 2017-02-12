#CleverBot API Wrapper for Java!

This is a simple CleverBot API Wrapper. Usage is simple, and an example is below. The first step to using this wrapper is to register an api key [here](http://www.cleverbot.com/api).

##Installation
###Maven
```html
<dependency>
    <groupId>com.michaelwflaherty</groupId>
    <artifactId>cleverbotapi</artifactId>
    <version>1.0.1</version>
</dependency>
```
###Jar
If you're not using Maven, you can just download the jar [here](http://repo1.maven.org/maven2/com/michaelwflaherty/cleverbotapi/1.0.1/cleverbotapi-1.0.1.jar)


##Sample
```java
import com.michaelwflaherty.cleverbotapi.CleverBotQuery;

...

CleverBotQuery bot = new CleverBotQuery("YOURAPIKEY", someInputHere);

String response;

try
{
    bot.sendRequest();
    response = bot.getResponse();
}
catch (IOException e)
{
    response = e.getMessage();
}
```

More information about the cleverbot API can be found [here](http://cleverbot.com/api). 

##Issues
Please report any issues to the issues section & as always if you have any functionality requests go ahead and open an issue containing your suggestions.

##Credits
Package written by Michael Flaherty
Lots of maven help from [Cypher](https://github.com/scriptkittie)
API provided by the folks at [Exitor](https://www.existor.com/)

