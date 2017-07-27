SimpleDB Extension
===================
SimpleDB (http://www.cs.bc.edu/~sciore/simpledb/intro.html) is a small database used only for academic purposes. It supports a restricted version of SQL and two data types – Integer (int) and String (varchar). This repository extends support for the Timestamp (timestamp) data type. The timestamp
data type is useful whenever data records have temporal information associated with them. Given a time interval [t 1 , t 2 ], it is often required to efficiently retrieve all records with timestamp t such that t is between t 1 and t 2 . We specify such a query using the between keyword.
A B-Tree is an index data structure that allows efficient retrieval of records that correspond to a particular search key, or a range of search keys. SimpleDB has an existing implementation of the B-Tree. We also extend this implementation to support timestamp data and subsequently use it to answer queries with the between keyword.

You can find the installation instruction for SimpleDB here
