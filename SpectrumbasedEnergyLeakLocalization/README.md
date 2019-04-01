Introduction
--------------------------------------------------------------

This tool parses the SPELL matrix, and calculates the Oracle, Similarity, and Global Similarity.

How to use
--------------------------------------------------------------

After compiling the project, run the main class (sell.Main) with arg[0] as the path to the matrix file.


Example input/output
--------------------------------------------------------------

###### Input SPELL matrix

```
[ [ cpu = 37, n = 1, t = 75 ] [ cpu = 61, n = 2, t = 102 ] _ [ cpu = 42, n = 1, t = 34 ] ]
[ [ cpu = 38, n = 3, t = 77 ] [ cpu = 50, n = 1, t = 103 ] [ cpu = 34, n = 2, t = 42 ] [ cpu = 44, n = 1, t = 37 ] ]
[ [ cpu = 36, n = 1, t = 73 ] [ cpu = 58, n = 1, t = 102 ] [ cpu = 35, n = 1, t = 43 ] _ ]
[ [ cpu = 37, n = 3, t = 74 ] [ cpu = 66, n = 2, t = 105 ] _ [ cpu = 61, n = 2, t = 43 ] ]
[ [ cpu = 39, n = 2, t = 75 ] [ cpu = 54, n = 3, t = 100 ] [ cpu = 51, n = 4, t = 60 ] [ cpu = 65, n = 2, t = 60 ] ]
```
###### Output similarities:

```
Oracle
(140.0000) (166.0000) (129.0000) (164.0000) (209.0000) 
(4.0000) (7.0000) (3.0000) (7.0000) (11.0000) 
(211.0000) (259.0000) (218.0000) (222.0000) (295.0000) 
----------
Similarity
   C1       C2       C3       C4    
(0.2314) (0.3577) (0.1485) (0.2624) 
(0.3125) (0.2813) (0.2188) (0.1875) 
(0.3104) (0.4249) (0.1203) (0.1444) 
----------
Global Similarity
  C1     C2     C3     C4   
0.2466 0.4678 0.1450 0.1406 
```


Contact and other information
--------------------------------------------------------------
- Rui Pereira {ruipereira@di.uminho.pt}
- Green Software Lab {greenlab@di.uminho.pt}