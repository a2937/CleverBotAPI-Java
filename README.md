#CleverBot API Wrapper for Java!

This is a simple CleverBot API Wrapper. Usage is simple, and an example is below.

###Maven
```html
<dependency>
    <groupId>com.michaelwflaherty</groupId>
    <artifactId>cleverbotapi</artifactId>
    <version>1.0</version>
</dependency>
```
##Usage

First step is to recieve an API key from cleverbot.com/api.

Then just use the following as a template
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
You may look at a list of reasons that the CleverBot API Request would fail along with more information here!

##Otherwise

The CleverBot API itself is very simple and easy to use. If you have any functionality requests go ahead and open an issue containing your suggestions.
