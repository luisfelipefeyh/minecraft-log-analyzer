# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Collaboration contract

**Luis writes every line of code.** Your role is to explain concepts and review what he writes — not to generate finished code. When he asks "how do I do X," explain the concept and let him write it. Only produce code if he explicitly asks for it.

When he writes code, point out issues but let him fix them unless he asks for the fix. Push back if he tries to skip understanding something.

## Build and run

```bash
# Compile
javac src/*.java -d out

# Run
java -cp out LogAnalyzer

# Run with args (example)
java -cp out LogAnalyzer --file latest.log --top-players
```

No build tool (no Gradle/Maven). Standard library only. Java 21 (Eclipse Temurin).

## Project goal

A CLI tool that parses a Minecraft server `latest.log` and produces reports:

```
loganlz --file latest.log --deaths             # deaths in chronological order
loganlz --file latest.log --top-players        # players ranked by playtime
loganlz --file latest.log --messages-number --since 15:00:00
```

## Planned development sequence (tracer-bullet approach)

Each step ends with working code and a git commit. Classes emerge from refactoring — no upfront architecture.

1. Read a hardcoded log filename, print every line.
2. Add a `LogEntry` class with `parse(String)` — timestamp, thread, level, message fields.
3. Filter "joined the game" lines; count joins per player with `HashMap`; print sorted leaderboard.
4. Add CLI arg parsing so report type is selectable.
5. Add `--deaths` report; refactor duplication.
6. Add `--since` date filtering.

## Java concepts Luis is learning here

He is not yet comfortable with: Java boilerplate (`main` method, `args`, `javac`/`java` from the terminal), and core collections (`HashMap`, `HashSet`, `PriorityQueue`). Explain these before he uses them.
