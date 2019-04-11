# Java HTTP GET Requests

## Wikipedia API GET Request: 

Compile and run `WikipediaGETRequest.java`; you should see Wikipedia information for TJHSST print to your console.

## Phone2Action API GET Request:

First, make sure you have a valid Phone2Action API Key. If you don't have one, text `HACKTJ19` to `52886` on your phone to receive yours. Then, in line 15 of `Phone2ActionGETRequest.java`. change the `xAPIKey` String to your Phone2Action API Key.

So, if your Phone2Action API Key is `abcdefg`, line 15 in `Phone2ActionGETRequest.java` should look something like this:

```
String xAPIKey = "abcdefg";
```

Compile and run `Phone2ActionGETRequest.java`; you should see information about the Representative in national Congress for TJHSST's district print to your console.

## Note: 

We're using the Minimal JSON package to parse our JSON objects; information on how to use Minimal JSON [here](https://github.com/ralfstx/minimal-json).
