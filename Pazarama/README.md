# Pazarama Web Test Automation Project

This project uses **Java** programming language, **Selenium**, and the **TestNG** framework to perform automation tests on [https://www.pazarama.com](https://www.pazarama.com) website. It also generates an **Extent** report showing the pass/fail status of the tests.

## Requirements

To run this project, you will need the following:

- Java Development Kit (JDK)
- Maven (To manage project dependencies)
- Web browser drivers (ChromeDriver, FirefoxDriver, EdgeDriver) [Download the appropriate versions of drivers and add them to the system PATH.]

## Installation

1. Clone the project to your computer:

   ```bash
   git clone https://github.com/ataaydinli/pazaramaStudyCase.git
   ```
2. Navigate to the project folder:

   ```bash
   cd pazaramaStudyCase
   ```
3. Install project dependencies:

    ```bash
    mvn clean install
    ```
4. After installing project dependencies, you can run the tests by following these steps:

    ```bash
    mvn test
    ```
   
## Overview of the scenario
The following scenario is implemented by these automated tests:


* Register on the website.

* Go to the login page and make sure you can log in using the right username and password.

* Pick a random category from the menu, then print "info" after the category name.

* Add one of the first 80 items in the category you just visited to your favorites, then check your selections on the "My Favorites" tab.

## Reports

Test results can be displayed in `Extent` reports. The reports include specific information and state whether the tests were pass or failed and it has include `Base64` image.

