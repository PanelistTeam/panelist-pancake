# Project Panelist
## Android client

The code of the app's Web and API server is located in the [`potato`](https://github.com/outfrost/panelist-potato) repository. (No `meat` though, we're not that fancy.)

### Environment setup

First, clone repository and checkout the appropriate branch, e.g.

```sh
$ git clone https://github.com/outfrost/panelist-pancake.git
$ cd panelist-pancake/
$ git checkout <branch_name>
```

#### With Android Studio

1. Open the working directory in Android Studio
1. Wait for Gradle to finish sync & build; for now, ignore any messages about unregistered VCS
1. Exit Android Studio
1. Restore versioned files to their state before the import by doing a full git checkout once again, e.g.
	```sh
	$ git checkout -- .
	```
1. Open the project in Android Studio again and you're good to go.
