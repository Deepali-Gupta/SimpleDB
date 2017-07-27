SimpleDB Extension
===================
[SimpleDB](http://www.cs.bc.edu/~sciore/simpledb/intro.html) is a small database used only for academic purposes. It supports a restricted version of SQL and two data types – Integer (int) and String (varchar). 
This repository extends support for the Timestamp (timestamp) data type. The timestamp data type is useful whenever data records have temporal information associated with them. Given a time interval [t 1 , t 2 ], it is often required to efficiently retrieve all records with timestamp t such that t is between t 1 and t 2 . We specify such a query using the between keyword.
A B-Tree is an index data structure that allows efficient retrieval of records that correspond to a particular search key, or a range of search keys. SimpleDB has an existing implementation of the B-Tree. We extend this implementation to support timestamp data and subsequently use it to answer queries with the between keyword.

You can find the general documentation for SimpleDB [here](https://github.com/Deepali-Gupta/SimpleDB-extension/blob/master/manual.txt).

## Implementation Details

##### 1. Timestamp Data Type

- This repo supports the following data manipulation operations for this data type which stores temporal information (date and time) :
    - Create: You should be able to specify a column’s data type as timestamp. For e.g.,create table example (recordID int, recordTime timestamp);
    - Insert: You should be able to insert tuples having temporal data using INSERT statements. For e.g., insert into example(recordID, recordTime) values(1,‘2011-10-09 20:00:00’);
    - Delete: You should be able to support deletion of tuples with a specified timestamp. For e.g., delete from example where recordTime=‘2011-10-09 20:00:00’;
    - Update: You should be able to support updation of tuples with a specified timestamp. For e.g., update example set recordTime=‘2016-10-09 20:00:00’ where recordTime=‘2011-10-09 20:00:00’;
    - Select/Project: You should be able to query using the field with data type as timestamp. For e.g., select recordTime from example where recordID=3;
    or select recordID from example where recordTime=‘2011-10-09 20:00:00’;
- timestamp extends simpledb.query.Constant.java.
- The input and output format of the timestamp data type is ‘yyyy-MM-dd HH:mm:ss’. 

##### 2. Creation of BTree over Timestamp data type
- This implementation adapts the existing BTree implementation to support timestamp data and between queries. 
- A BTree index can be created as follows :
    - create index testindex on example(recordTime);
- The implementation also supports incremental inserts on the index, i.e., the index and the table should be updated as and when new data records are inserted or updated. 

##### 3. Answering between queries
- This implementation can be used to query for records with timestamps that fall within a given range. For e.g., the query, select recordID, recordTime
from example where recordTime between ‘2011-10-08 20:00:00’ ‘2011-10-09 22:00:00’; should return all tuples where the timestamp falls between ‘2011-10-08 20:00:00’ and ‘2011-10-09 22:00:00’ (Both inclusive).

##### 4. Error Handling
The code correctly identifies/handles the following types of errors : 
- InvalidIntervalError: When the between query involves timestamps t 1 and t 2 where t 1 > t 2 , the code identifies the invalid interval and report appropriate exception.
- InvalidDateFormatError: If the timestamps in a query have an invalid input format, for eg, ‘2016-23-31 23:59:59’ is an invalid date, then the code reports it as an InvalidDateFormatError. Note that SimpleDateFormat does not handle this.
- MemoryError: Fixes the maximum number of tuples in any relation to be 10 5 . If one attempts to insert more tuples, the code reports a MemoryError.

You can test the functioning of the implementation using the files present in the 'test' folder.
