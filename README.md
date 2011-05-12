# Goals

Provide a space where we (anyone in the ScalaIDE community) can store :

* (integration) tests for [ScalaIDE](http://scala-ide.org)
* sample projects use to show what works and what failed (stored into workspace)
* platform target definition used to run test 
 
# Install & run

To run test from eclipse you need :
1. to install [SWTBot IDE Support](http://swtbot.com/user-guide/download-and-install.html)
2. clone the project
3. import the project into eclipse
4. select the platform
5. run the test 

# Why not under scala-ide.org ?

I choose to create the project outside the main scalaIDE project and outside Assembla.
Because :
* github allow easy fork and contribution from other users
* I didn't require CLA from user to provide project sample and code for test

I choose to use java to code test, because :
* SWTBot provide sample, helper, wizard for java 
* test can run without scala-ide.org (no scala dependency)
* test can run with any version of scala installed in eclipse
* JDT just work

# TODO

* reorg project under workspace (currently only copied as is from my desktop, when I previously "test" scala-ide)
* add test : helloworld test (create project + run + test output)
* add test : detect compilation error (PC + builder)
* add test : insert template
* add test : rename method
* define platform target definition for (galileo + helios) x (milestone_1.x + wip_1.x + beta_2.x + wip_2.x)
* run test from command line
* add test : ...
* add documentation to guide contributor or bug reporter
