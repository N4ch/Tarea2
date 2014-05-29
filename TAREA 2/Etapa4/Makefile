JFLAGS = -g
JFLAGS2 = -d
JC = javac
JVM= java
JDC= javadoc
JDIR= Tarea2Doc
FILE=
.SUFFIXES: .java .class .html
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		Ball.java \
        BallView.java \
        CreateConfiguration.java \
        FixedHook.java \
        FixedHookView.java \
        LabMenuListener.java \
        MouseListener.java \
        PhysicsElement.java \
        PhysicsLab.java \
        Simulateable.java \
        Spring.java \
        SpringAttachable.java \
        SpringView.java \
        
       
MAIN = PhysicsLab

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) $(FILE)

DOCS= Ball.java BallView.java MyWorld.java

doc:  $(DOCS)
	$(JDC) $(JFLAGS2) $(JDIR) $(DOCS)

clean:
	$(RM) *.class
	$(RM) *.html
