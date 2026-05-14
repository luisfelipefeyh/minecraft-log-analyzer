# Minecraft Log Analyzer

## This is a project I'm creating with the intent of learning Java

### How the app should work when done (examples):

* loganalyzer --file latest.log --deaths `-->` List of deaths in chronological order
* loganalyzer --file latest.log --top-players `-->` Top players ranked by playtime
* loganalyzer --file latest.log --messages-number --since 15:00:00 `-->` Number of messages sent since time
* loganalyzer --file latest.log --print-all `-->` Prints the whole file
* loganalyzer --file latest.log --advancements `-->` Logs "There has been a total of 'n_of_advancements' made!"

## To run:

1) Compile first:

```
javac src/LogAnalyzer.java -d out
```

2) Then run it:

```
java -cp out LogAnalyzer` `FLAGS GO HERE
```
