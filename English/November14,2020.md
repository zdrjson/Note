CONCLUSION 
We have presented a production-ready, HTAP database: TiDB. TiDB is built on top of TiKV, a distributed, row-based store, which uses the Raft algorithm. We introduce columnar learners for realtime analysis, which asynchronously replicate logs from TiKV, and transform row-format data into column format. Such log replications between TiKV and TiFlash provides real-time data consistency with little overhead. TiKV and TiFlash can be deployed on separate physical resources to efficiently process both transactional and analytical queries. They can be optimally chosen by TiDB to be accessed when scanning tables for both transactional and analytical queries. Experimental results show TiDB performs well under an HTAP benchmark, CH-benCHmark. TiDB provides a generic solution to evolve NewSQL systems into HTAP systems.



