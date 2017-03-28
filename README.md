# CleverBot API Wrapper for Java!

This is a simple CleverBot API Wrapper. Usage is simple, and an example along with a link to official documentation is below. The first step to using this wrapper is to register an api key [here](http://www.cleverbot.com/api).

## Changelog

<details> 
  <summary>Open spoiler to view changelog </summary>
### 1.0.2
- Added support for javadocs.
- Created [official documentation page](http://www.cleverbotapi.michaelwflaherty.com/).
- Adjusted integer parsing location in the setRandomNumber method.

### 1.0.1
- Fixed empty maven build error (Issue #1).

### 1.0.0
- Initial release.
</details>


## Installation
### Maven
```html
<dependency>
    <groupId>com.michaelwflaherty</groupId>
    <artifactId>cleverbotapi</artifactId>
    <version>1.0.2</version>
</dependency>
```
### Jar
If you're not using Maven, you can just download the jar [here](http://repo1.maven.org/maven2/com/michaelwflaherty/cleverbotapi/1.0.2/cleverbotapi-1.0.2.jar)


## Sample
View the example below, or review our [official documentation](http://cleverbotapi.michaelwflaherty.com)!
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

## Issues
Please report any issues to the issues section & as always if you have any functionality requests go ahead and open an issue containing your suggestions.

## Credits
Package written by [Michael Flaherty](http://michaelwflaherty.com/)

Lots of maven help from [Cypher](https://github.com/scriptkittie)

API provided by the folks at [Exitor](https://www.existor.com/)

