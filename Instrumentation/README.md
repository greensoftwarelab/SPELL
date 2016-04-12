Introduction
--------------------------------------------------------------

This tool automatically inserts (jRapl) energy reading method calls from the JWrapper package/EnergyWrapper class. 

For a general explanation of jRapl, check out [webpage](http://kliu20.github.io/jRAPL/).

Any other questions on how to use jRapl or JWrapper feel free to contact.


How to use
--------------------------------------------------------------

After compiling the project, run the main class (instrumentation.Instrumentation) with arg[0] as the path to the folder with the source code you wish to instrument.

It will create a new folder with a "__INST__" prefix with the instrumented code in the original path.

- The beginning of each method will have the start call:

`EnergyWrapper.getEnergy("ClassName", "methodName", 0);`

- and the end of each method (and before any returns and exceptions) will have the end call:

`EnergyWrapper.getEnergy("ClassName", "methodName", 1);`


Afterwards, just copy the JWrapper folder to the root of your newly instrumented code, and if use RaplRunner.java if needed.

Known bugs
--------------------------------------------------------------

In some cases with nested if-cases with exceptions, the end call might not be placed. 

Contact and other information
--------------------------------------------------------------
- Rui Pereira {ruipereira@di.uminho.pt}
- GreenLab {greenlab@di.uminho.pt}
