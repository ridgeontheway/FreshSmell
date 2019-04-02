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

To Add a SmellerService
- Decide whether or not you need to add a new testable attribute to the Model
- If so:
	- Go to the method ParsingProfile.parse()
	- type 'file.' and find what you need from the Intellisense menu
	- Add the relevant attribute (with variable, getter and setter) to both ParsedClass/Method and Class/MethodModel
	- In ParsingProfile.parse(), add the relevant mapping from that attribute in JavaClass to ParsedClass
	- Do the same thing in MappingProfile.map() from ParsedClass/Method to Class/MethodModel
- Write your smell in Services/Smells/Concrete and make sure it implements ISmeller
	- Don't change ISmeller without asking me!
	- All new methods should be private
- Add a mapping to your smell in SmellerService.init()
