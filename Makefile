all:
	javac *.java
	java TestJeu
run:
	java TestJeu
clean:
	rm -rf *.class
	rm -rf \#*
	rm -rf *~

