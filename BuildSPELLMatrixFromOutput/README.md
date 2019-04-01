Introduction
--------------------------------------------------------------

This tool parses the method execution trace, execution time, and energy consumption of the Instrumentation tool and generates the appropriate SPELL matrix.

How to use
--------------------------------------------------------------

After compiling the project, run the main class (output.Main) with arg[0] as the path to the file.

Each test run should be seperated by a semi-colon (;). An example can be seen below.

Example input/output
--------------------------------------------------------------

###### Input:

```
>Class_method1 [ m=example, cpu = 48.005478, t = 1455 ]
>Class_method2 [ m=example, cpu = 48.005478, t = 1455 ]
<Class_method2 [ m=example, cpu = 48.005481, t = 1456 ]
<Class_method1 [ m=example, cpu = 48.057404, t = 1457 ]
>Class_method3 [ m=example, cpu = 48.057404, t = 1457 ]
<Class_method3 [ m=example, cpu = 49.057414, t = 1458 ]
>Class_method4 [ m=example, cpu = 49.072083, t = 1458 ]
<Class_method4 [ m=example, cpu = 49.152083, t = 1900 ];
>Class_method1 [ m=spell, cpu = 66.703262, t = 1455 ]
>Class_method2 [ m=spell, cpu = 66.703262, t = 1455 ]
<Class_method2 [ m=spell, cpu = 66.703292, t = 1495 ]
<Class_method1 [ m=spell, cpu = 69.703362, t = 1555 ]
>Class_method3 [ m=spell, cpu = 66.703262, t = 1555 ]
<Class_method3 [ m=spell, cpu = 66.803262, t = 1655 ];
>Class_method4 [ m=spell, cpu = 66.720093, t = 1655 ]
<Class_method4 [ m=spell, cpu = 66.820093, t = 1677 ]
>Class_method1 [ m=spell, cpu = 66.820093, t = 1677 ]
>Class_method5 [ m=spell, cpu = 66.820093, t = 1455 ]
<Class_method5 [ m=spell, cpu = 66.920093, t = 1555 ]
<Class_method1 [ m=spell, cpu = 67.720093, t = 1955 ]
```
###### Output SPELL matrix:

```
[[ t = 2.0E12, n = 1, cpu = 0.05192600000000169 ][ t = 1.0E12, n = 1, cpu = 3.000000006636583E-6 ][ t = 1.0E12, n = 1, cpu = 1.0000100000000032 ][ t = 4.42E14, n = 1, cpu = 0.0799999999999983 ] _ ]
[[ t = 1.0E14, n = 1, cpu = 3.0001000000000033 ][ t = 4.0E13, n = 1, cpu = 3.000000000952241E-5 ][ t = 1.0E14, n = 1, cpu = 0.10000000000000853 ] _  _ ]
[[ t = 2.78E14, n = 1, cpu = 0.9000000000000057 ] _  _ [ t = 2.2E13, n = 1, cpu = 0.09999999999999432 ][ t = 1.0E14, n = 1, cpu = 0.09999999999999432 ]]
```


Contact and other information
--------------------------------------------------------------
- Rui Pereira {ruipereira@di.uminho.pt}
- Green Software Lab {greenlab@di.uminho.pt}