## XYZ BANK test automation framework

### Installation

* Install [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html);
* Install dependencies:
    * Go to file build.gradle;
    * Click on the button build (elephant);
    * Go to IDE settings;
    * Search "Gradle" in search field;
    * Choose "Build Tool" -> Gradle
    * Choose "Build in run using", "Run test using" : IntelliJ IDEA;
* Install [ImageMagic](https://imagemagick.org/script/download.php) version 6 is required;
    * for Mac Apple Silicon :
        * install imagemagick: `brew install imagemagick@6`;
* install [AllureTestOps](https://docs.qameta.io/allure-testops/getstarted/installation/) lts;
*

### Run tests

* for run all tests: ./gradlew testName;

### Report system

* Run command in Terminal `allure serve`

### Install Plugins

* Indent Rainbows
* Gradle
* Brackets Rainbows