# ProgressButton
loading MaterialProgressDrawable when a user clicks the button
![gif](https://raw.githubusercontent.com/Blankeer/ProgressButton/master/image/progressbutton.gif)

```java
        progressbutton = (ProgressButton) findViewById(R.id.progressbutton);
        progressbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressbutton.setLoading(false);
                    }
                }, 3000);
            }
        });
```
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.Blankeer:ProgressButton:0.1.3'
	}