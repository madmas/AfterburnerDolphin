AfterburnerDolphin
==================

Simple example project as a showcase to bring OpenDolphin (http://www.open-dolphin.org) and Afterburner.fx (http://afterburner.adam-bien.com) together
and see if they can benefit from each other.

Setup
-----

* Maven
* Java 7 with JavaFX
* Afterburner.fx installed to your (local) Maven repository as it's not included in Maven central yet.
    * With Java 8 installed on your machine, you can
        * git clone https://github.com/AdamBien/afterburner.fx
        * cd afterburner.fx
        * mvn
    * For Java 7, the compiler language level and dependency to JavaFX need to be adjusted. I forked the main afterburner.fx and did this for you, so the following will work:
        * git clone https://github.com/madmarkus/afterburner.fx
        * cd afterburner.fx
        * mvn
* Load up this project in your IDE (e.g. via the pom.xml)

Run
---

Use the ApplicationInMemoryStarter from the combined module to run the project from your IDE.
