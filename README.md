
This is the supporting code for an exercise described 
in http://matteo.vaccari.name/blog/archives/293

The idea is to practice decoupling and abstraction. You can build complex behavior simply 
by a combination of very small and simple classes.

Rules: 
* In order to add new features (pass the next test). You can't add new behaviour to existing classes. 
You can however move existing behaviour to a new class and inject an instance of that new class into
     the constructor of the current class.
* You can't add a new constructor parameter if you already have one. If you need a class with more
than one constructor parameter you'll have to write it from scratch.

These rules should give you something extremely SRP/OCP