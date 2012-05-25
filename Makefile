all:
	javac *.java
	java TestJeu
run:
	java TestJeu
clean:
	rm -rf *.class
	rm -rf \#*
	rm -rf *~
dist:
	cd ..;tar -cjvf Bridge.tar.bz2 Bridge-Chinois
	cd ..; mv Bridge.tar.bz2 Bridge-Chinois
