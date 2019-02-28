# FreshSmell
A web-based code-smell analyzer for java files

Getting started (dev):
- Install Maven, Spring (as Maven dependency) and Tomcat
- In terminal (at project location), enter:
	- mvn clean
	- mvn compile
	- mvn package
- Add run configuration using TomcatServer-Local
- After 'Build' in 'Before Launch', add 'Run Maven Goal -> 'clean'
- Repeat the above step, this time adding 'Run Maven Goal' -> 'package' right after clean

