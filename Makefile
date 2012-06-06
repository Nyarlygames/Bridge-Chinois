all:
	javac *.java
run: all
	java TestJeu
testReseau: all
	java TestJeu &
	java TestJeu &
clean:
	rm -rf *.class
	rm -rf \#*
	rm -rf *~
	rm -rf Bridge.jar
	rm -rf Bridge.tar.bz2
jar:
	javac *.java
	jar cf Bridge.jar *
runjar: jar
	java -cp Bridge.jar TestJeu
dist:
	cd ..;tar -cjvf Bridge.tar.bz2 Bridge-Chinois
	cd ..; mv Bridge.tar.bz2 Bridge-Chinois
