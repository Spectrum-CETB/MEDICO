[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![GitHub forks](https://img.shields.io/github/forks/Spectrum-CETB/MEDICO?style=social)](https://github.com/Spectrum-CETB/MEDICO/network)
[![GitHub stars](https://img.shields.io/github/stars/Spectrum-CETB/MEDICO?style=social)](https://github.com/Spectrum-CETB/MEDICO/stargazers)

# MEDICO (Android)

[MEDICO](https://github.com/Spectrum-CETB/MEDICO/) is an application to ease the duty of the doctors and provide them with a virtual assistant.

## Features

* **HELP DOCTORS STORE DATA ABOUT THEIR PATIENTS:-** Doctors will be able to store all the details about the patient’s disease, their medical reports, the medicines prescribed and even their next appointment scheduled.
* **FOLDERS WILL BE CREATED TO MANAGE REPORTS:-** Doctors will have the freedom to create folders on the basis of report id or the name of disease to organize all the required contents in order.
* **THE DOCTOR CAN SET THE PRIORITY OF A REPORT BASED ON THE DISEASE:-** Medical cases can be arranged on the basis of high, medium and low priorities, where high priority cases will require utmost attention. Priorities will depend upon how dangerous a disease is.
<br/>
<h4>There will be a search option to save time and avoid confusion. Further, the searches will be filtered on the basis of : </h4>
<ul>
  <li>TIME</li>
<li>DATA</li>
<li>DISEASE</li>
<li>MEDICINES PRESCRIBED</li>
<li>PRIORITY</li>
</ul>

<h4> The application would consist of the following additional features- </h4>
<ul>
  <li>The application will take a record of each and every appointment, throughout the day,  for the doctor.  
</li>
<li>Application would allow Doctors to maintain all the details about their patients.
</li>
<br/>
  
## Setting up the project

To setup the project locally read and follow the instructions:

 - [Fork, Clone and Remote](https://www.digitalocean.com/community/tutorials/fork-clone-make-changes-push-to-github)
 - [Download Android Studio](https://developer.android.com/studio?gclid=Cj0KCQiApY6BBhCsARIsAOI_GjZgTJ2PSFo4cW0M8losb8r6gVMxnYbnXQ7h3ypRfnXnH4NKZUmgfGwaAi8IEALw_wcB&gclsrc=aw.ds)
 - After downloading configure android studio and find the root directory where all your android studio projects are stored. The folder would be by default located    on the home folder of the user and woule be named something like "AndroidStudioProjects"
 - After cloning, find the location of the project ("MEDICO folder") cloned
 - Now open the folder and you would find another folder named "MEDICO", just move it to the root directory of your android studio projects folder.
 - Start Android Studio and click on open an existing project and click the project "MEDICO".



## Running the UI tests

To run the existing UI tests follow the steps given below:
* Connect your Android device or open the emulator.
* On the terminal type: `./gradlew clean build connectedAndroidTest --stacktrace`
* If the above command is not working try using the command: `gradlew clean build connectedAndroidTest --stacktrace`
* Wait until all the tests are completed.
* You will get a report generated with a test summary.
* See the complete report `./MEDICO/app/build/reports/androidTests/connected/index.html`
* The report `./MEDICO/app/build/reports/androidTests/connected/index.html` will show all the testsuites that have passed as well as failed.
* You can find the respective html files of the different testsuites under the heading classes in `index.html` report.

## TECH STACK

Our tech stack includes:
- **Language:** [JAVA](https://docs.oracle.com/en/java/)
- **Architecture:** Model View ViewModel (MVVM)
- **Libraries:** [Firebase](https://firebase.google.com/)

## Branches

The repository has the following permanent branches:

 * **main** This contains the code which has been released.


## Screenshots
<img src="(https://github.com/Spectrum-CETB/MEDICO/blob/main/screenshot/Screenshot_2021-02-10-17-45-45-152_com.example.coderspot.jpg" alt="SplashScreen" height="250"/>



## DISCUSSION

We use DISCORD to discuss this project and interact with the community. If you're interested in contributing to this project, join us there!
<br/>
[![project chat](https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white)](https://discord.gg/CjXEenvU)

## Contact

You can reach our organization at [SPECTRUM](https://spectrumcet.com/).

## License

MEDICO is licensed under the Apache License. 
